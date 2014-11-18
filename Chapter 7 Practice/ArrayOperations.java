/**
 * You know
 * 
 * @author Matts
 * @version November 18, 2014
 */
public class ArrayOperations
{
    private int[] values;

    public ArrayOperations()
    {
        int[] defaultValues = {8, 4, 5, 21, 7, 9, 18, 2, 100};
        values = defaultValues;
    }
    
    public static void main()
    {
        ArrayOperations array = new ArrayOperations();
        System.out.println(array.values.length);
        System.out.println(array.values[0]);
        System.out.println(array.values[array.values.length - 1]);
        //SO WE DECIDED WE ARE DONE
        for ( int val : array.values){System.out.println(val);}
    }

}
