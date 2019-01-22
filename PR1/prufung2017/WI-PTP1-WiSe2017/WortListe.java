
/**
 * Dieses Interface spezifiziert eine Liste von Wörtern (Strings).
 * 
 * @author Axel Schmolitzky 
 * @version SoSe 2014
 */
interface WortListe
{
    /**
    * Dreht die Reihenfolge der Elemente in der Liste um, so dass hinterher
    * das urspruenglich erste Wort am Ende steht und das urspruenglich letzte
    * am Anfang, das urspruenglich vorletzte an zweiter Stelle, etc.
    */
   public void invertieren();

   /**
    * Fuege ein Wort an der Position <code>position</code> in die Wortliste
    * ein. Alle folgenden Eintraege werden um eine Position verschoben.
    * Wenn <code>position</code> gleich der Laenge der Wortliste ist, dann
    * fuege das <code>wort</code> am Ende an.
    * 
    * @param wort das einzufuegende Wort (darf nicht null sein).
    * @param position Die Position, an welcher das Wort eingefuegt werden soll.
    */
    public void fuegeEin(String wort, int position);
    
   /**
     * Pruefe, ob ein Wort in der Liste enthalten ist.
     * 
     * @param wort Das Wort, das in der Liste gesucht werden soll.
     * @return <code>true</code> wenn das Wort in der Liste ist,
     *         ansonsten <code>false</code>.
     */
    public boolean enthaelt(String wort);

   /**
    * Gib das Wort an der angegebenen Position zurueck.
    * 
    * @param position Die Position des Worts, das zurueckgeben werden soll.
    * @return Das Wort an der Position <code>position</code>.
    */
    public String gibWort(int position);

    /**
     * Entferne das Wort an der angegebenen Position. Alle folgenden Eintraege
     * werden um eine Position verschoben.
     * 
     * @param position Die Position des Worts, das entfernt werden soll.
     */
    public void entferne(int position); 
    
    /**
     * Gib die Laenge der Liste zurueck.
     * 
     * @return Anzahl der Woerter in der Liste.
     */
    public int gibLaenge();

    /**
     * Entferne alle Woerter aus der Liste.
     */
    public void leere();
    
}

