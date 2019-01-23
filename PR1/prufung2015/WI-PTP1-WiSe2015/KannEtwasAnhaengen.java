
/**
 * An ein Zugelement vom Typ KannEtwasAnhaengen koennen Zugteile
 * angehaengt werden.
 * 
 * @author Axel Schmolitzky 
 * @version WiSe 2015/16
 */
interface KannEtwasAnhaengen 
{
    /**
     * Ein beliebig langes Zugteil an dieses Zugelement anhaengen. 
     * Liefert true und haengt den Parameter an, wenn vorher noch kein
     * Zugteil angehaengt war.
     * Liefert false, wenn bereits etwas angehaengt war und ignoriert
     * den Parameter (veraendert den Zustand dieses Zugelements nicht).
     * @param kopfVomRest ein beliebig langes Zugteil
     * @return true, falls noch nichts angehaengt war, false sonst
     */
    boolean anhaengen(Anhaengbar kopfVomRest);
    
    /**
     * Liefert das Kopfelement des angehaengten Zugteils; kann null sein.
     */
    Anhaengbar gibAnhaenger();
    
    /**
     * Liefert die Anzahl der Zugelemente des Zugteils, von dem dieses
     * Zugelement selbst der Kopf ist. Das Ergebnis ist mindestens 1.
     */
    int anzahlZugelemente();
}
