package ueb17;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IteratorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IteratorTest
{
    /**
     * Default constructor for test class IteratorTest
     */
    public IteratorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void IteratorTestWitf2x(){
        Iterator it = new Iterator();
        assertEquals(64.0, it.iterator(2,5,x->2*x), 0.00001);
    }
    
    @Test
    public void IteratorTestWitfxDividedBy2(){
        Iterator it = new Iterator();
        assertEquals(0.25, it.iterator(4,4,x->0.5*x), 0.00001);
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
