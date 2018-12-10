package spielkarten;

import java.util.*;
import static spielkarten.Kartenbild.*;

/**
 * Ein Skatspiel besteht aus 32 Spielkarten mit den Rängen
 * SIEBEN bis AS. In einem Skatspiel kommt jedes Kartenbild
 * nur genau einmal vor.
 * 
 * @author Axel Schmolitzky 
 * @version 2018
 */
public class Skatspiel implements Iterable<Spielkarte>
{
    private Set<Spielkarte> _karten;
    
    /**
     * Initialisiert ein Skatspiel mit 32 neuen Spielkarten.
     */
    public Skatspiel()
    {
        _karten = new HashSet<Spielkarte>();
        _karten.add(new Spielkarte(H7));
        _karten.add(new Spielkarte(H8));
        _karten.add(new Spielkarte(H9));
        _karten.add(new Spielkarte(H10));
        _karten.add(new Spielkarte(HB));
        _karten.add(new Spielkarte(HD));
        _karten.add(new Spielkarte(HK));
        _karten.add(new Spielkarte(HA));

        _karten.add(new Spielkarte(KA7));
        _karten.add(new Spielkarte(KA8));
        _karten.add(new Spielkarte(KA9));
        _karten.add(new Spielkarte(KA10));
        _karten.add(new Spielkarte(KAB));
        _karten.add(new Spielkarte(KAD));
        _karten.add(new Spielkarte(KAK));
        _karten.add(new Spielkarte(KAA));

        _karten.add(new Spielkarte(P7));
        _karten.add(new Spielkarte(P8));
        _karten.add(new Spielkarte(P9));
        _karten.add(new Spielkarte(P10));
        _karten.add(new Spielkarte(PB));
        _karten.add(new Spielkarte(PD));
        _karten.add(new Spielkarte(PK));
        _karten.add(new Spielkarte(PA));

        _karten.add(new Spielkarte(KR7)); 
        _karten.add(new Spielkarte(KR8));
        _karten.add(new Spielkarte(KR9));
        _karten.add(new Spielkarte(KR10));
        _karten.add(new Spielkarte(KRB));
        _karten.add(new Spielkarte(KRD));
        _karten.add(new Spielkarte(KRK));
        _karten.add(new Spielkarte(KRA));
    }
    
    public Iterator<Spielkarte> iterator()
    {
        return _karten.iterator();
    }
    
}
     