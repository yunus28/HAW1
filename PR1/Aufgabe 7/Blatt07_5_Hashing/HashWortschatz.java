/**
 * Ein Wortschatz ist eine Menge von Woertern.
 * Es koennen Woerter hinzugefuegt und entfernt werden, es kann abgefragt werden,
 * ob ein bestimmtes Wort im Wortschatz enthalten ist, und es kann die Anzahl
 * der gespeicherten Woerter abgefragt werden.
 * 
 * @author  (your name)
 * @version (a version number or a date)
 */
class HashWortschatz implements Wortschatz
{

    private WortListe[] _worte;
    HashWertBerechner _berechner;
    /**
     * Initialisiert ein neues Exemplar von HashWortschatz.
     * 
     * @param berechner der Berechner, welcher die Hashfunktion umsetzt
     * @param groesse die (initiale) Groesse der Hashtabelle
     */
    public HashWortschatz(HashWertBerechner berechner, int groesse)
    {
        _worte = new WortListe[groesse];
        initWortListe();
        _berechner = berechner;
    }
    
    private void initWortListe()
    {
        for (int i = 0; i < _worte.length; ++i)
        {
            _worte[i] = new WortListe();
        }
    }
    
    private int stringZuIndex(String wort)
    {
        if (_berechner.hashWert(wort) == Integer.MIN_VALUE)
        { //sehr lustig, musste lange suchen...
            return 666% (_worte.length);
        }
        return Math.abs(_berechner.hashWert(wort)) % (_worte.length);
    }
    
    /**
     * Fuege ein Wort zum Wortschatz hinzu, sofern es noch nicht enthalten ist.
     * 
     * @param wort das hinzuzufuegende Wort
     */
    public void fuegeWortHinzu(String wort)
    {
        entferneWort(wort); // keine dupplikate
        _worte[stringZuIndex(wort)].fuegeWortHinzu(wort);
    }
    
    /**
     * Entferne ein Wort aus dem Wortschatz, sofern es darin enthalten ist.
     * 
     * @param wort das zu entfernende Wort
     */
    public void entferneWort(String wort)
    {
        _worte[stringZuIndex(wort)].entferneWort(wort);
    }
    
    /**
     * Gib an, ob ein Wort im Wortschatz enthalten ist.
     * 
     * @param wort das zu ueberpruefende Wort
     * @return true, falls das Wort enthalten ist, false sonst
     */
    public boolean enthaeltWort(String wort)
    {
        return _worte[stringZuIndex(wort)].enthaeltWort(wort);
    }
    
    /**
     * Gib an, wieviele Woerter im Wortschatz enthalten sind.
     * 
     * @return die Anzahl der Woerter im Wortschatz
     */
    public int anzahlWoerter()
    {
        int woerter = 0;
        for (WortListe liste : _worte)
        {
            woerter += liste.anzahlWoerter();
        }
        return woerter;
    }

    /**
     * Schreibt den Wortschatz auf die Konsole (als Debugging-Hilfe gedacht).
     */
    public void schreibeAufKonsole()
    {
        for (WortListe liste : _worte)
        {
            System.out.println(liste);
        }
    }
    
    /**
     * Liefert den Fuellgrad (Verhaeltnis Woerter zur Groesse der Hash-Tabelle)
     */
    public int fuellgrad()
    {
        return (int) (anzahlWoerter()*100.0 / _worte.length);
    }
    
    /**
     * Liefert die laengste Kette an Ueberlaeufern.
     */
    public int laengsteKette()
    {
        int woerter = 0;
        WortListe laengsteKette = null;
        for (WortListe liste : _worte)
        {
            if (woerter < liste.anzahlWoerter())
            {
                woerter = liste.anzahlWoerter();
                laengsteKette = liste; // aufgabe sagt laengste kette 
                //zuruckgeben, aber da typ int, nicht genutzte variable
            }
        }
        return woerter;
    }
}
