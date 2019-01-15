/**
 * Ein Wortschatz ist eine Menge von Woertern. Dieses Interface definiert
 * geeignete Operationen auf einer solchen Menge:
 * Es koennen Woerter hinzugefuegt und entfernt werden, es kann abgefragt werden,
 * ob ein bestimmtes Wort im Wortschatz enthalten ist, und es kann die Anzahl
 * der gespeicherten Woerter abgefragt werden.
 * 
 * @author Fredrik Winkler, Petra Becker-Pechau, Axel Schmolitzky
 * @version September 2018
 */
interface Wortschatz
{
    /**
     * Fuege ein Wort zum Wortschatz hinzu, sofern es noch nicht enthalten ist.
     * 
     * @param wort das hinzuzufuegende Wort
     */
    public void fuegeWortHinzu(String wort);

    /**
     * Entferne ein Wort aus dem Wortschatz, sofern es darin enthalten ist.
     * 
     * @param wort das zu entfernende Wort
     */
    public void entferneWort(String wort);
    
    /**
     * Gib an, ob ein Wort im Wortschatz enthalten ist.
     * 
     * @param wort das zu ueberpruefende Wort
     * @return true, falls das Wort enthalten ist, false sonst
     */
    public boolean enthaeltWort(String wort);
    
    /**
     * Gib an, wieviele Woerter im Wortschatz enthalten sind.
     * 
     * @return die Anzahl der Woerter im Wortschatz
     */
    public int anzahlWoerter();
}
