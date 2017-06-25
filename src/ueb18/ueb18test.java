import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ueb18test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ueb18test<T>
{
    private DoubleChainedList<Number> liste = new DoubleChainedList<Number>();

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        liste.add(600.30);
        liste.add(1000);
    }

    @Test
    public void anlegenInt(){
        liste.add(300);
    }
    
    @Test
    public void anlegenDouble(){
        liste.add(64.5);
    }
    
    @Test
    public void anlegenIntOther(){
        liste.add(0,60);
        assertEquals(liste.get(0), 60);
        assertEquals(liste.get(1), 600.30);
    }
    
    @Test
    public void containsTest(){
        assertEquals(liste.contains(1234), false);
    }
    
    @Test
    public void containsTrueTest(){
        liste.add(885);
        assertEquals(liste.contains(1000), true);
    }
    
    @Test
    public void indexOfTest(){
        liste.add(1, 22);
        assertEquals(liste.indexOf(22), 1);
    }
    
    @Test
    public void isEmptyTest(){
        assertEquals(liste.isEmpty(), false);
        liste.clear();
        assertEquals(liste.isEmpty(), true);
    }
    
    @Test
    public void removeTest(){
        assertEquals(liste.size(), 2);
        liste.remove(600.30);
        assertEquals(liste.size(), 1);
    }
    
    @Test
    public void removeTest2(){
        liste.remove(1);
        assertEquals(liste.contains(1000), false);
        assertEquals(liste.size(), 1);
    }
    
    @Test
    public void setTest(){
        liste.set(0, 2);
        assertEquals(liste.get(0), 2);
    }
    
    @Test
    public void sizeTest(){
        assertEquals(liste.size(), 2);
        liste.clear();
        liste.add(25);
        assertEquals(liste.size(), 1);
    }
    
    @Test
    public void clearTest(){
        liste.clear();
        assertEquals(liste.size(), 0);
        liste.add(145.88);
        liste.clear();
        assertEquals(liste.size(), 0);
    }
}