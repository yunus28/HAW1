import java.util.Stack;
import java.util.Collections;

import spielkarten.*;

/**
 * Ein Kartenstapel hält bis zu 32 Spielkarten eines Skatspiels 
 * auf einem Stapel.
 * 
 * @author Axel Schmolitzky 
 * @version 2018
 */
class Kartenstapel
{
    private Stack<Spielkarte> _stapel;
    
    /**
     * Initialisiert einen neuen Stapel mit allen Spielkarten eines Skatspiels in 
     * einer zufälligen Reihenfolge.
     * @param spiel das Skatspiel, dessen Spielkarten gemischt auf den Stapel kommen 
     */
    public Kartenstapel(Skatspiel spiel)
    {
        _stapel = new Stack<Spielkarte>();
        for (Spielkarte k : spiel)
        {
            _stapel.push(k);
        }
        Collections.shuffle(_stapel);
    }
    
    /**
     * Ein neuer Stapel hält alle Spielkarten eines Skatspiels in 
     * einer zufälligen Reihenfolge.
     */
    public Kartenstapel()
    {
        Skatspiel spiel = new Skatspiel();
        _stapel = new Stack<Spielkarte>();
        for (Spielkarte k : spiel)
        {
            _stapel.push(k);
        }
        Collections.shuffle(_stapel);
    }
    
    /**
     * Zieht die oberste Spielkarte von diesem Stapel, falls dieser nicht leer ist.
     * Anschließend enthält dieser Stapel eine Karte weniger.
     * @return die oberste Spielkarte
     * @throws IllegalStateException
     */
    public Spielkarte obersteKarteZiehen()
    {
        if (anzahlKarten() == 0)
        {
            throw new IllegalStateException();
        }
        return _stapel.pop();
    }

    /**
     * Zeige die oberste Spielkarte von diesem Stapel, falls dieser nicht leer ist.
     * Der Stapel wird nicht verändert.
     * @return die oberste Spielkarte
     * @throws IllegalStateException
     */
    public Spielkarte zeigeObersteKarte()
    {
        if (anzahlKarten() == 0)
        {
            throw new IllegalStateException();
        }
        return _stapel.peek();
    }

    /**
     * Liefert die Anzahl der noch auf diesem Stapel verfuegbaren Spielkarten.
     */
    public int anzahlKarten()
    {
        return _stapel.size();
    }
}
