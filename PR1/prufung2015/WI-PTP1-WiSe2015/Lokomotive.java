
/**
 * Write a description of class Lokomotive here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lokomotive implements KannEtwasAnhaengen
{
    private Anhaengbar _next;
    /**
     * Constructor for objects of class Lokomotive
     */
    public Lokomotive()
    {
        _next=null;
    }

    /**
     * Ein beliebig langes Zugteil an dieses Zugelement anhaengen. 
     * Liefert true und haengt den Parameter an, wenn vorher noch kein
     * Zugteil angehaengt war.
     * Liefert false, wenn bereits etwas angehaengt war und ignoriert
     * den Parameter (veraendert den Zustand dieses Zugelements nicht).
     * @param kopfVomRest ein beliebig langes Zugteil
     * @return true, falls noch nichts angehaengt war, false sonst
     */
    public boolean anhaengen(Anhaengbar kopfVomRest)
    {
        if (_next==null)
        {
            _next = kopfVomRest;
            return true;
        }
        return false;
    }
    
    /**
     * Liefert das Kopfelement des angehaengten Zugteils; kann null sein.
     */
    public Anhaengbar gibAnhaenger()
    {
        return _next;
    }
    
    /**
     * Liefert die Anzahl der Zugelemente des Zugteils, von dem dieses
     * Zugelement selbst der Kopf ist. Das Ergebnis ist mindestens 1.
     */
    public int anzahlZugelemente()
    {
        if(_next==null)
        {
            return 1;
        }
        return 1 + _next.anzahlZugelemente();
    }
}
