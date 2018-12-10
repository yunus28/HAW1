import static org.junit.Assert.*;

import org.junit.Test;
/**
 * The test class TagTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TagTest
{
    /**
     * Testet, ob zwei Tag-Exemplare, die denselben Tag repraesentieren,
     * als gleich angesehen werden.
     */
    @Test
    public void testGleichheit()
    {
        Tag t1 = new Tag(20);
        Tag t2 = new Tag(20);
        assertEquals(t1,t2);
        assertEquals(t1.hashCode(),t2.hashCode());
    }
    
    /**
     * Testet, ob zwei Tag-Exemplare, die verschiedene Tage repraesentieren,
     * als ungleich angesehen werden.
     */
    @Test
    public void testUngleichheit()
    {
        Tag t1 = new Tag(21);
        Tag t2 = new Tag(20);
        assertNotEquals(t1,t2);
    }
}
