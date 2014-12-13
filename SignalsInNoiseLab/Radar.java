

/**
 * The model for radar scan and accumulator
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class Radar
{
    
    // stores whether each cell triggered detection for the current scan of the radar and keeps a copy of the old one
    private boolean[][] currentScan;
    private boolean[][] prevScan;
    
    // keeps track of changes in dx and dy for the detection of the monster
    private int[][] accumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;
    private int monsterDX;
    private int monsterDY;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols, int dx, int dy, int startRow, int startCol)
    {
        // initialize instance variables
        currentScan = new boolean[rows][cols]; // elements will be set to false
        accumulator = new int[10][10]; // elements will be set to 0
        
        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method
        monsterLocationRow = startRow;
        monsterLocationCol = startCol;
        monsterDX = dx;
        monsterDY = dy;
        
        noiseFraction = 0.05;
        numScans = 0;
    }
    
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * @return  returns true if monster in no longer in the grid
     */
    public boolean scan()
    {
        // copy and zero the current scan grid
        for(int row = 0; row < currentScan.length; row++){
            for(int col = 0; col < currentScan[0].length; col++){
                if (currentScan[row][col] == true){prevScan[row][col] = true;}
                else{prevScan[row][col] = false;}
            }
        }
        
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                currentScan[row][col] = false;
            }
        }
        
        // update the monster and quits when it exits the grid
        if (monsterLocationRow >= 100 || monsterLocationCol >= 100){return true;}
        else{
            currentScan[monsterLocationRow][monsterLocationCol] = true;
            updateMonsterLocation();
        }
        
        // inject noise into the grid
        injectNoise();
        
        // udpate the accumulator
        for(int row = 0; row < currentScan.length; row++){
            for(int col = 0; col < currentScan[0].length; col++){
                if (currentScan[row][col] == true){
                    for (int prevRow = 0; prevRow < prevScan.length; prevRow++){
                        for (int prevCol = 0; prevCol < prevScan[0].length; prevCol++){
                            accumulator[row - prevRow][col -prevCol]+=1;
                        }
                    }
                }
            }
        }
        
        // keep track of the total number of scans
        numScans++;
        return false;
    }

    /**
     * Sets the location of the monster
     * 
     * @param   row     the row in which the monster is located
     * @param   col     the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(int row, int col)
    {
        // remember the row and col of the monster's location
        monsterLocationRow = row;
        monsterLocationCol = col;
        
        // update the radar grid to show that something was detected at the specified location
        currentScan[row][col] = true;
    }
    
    public void updateMonsterLocation()
    {
        monsterLocationRow += monsterDX;
        monsterLocationCol += monsterDY;
    }
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
    }
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(int row, int col)
    {
        return accumulator[row][col];
    }
    
    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }
    
    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }
    
    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }
    
    public int[] getMonsterVelocity()
    {
        int DX = 0;
        int DY = 0;
        int count = 0;
        for (int i = 0; i < accumulator.length; i++){
            for(int j = 0; j < accumulator[i].length; j++){
                if (accumulator[i][j] > count){
                    count = accumulator[i][j];
                    DX = i;
                    DY = j;
                }
            }
        }
        int[] velocity = {DX,DY};
        return velocity;
    }
    
    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
    }
    
}
