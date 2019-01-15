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
        _schatz.fuegeWortHinzu("Hallo");
        assertEquals(true ,_schatz.enthaeltWort("Hallo"));
    }
    
    /**
     * 
     */
    @Test
    public void testEntferntesWortIstNichtEnthalten()
    {
        _schatz.fuegeWortHinzu("Hallo");
        _schatz.entferneWort("Hallo");
        assertEquals(false ,_schatz.enthaeltWort("Hallo"));
    }
    
    /**
     * 
     */
    @Test
    public void testNichtHinzugefuegtesWortIstNichtEnthalten()
    {
        assertEquals(false ,_schatz.enthaeltWort("Hallo"));
        assertEquals(false ,_schatz.enthaeltWort(""));
    }
    
    /**
     * 
     */
    @Test
    public void testDuplikateWerdenNichtHinzugefuegt()
    {
        _schatz.fuegeWortHinzu("Hallo");
        assertEquals(1, _schatz.anzahlWoerter());
        assertEquals(true ,_schatz.enthaeltWort("Hallo"));
        
        _schatz.fuegeWortHinzu("Hallo");
        assertEquals(1, _schatz.anzahlWoerter());
        
        _schatz.entferneWort("Hallo");
        assertEquals(false ,_schatz.enthaeltWort("Hallo"));
        assertEquals(0, _schatz.anzahlWoerter());
    }
    
    /**
     * 
     */
    @Test
    public void testEntfernenNichtEnthaltenerWoerterBewirktNichts()
    {
        _schatz.fuegeWortHinzu("Hallo");
        _schatz.entferneWort("awasdkjh");
        assertEquals(true ,_schatz.enthaeltWort("Hallo"));
    }
}
