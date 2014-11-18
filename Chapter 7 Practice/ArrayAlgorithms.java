

/**
 * Write a description of class ArrayAlgorithms here.
 * 
 * @author Matt Wright
 * @version November 17, 2014
 */
public class ArrayAlgorithms
{
    /** description of instance variable x (add comment for each instance variable) */
    private int[] values;

    /**
     * Default constructor for objects of class ArrayAlgorithms
     */
    public ArrayAlgorithms()
    {
        values = new int[10];
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public String toString()
    {
        String str = "[ ";
        
        for (int i = 0; i< values.length; i++){
            
            if (i>0) {str += ", ";}
            
            str += values[i];
        }
        str += "]";
        return str;
    }
    
    public void fillWithSquares()
    {
        for (int i = 0; i< values.length; i++){values[i] = i * i;}
    }
    
    public double getAverage()
    {
        double sum = 0;
        
        for (int val : values){sum += val;}
        
        double average = sum / values.length;
        return average;
    }
    
    public int getIndexOfMaximum()
    {
        int maximumValue = values[0];
        int indexOfMaximum = 0;
        
        for (int i = 1; i < values.length; i++){
            if (values[i] > maximumValue){
                maximumValue = values[i];
                indexOfMaximum = i;
            }
        }
        
        return indexOfMaximum;
    }
}
