import java.util.*;

/**
 * Diese Klasse implementiert den Zahlensack mittels einer verketteten Liste und
 * einem shuffle-Algorithmus. Die Zahlen liegen bereits in zufaelliger Reihenfolge
 * im Zahlensack und muessen nur noch der Reihenfolge nach zurueckgegeben werden.
 * 
 * @author Fredrik Winkler, Christian Spaeh 
 * @version 2018
 */
class Permutation implements Zahlensack
{
    private final String _string;
    private final LinkedList<Integer> _sack;
    private final int _groesse;
    
    /**
     * @param groesse die Groesse des Zahlensacks
     */
    public Permutation(int groesse)
    {
        _string = "Permutation (" + groesse + ")";
        _sack = new LinkedList<Integer>();
        _groesse = groesse;
    }

    /**
     * @return die Groesse des Zahlensacks
     */
    public int gibGroesse()
    {
        return _groesse;
    }

    /**
     * @return die Anzahl der Zahlen, die sich momentan im Zahlensack befinden
     */
    public int gibAnzahl()
    {
        return _sack.size();
    }

    /**
     * @return true, falls der Zahlensack leer ist
     */
    public boolean istLeer()
    {
        return _sack.isEmpty();
    }

    /**
     * Fuellt den Zahlensack mit gibGroesse() verschiedenen Zufallszahlen
     * im halboffenen Intervall [0, gibGroesse)
     */
    private void fuelleSack()
    {
        leereSack();
        for (int i=0; i<_groesse; ++i)
        {
            _sack.add(i);
        }
        Collections.shuffle(_sack);
    }

    /**
     * Entfernt eine Zahl aus dem Zahlensack und liefert sie zurueck.
     * Danach ist der Zahlensack um ein Element kleiner.
     * Ausnahme: Falls der Zahlensack vor dem Aufruf leer ist,
     * wird er zuerst gefuellt, und nach dem Aufruf ist gibAnzahl() == gibGroesse()-1.
     *
     * @return eine zufaellige Zahl im halboffenen Intervall [0, gibGroesse)
     */
    public int entferneZahl()
    {
        if (istLeer())
        {
            fuelleSack();
        }
        return _sack.removeFirst();
    }
    
    /**
     * Verwirft alle uebrig gebliebenen Zahlen aus dem Zahlensack.
     * istLeer() liefert anschliessend true zurueck, und gibAnzahl() liefert 0.
     */
    public void leereSack()
    {
        _sack.clear();
    }
    
    /**
     * @return der verwendete Algorithmus sowie die Groesse des Zahlensacks
     */
    public String toString()
    {
        return _string;
    }
}
