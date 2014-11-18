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
        int swappedList[] = {25,4,9,16,1};
        for (int i = 0; i< 5; i++){
            assert(array.getValues()[i] == swappedList[i]);
        }
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
