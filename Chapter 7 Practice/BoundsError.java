/**
 * Write a description of class BoundsError here.
 * 
 * @author Matt Wright 
 * @version November 13, 2014
 */
public class BoundsError
{
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
    public static void main(String[] args)
    {
        int[] scores = new int[10];
        for (int i = 0; i<scores.length; i++)
        {
            scores[i] = i+1;
        }
        
    }

}
