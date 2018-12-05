package spielkarten;



import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Die Test-Klasse KartentripelTest.
 *
 * @author  (Dein Name)
 * @version (Versionsnummer oder Datum)
 */
public class KartentripelTest
{
    /**
     * Konstruktor: Initialisierungen fuer jeden Testfall
     */
    public KartentripelTest()
    {
    }

    /**
     * Eine Test-Methode pro Testfall, jeweils markiert mit @Test
     */
    @Test
    public void test3dazu3auslesen()
    {
        Spielkarte k1 = new Spielkarte(Kartenbild.HD);
        Spielkarte k2 = new Spielkarte(Kartenbild.KAK);
        Spielkarte k3 = new Spielkarte(Kartenbild.PB);
        Kartentripel kt = new Kartentripel(k1, k2 , k3);
        assertEquals (k1, kt.gibkarteIndex(1));
        assertEquals (k2, kt.gibkarteIndex(2));
        assertEquals (k3, kt.gibkarteIndex(3));
        
    }
    @Test
    public void testDuplikateErlaubt()
    {
        Spielkarte k1 = new Spielkarte(Kartenbild.HD);
        Spielkarte k2 = new Spielkarte(Kartenbild.KAK);
        Kartentripel kt = new Kartentripel(k1, k2 , k2);
        assertEquals (k1, kt.gibkarteIndex(1));
        assertEquals (k2, kt.gibkarteIndex(2));
        assertEquals (k2, kt.gibkarteIndex(3));
        
    }
    @Test (expected = IllegalArgumentException.class)
    public void testNulluebergeben()
    {
        Spielkarte k1 = new Spielkarte(Kartenbild.HD);
        Spielkarte k2 = new Spielkarte(Kartenbild.KAK);
        Kartentripel kt = new Kartentripel(k1, k2 , null);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFalscherIndex()
    {
        Spielkarte k1 = new Spielkarte(Kartenbild.HD);
        Spielkarte k2 = new Spielkarte(Kartenbild.KAK);
        Spielkarte k3 = new Spielkarte(Kartenbild.PB);
        Kartentripel kt = new Kartentripel(k1, k2 , k3);
        assertEquals (k1, kt.gibkarteIndex(0));
    }

}