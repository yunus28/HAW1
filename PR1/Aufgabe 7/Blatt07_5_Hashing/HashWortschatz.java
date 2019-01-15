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

    /**
     * Initialisiert ein neues Exemplar von HashWortschatz.
     * 
     * @param berechner der Berechner, welcher die Hashfunktion umsetzt
     * @param groesse die (initiale) Groesse der Hashtabelle
     */
    public HashWortschatz(HashWertBerechner berechner, int groesse)
    {
    }
    
    /**
     * Fuege ein Wort zum Wortschatz hinzu, sofern es noch nicht enthalten ist.
     * 
     * @param wort das hinzuzufuegende Wort
     */
    public void fuegeWortHinzu(String wort)
    {
    }
    
    /**
     * Entferne ein Wort aus dem Wortschatz, sofern es darin enthalten ist.
     * 
     * @param wort das zu entfernende Wort
     */
    public void entferneWort(String wort)
    {
    }
    
    /**
     * Gib an, ob ein Wort im Wortschatz enthalten ist.
     * 
     * @param wort das zu ueberpruefende Wort
     * @return true, falls das Wort enthalten ist, false sonst
     */
    public boolean enthaeltWort(String wort)
    {
        return false;
    }
    
    /**
     * Gib an, wieviele Woerter im Wortschatz enthalten sind.
     * 
     * @return die Anzahl der Woerter im Wortschatz
     */
    public int anzahlWoerter()
    {
        return 0;
    }

    /**
     * Schreibt den Wortschatz auf die Konsole (als Debugging-Hilfe gedacht).
     */
    public void schreibeAufKonsole()
    {
    }
    
    /**
     * Liefert den Fuellgrad (Verhaeltnis Woerter zur Groesse der Hash-Tabelle)
     */
    public int fuellgrad()
    {
        return 0;
    }
    
    /**
     * Liefert die laengste Kette an Ueberlaeufern.
     */
    public int laengsteKette()
    {
        return 0;
    }
}
