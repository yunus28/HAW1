

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse TesteAuswahl.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TesteAuswahl
{
    private Zahlensack _zahlensack;
    /**
     * Konstruktor fuer die Test-Klasse TesteAuswahl
     */
    public TesteAuswahl()
    {
    }

    private Zahlensack gibZahlenSack(int groesse)
    {
        return new Auswahl(groesse);
    }
    
    /**
     * Testet die Methode gibGroesse() indem sie einen Sack einer bestimmten Groesse
     * erzeugt und kontrolliert, ob sie die entsprechende Gresse zurueck gibt.
     *
     */
    @Test
    public void testeGibGroesse()
    {
        _zahlensack = gibZahlenSack(0);
        assertEquals(0,_zahlensack.gibGroesse());
        _zahlensack = gibZahlenSack(1);
        assertEquals(1,_zahlensack.gibGroesse());
        _zahlensack = gibZahlenSack(3);
        assertEquals(3,_zahlensack.gibGroesse());
    }
    
    /**
     * Testet die Methode gibAnzahl() indem sie einen Sack einer bestimmten Groesse
     * erzeugt, eine Zahl entfernt und kontrolliert, ob noch die richtige Anzahl Zahlen
     * im Sack ist.
     */
    @Test
    public void testeGibAnzahl()
    {
        _zahlensack = gibZahlenSack(1);
        _zahlensack.entferneZahl();
        assertEquals(0,_zahlensack.gibAnzahl());
        _zahlensack.entferneZahl();
        assertEquals(1,_zahlensack.gibGroesse());
    }
    
    /**
     * Testet die Methode istLeer().
     *
     */
    @Test
    public void testeIstLeer()
    {
        _zahlensack = gibZahlenSack(0);
        assertTrue(_zahlensack.istLeer());
        
        _zahlensack = gibZahlenSack(2);
        _zahlensack.entferneZahl();        
        _zahlensack.entferneZahl();        
        assertTrue(_zahlensack.istLeer());
    }
    
    /**
     * Testet ob nur gueltige werte aus dem Sack gezogen werden.
     *
     */
    @Test
    public void testeEntferneZahlAufRueckgabe()
    {
        _zahlensack = gibZahlenSack(54);
        for (int i = 0; i<100; i++)
        {
            int z = _zahlensack.entferneZahl();
            assertTrue (z>=0 && z<54);
        }
    }
    
    /**
     * testet den index bei vielen ziehungen, mit ueberlauf
     */
    @Test
    public void testeEntferneZahlMitGibAnzahl()
    {
        _zahlensack = gibZahlenSack(54);
        for (int i = 0; i<100; i++)
        {
            int z = _zahlensack.entferneZahl();
            assertEquals((53 - i%54), _zahlensack.gibAnzahl());
        }
    }
    
    /**
     * Testet die Methode istLeer().
     *
     */
    @Test
    public void testeLeereSack()
    {
        _zahlensack = gibZahlenSack(10);
        _zahlensack.leereSack();
        assertTrue(_zahlensack.istLeer());
    }
}
