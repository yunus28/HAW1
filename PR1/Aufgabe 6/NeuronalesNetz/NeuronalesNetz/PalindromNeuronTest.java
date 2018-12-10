

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PalindromNeuronTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PalindromNeuronTest
{
    @Test
    public void testCaseSensitive()
    {
        PalindromNeuron pn = new PalindromNeuron(true);
        pn.eingangHinzufuegen(new Signal("AxA")); //kleines
        pn.eingangHinzufuegen(new Signal("AxsxA")); //langes
        pn.eingangHinzufuegen(new Signal("aAxsxaa")); //kein palindrom
        pn.eingangHinzufuegen(new Signal("Esel")); 
        assertEquals("AxsxA", pn.getAusgangswert());
    }
    @Test
    public void testNICHTCaseSensitive()
    {
        PalindromNeuron pn = new PalindromNeuron(false);
        pn.eingangHinzufuegen(new Signal("AxA")); 
        pn.eingangHinzufuegen(new Signal("AxsxA")); 
        pn.eingangHinzufuegen(new Signal("aAxsxaa")); //HIER JA palindrom
        pn.eingangHinzufuegen(new Signal("Esel")); 
        assertEquals("aAxsxaa", pn.getAusgangswert());
    }
    
    @Test
    public void testLeer()
    {
        PalindromNeuron pn = new PalindromNeuron(false);
        assertEquals(null, pn.getAusgangswert());
    }
}
