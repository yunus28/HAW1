import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Diese Klasse modelliert einfache Wort-Listen, ueber die mit
 * der erweiterten for-Schleife iteriert werden kann.
 * <BR>
 * Duplikate sind zugelassen (wie immer bei Listen), so dass ein
 * Klient sich bei Bedarf selbst um ihre Vermeidung kuemmern muss.
 * 
 * @author Fredrik Winkler, Petra Becker-Pechau, Axel Schmolitzky
 * @version 2018
 */
class WortListe implements Iterable<String>
{
    private final List<String> _liste;

    /**
     * Konstruktor fuer Objekte der Klasse WortListe
     */
    public WortListe()
    {
        _liste = new ArrayList<String>();
    }

    /**
     * Fuege der Liste ein Wort hinzu.
     * @param wort das hinzuzufuegende Wort
     */
    public void fuegeWortHinzu(String wort)
    {
        _liste.add(wort);
    }

    /**
     * Loesche ein Wort aus der Liste.
     * @param wort das zu loeschende Wort
     * @return true, sofern das Wort vorher enthalten war und somit entfernt wurde, false sonst
     */
    public boolean entferneWort(String wort)
    {
        return _liste.remove(wort);
    }
    
    /**
     * Pruefe, ob das Wort in der Liste enthalten ist.
     * @true, falls das Wort in der Liste enthalten ist
     */
    public boolean enthaeltWort(String wort)
    {
        return _liste.contains(wort);
    }
    
    /**
     * Gib die Anzahl der Woerter in der Liste.
     * @return die Anzahl der Woerter in der Liste
     */
    public int anzahlWoerter()
    {
        return _liste.size();
    }

    /**
     * Liefere das Wort mit dem Index index.
     * @param index der Index
     */
    public String gibWort(int index)
    {
        return _liste.get(index);
    }
    
    /**
     * Liefere einen Iterator ueber die Liste der Woerter.
     * @return den Iterator
     */
    public Iterator<String> iterator()
    {
        return _liste.iterator();
    }
    
    /**
     * Liefere eine String-Repraesentation der Liste.
     * @return eine String-Repraesentation der Liste
     */
    public String toString()
    {
        return _liste.toString();
    }
}
