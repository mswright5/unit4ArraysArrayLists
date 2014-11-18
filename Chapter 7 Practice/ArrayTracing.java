

/**
 * Performs various functions on an integer array.
 * 
 * @author The two Matts
 * @version November 14
 */
public class ArrayTracing
{
    private int[] values;
   
    public ArrayTracing(int[] initialValues) {values = initialValues;}
    
    /**
     * Swaps the first and last indexes of an Array object 
     */
    public void swapFirstAndLast() {
        int index1 = this.values[0];
        this.values[0] = this.values[this.values.length - 1];
        this.values[this.values.length - 1] = index1;
    }
    
    /**Shifts every element in an ArrayList over to the right by one index*/
    public void shiftRight() {
        
    }
    
    /**
     * Main method that does everything, if you don't know the main method 
     * by now you shouldn't be reading this
     */
    public static void main(String[] args)
    {
        
        
    }
    
    public int[] getValues(){return this.values;}

}
