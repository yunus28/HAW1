import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Diese Klasse testet den Wortschatz.
 *
 * @author Fredrik Winkler
 * @version 2018
 */
public class WortschatzTest
{
    private final Wortschatz _schatz;
    
    /**
     * Jede Testmethode arbeitet auf einem frisch erzeugten Exemplar.
     */
    public WortschatzTest()
    {
        _schatz = new HashWortschatz(new Delegation(), 10);
    }
    
    /**
     * Stellt sicher, dass ein neuer Wortschatz leer ist.
     */
    @Test
    public void testNeuerWortschatzIstLeer()
    {
        assertEquals(0, _schatz.anzahlWoerter());
    }

    /**
     * 
     */
    @Test
    public void testHinzugefuegtesWortIstEnthalten()
    {
    }
    
    /**
     * 
     */
    @Test
    public void testEntferntesWortIstNichtEnthalten()
    {
    }
    
    /**
     * 
     */
    @Test
    public void testNichtHinzugefuegtesWortIstNichtEnthalten()
    {
    }
    
    /**
     * 
     */
    @Test
    public void testDuplikateWerdenNichtHinzugefuegt()
    {
    }
    
    /**
     * 
     */
    @Test
    public void testEntfernenNichtEnthaltenerWoerterBewirktNichts()
    {
    }
}
