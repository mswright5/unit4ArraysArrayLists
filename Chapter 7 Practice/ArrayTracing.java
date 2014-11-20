

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
    public void swapFirstAndLast() 
    {
        int index1 = this.values[0];
        this.values[0] = this.values[this.values.length - 1];
        this.values[this.values.length - 1] = index1;
    }
    
    /**Shifts every element in an ArrayList over to the right by one index*/
    public void shiftRight() 
    {
        int first = values[values.length - 1];
        for (int i = this.values.length - 1; i > 0; i--){
            this.values[i] = values[i-1];
        }
        values[0] = first;
    }
    
    public void replaceEvenWithZero()
    {
        for (int i = 0; i < values.length - 1; i++){
            if (values[i] % 2 == 0){values[i] = 0;}
        }
    }
    
    public String toString()
    {
        String str = "[ ";
        
        for (int i = 0; i < this.values.length; i++){
            if (i > 0) {str += ", ";}
            str += values[i];
        }
        
        str += " ]";
        return str;
    }

}
