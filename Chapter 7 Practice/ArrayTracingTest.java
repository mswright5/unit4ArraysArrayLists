import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests ArrayTracing Class
 * 
 * @author The two Matts
 * @version November 14, 2014
 */
public class ArrayTracingTest
{
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }
    
    /**
     * Tests the swapFirstAndLast method
     */
    @Test
    public void swapFirstAndLastTest(){
        int initialValues[] = {1,4,9,16,25};
        ArrayTracing array = new ArrayTracing(initialValues);
        
        array.swapFirstAndLast();
        String compare = "[ ";
        for (int i = 0; i < initialValues.length; i++){
            System.out.println(initialValues[i]);
            if (i > 0) {compare += ", ";}
            compare += initialValues[i];
        }
        
        compare += " ]";
        
        assert(array.toString().equals(compare));
    }
    
    /**
     * Shifts all numbers over by one index
     */
    @Test
    public void shiftRightTest(){
        int initialValues[] = {1,4,9,16,25};
        ArrayTracing array = new ArrayTracing(initialValues);
        
        array.shiftRight();
        
        int[] shifted = {25,1,4,9,16};
        String compare = "[ ";
        for (int i = 0; i < shifted.length; i++){
            if (i > 0) {compare += ", ";}
            compare += shifted[i];
        }
        
        compare += " ]";
        
        assert(array.toString().equals(compare));
    }
    
    /**
     * Replaces all even numbers with zero
     */
    @Test
    public void replaceEvenWithZeroTest()
    {
        int initialValues[] = {1,4,9,16,25};
        ArrayTracing array = new ArrayTracing(initialValues);
        
        array.replaceEvenWithZero();
        initialValues[1] = 0;
        initialValues[3] = 0;
        
        String compare = "[ ";
        for (int i = 0; i < initialValues.length; i++){
            if (i > 0) {compare += ", ";}
            compare += initialValues[i];
        }
        
        compare += " ]";
        
        assert(compare.equals(array.toString()));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

}
