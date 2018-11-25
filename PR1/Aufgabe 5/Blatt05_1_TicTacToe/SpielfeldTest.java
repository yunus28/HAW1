import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Eine Testklasse fuer Spielfeld-Klassen.
 *
 * @author Christian Spaeh, Fredrik Winkler, Axel Schmolitzky
 * @version 2017
 */
public class SpielfeldTest
{
    private Spielfeld _spielfeld;

    /**
     * Jede Testmethode arbeitet auf einem frisch erzeugten Test-Exemplar.
     * Im Konstruktor kann man also den erforderlichen Ausgangszustand
     * fuer die einzelnen Testmethoden herstellen, in diesem Fall ein neues Spielfeld.
     */
    public SpielfeldTest()
    {
        _spielfeld = new SpielfeldInteger();
    }

    /**
     * Wenn alle Positionen besetzt sind, solle das Spielfeld voll sein.
     * Vorher sollte es immer eine freie Position geben.
     */
    @Test
    public void testBefuelleSpielfeldKomplett()
    {
        for (int zeile = 0; zeile < 3; ++zeile)
        {
            for (int spalte = 0; spalte < 3; ++spalte)
            {
                assertFalse(_spielfeld.istVoll());
                _spielfeld.besetzePosition(zeile, spalte, 1);
            }
        }
        assertTrue(_spielfeld.istVoll());
    }

    /**
     * Wenn alle Positionen besetzt sind, solle das Spielfeld voll sein.
     * Vorher sollte es immer eine freie Position geben. Dieser Test
     * befuellt das Spielfeld von hinten nach vorne.
     */
    @Test
    public void testBefuelleSpielfeldKomplettRueckwaerts()
    {
        for (int zeile = 2; zeile >= 0; --zeile)
        {
            for (int spalte = 2; spalte >= 0; --spalte)
            {
                assertFalse(_spielfeld.istVoll());
                _spielfeld.besetzePosition(zeile, spalte, 1);
            }
        }
        assertTrue(_spielfeld.istVoll());
    }

    /**
     * Wenn neun Mal dieselbe Position besetzt wird,
     * sollte das Spielfeld nicht voll sein.
     */
    @Test
    public void testBesetzeNeunMalDieselbePosition()
    {
        for (int i = 0; i < 9; ++i)
        {
            _spielfeld.besetzePosition(0, 0, 1);
        }
        assertFalse(_spielfeld.istVoll());
    }

    /**
     * Schreibt in diesen Kommentar, was diese Methode testet:
     * 
     * 
     */
    @Test
    public void test3()
    {
        for (int zeile = 0; zeile < 3; ++zeile)
        {
            for (int spalte = 0; spalte < 3; ++spalte)
            {
                assertEquals(0, _spielfeld.gibBesitzer(zeile, spalte));

                _spielfeld.besetzePosition(zeile, spalte, 1);
                assertEquals(1, _spielfeld.gibBesitzer(zeile, spalte));

                _spielfeld.besetzePosition(zeile, spalte, 2);
                assertEquals(2, _spielfeld.gibBesitzer(zeile, spalte));

                _spielfeld.besetzePosition(zeile, spalte, 0);
                assertEquals(0, _spielfeld.gibBesitzer(zeile, spalte));
            }
        }
    }
}
