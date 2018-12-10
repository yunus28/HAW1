import spielkarten.*;

/**
 * Ein KartenTripel besteht aus drei Karten.
 * 
 * @author Axel Schmolitzky 
 * @version 2017
 */
class KartenTripel
{
    private Spielkarte _karte1;
    private Spielkarte _karte2;
    private Spielkarte _karte3;

    /**
     * Initialisiert ein Kartentripel mit drei Karten.
     * Die uebergebenen Karten duerfen paarweise nicht gleich sein.
     * @param k1 die erste Spielkarte; darf nicht null sein
     * @param k2 die zweite Spielkarte; darf nicht null sein
     * @param k3 die dritte Spielkarte; darf nicht null sein
     * @throw IllegalArgumentException
     */
    public KartenTripel(Spielkarte k1, Spielkarte k2, Spielkarte k3)
    {
        if (k1 == null || k2 == null || k3 == null
         || k1 == k2   || k2 == k3   || k1 == k3)
        {
            throw new IllegalArgumentException();
        }
        _karte1 = k1;
        _karte2 = k2;
        _karte3 = k3;
    }
    
    /**
     * @return eine Referenz auf eine Spielkarte (ungleich null).
     */
    public Spielkarte gibKarte1()
    {
        return _karte1;
    }

    /**
     * @return eine Referenz auf eine Spielkarte (ungleich null).
     */
    public Spielkarte gibKarte2()
    {
        return _karte2;
    }

    /**
     * @return eine Referenz auf eine Spielkarte (ungleich null).
     */
    public Spielkarte gibKarte3()
    {
        return _karte3;
    }
    
}
