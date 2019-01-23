
/**
 * Write a description of class Waggon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Waggon implements Anhaengbar, KannEtwasAnhaengen
{
    private Anhaengbar _next;
    private int _personen;
    /**
     * Constructor for objects of class Waggon
     */
    public Waggon(int personen)
    {
        _next= null;
        _personen = personen;
    }
    
    /**
     * Liefere die Anzahl der Passagiere in diesem anhaengbaren
     * Zugteil.
     */
    public int anzahlPassagiere()
    {
        return _personen;
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
      

    
}
