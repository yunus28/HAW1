

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KettenNeuronTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KettenNeuronTest
{
    KettenNeuron _kn;
    
    public KettenNeuronTest()
    {
        _kn = new KettenNeuron();
    }

    @Test
    public void testPDF()
    {
        PalindromNeuron pntrue = new PalindromNeuron(true);
        PalindromNeuron pnfalse = new PalindromNeuron(false);
        
        Neuron signal;
        signal = new Signal ("axa");
        pntrue.eingangHinzufuegen(signal);       
        pnfalse.eingangHinzufuegen(signal);
        signal = new Signal ("Hallo");
        pntrue.eingangHinzufuegen(signal);       
        pnfalse.eingangHinzufuegen(signal);
        signal = new Signal ("Regallager");
        pntrue.eingangHinzufuegen(signal);       
        pnfalse.eingangHinzufuegen(signal);
        
        _kn.eingangHinzufuegen(pntrue);        
        _kn.eingangHinzufuegen(pnfalse);
        
        assertEquals("axa Regallager", _kn.getAusgangswert());
        assertEquals("axa Regallager axa Regallager", _kn.getAusgangswert());
        
        
    }
    
    @Test
    public void test2()
    {
        _kn.eingangHinzufuegen(new Signal("Hallo"));
        _kn.eingangHinzufuegen(new Signal("wie"));
        _kn.eingangHinzufuegen(new Signal("gehts"));
        assertEquals("Hallo wie gehts", _kn.getAusgangswert());
        
        _kn.eingangHinzufuegen(new Signal("gut"));
        _kn.eingangHinzufuegen(new Signal("und"));
        _kn.eingangHinzufuegen(new Signal("selbst?"));
        assertEquals("Hallo wie gehts Hallo wie gehts gut und selbst?", _kn.getAusgangswert());
    }
}
