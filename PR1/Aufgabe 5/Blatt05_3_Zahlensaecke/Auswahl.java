import java.util.Random;

/**
 * Diese Klasse implementiert den Zahlensack mittels eines Arrays.
 * Die Zahlen werden erst bei Bedarf zufaellig herausgepickt.
 * 
 * @author Fredrik Winkler, Christian Spaeh
 * @version 2018
 */
class Auswahl implements Zahlensack
{
    private final String _string;
    private final Random _zufall;
    private final int[] _sack;
    private int _anzahl;
    
    /**
     * @param groesse die Groesse des Zahlensacks
     */
    public Auswahl(int groesse)
    {
        _string = "Auswahl (" + groesse + ")";
        _zufall = new Random();
        _sack = new int[groesse];
        _anzahl = 0;
    }
    
    /**
     * @return die Groesse des Zahlensacks
     */
    public int gibGroesse()
    {
        return _sack.length;
    }

    /**
     * @return die Anzahl der Zahlen, die sich momentan im Zahlensack befinden
     */
    public int gibAnzahl()
    {
        return _anzahl;
    }
    
    /**
     * @return true, falls der Zahlensack leer ist
     */
    public boolean istLeer()
    {
        return _anzahl == 0;
    }
    
    /**
     * Fuellt den Zahlensack mit gibGroesse() verschiedenen Zufallszahlen
     * im halboffenen Intervall [0, gibGroesse)
     */
    private void fuelleSack()
    {
        _anzahl = _sack.length;
        for (int i=0; i<_anzahl; ++i)
        {
            _sack[i] = i;
        }
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
        final int i = _zufall.nextInt(_anzahl);
        final int zahl = _sack[i];
        _sack[i] = _sack[--_anzahl];
        return zahl;
    }
    
    /**
     * Verwirft alle uebrig gebliebenen Zahlen aus dem Zahlensack.
     * istLeer() liefert anschliessend true zurueck, und gibAnzahl() liefert 0.
     */
    public void leereSack()
    {
        _anzahl = 0;
    }
    
    /**
     * @return der verwendete Algorithmus sowie die Groesse des Zahlensacks
     */
    public String toString()
    {
        return _string;
    }
}
