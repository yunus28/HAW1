/**
 * Diese Klasse implementiert eine Liste von Woertern (Strings) mit einer doppelt
 * verketteten Liste.
 * 
 * @author (Dein Name und Deine Matrikelnummer)
 * @version WiSe 2017/18
 */
class LinkedWortListe implements WortListe
{
    // Der Kopf der verketteten Liste
    private DoppellinkKnoten _listenkopf;

    // Das Ende der verketteten Liste
    private DoppellinkKnoten _listenende;

    // Die logische Laenge der Liste (Kardinalitaet).
    private int _anzahlWoerter;

    /**
     * Initialisiert eine neue LinkedWortListe.
     */
    public LinkedWortListe()
    {
        // Diese Implementierung verwendet zwei Waechter-Knoten,
        // einen fuer den Listenanfang, einen fuer das Ende.
        // Sie markieren technisch die Grenzen der Liste und enthalten keine Woerter.
        // Sie erleichtern das Einfuegen und Entfernen von Woertern,
        // weil viele Sonderfaelle entfallen.
        _listenkopf = new DoppellinkKnoten();
        _listenende = new DoppellinkKnoten();
        _listenkopf.setzeNachfolger(_listenende);
        _listenende.setzeVorgaenger(_listenkopf);
        _anzahlWoerter = 0;
    }
    
    /**
     * Dreht die Reihenfolge der Elemente in der Liste um, so dass hinterher
     * das urspruenglich erste Wort am Ende steht und das urspruenglich letzte
     * am Anfang, das urspruenglich vorletzte an zweiter Stelle, etc.
     */
    public void invertieren()
    {
        DoppellinkKnoten a = _listenkopf;
        DoppellinkKnoten tmpwachter = _listenende;
        _listenende = _listenkopf;
        _listenkopf = tmpwachter;
        System.out.println(_anzahlWoerter);
        for (int i = 1; i <= _anzahlWoerter+2; ++i)
        {
            DoppellinkKnoten tmp = a.gibNachfolger();
            a.setzeNachfolger(a.gibVorgaenger());
            a.setzeVorgaenger(tmp);
            a = a.gibVorgaenger();
        }
    }

    /**
     * Fuege ein Wort an der Position <code>position</code> in die Wortliste
     * ein. Alle folgenden Eintraege werden um eine Position verschoben.
     * Wenn <code>position</code> gleich der Laenge der Wortliste ist, dann
     * fuege das <code>wort</code> am Ende an.
     * 
     * @param wort das einzufuegende Wort (darf nicht null sein).
     * @param position Die Position, an welcher das Wort eingefuegt werden soll.
     */
    public void fuegeEin(String wort, int position)
    {
        darfNichtNullSein(wort);
        mussGueltigeEinfuegepositionSein(position);

        DoppellinkKnoten rechts = knotenAnPosition(position);
        DoppellinkKnoten links = rechts.gibVorgaenger();
        DoppellinkKnoten neu = new DoppellinkKnoten(wort, links, rechts);
        links.setzeNachfolger(neu);
        rechts.setzeVorgaenger(neu);
        
        ++_anzahlWoerter;
    }
    
    private DoppellinkKnoten knotenAnPosition(int position)
    {
        DoppellinkKnoten result;
        if (position < _anzahlWoerter / 2)
        {
            result = knotenAnPositionAufsteigend(position);
        }
        else
        {
            result = knotenAnPositionAbsteigend(position);
        }
        return result;
    }

    private DoppellinkKnoten knotenAnPositionAufsteigend(int position)
    {
        DoppellinkKnoten knoten = _listenkopf;
        for (int i = 0; i <= position; ++i)
        {
            knoten = knoten.gibNachfolger();
        }
        return knoten;
    }

    private DoppellinkKnoten knotenAnPositionAbsteigend(int position)
    {
        DoppellinkKnoten knoten = _listenende;
        for (int i = _anzahlWoerter; i > position; --i)
        {
            knoten = knoten.gibVorgaenger();
        }
        return knoten;
    }

    /**
 * Pruefe, ob ein Wort in der Liste enthalten ist.
     * 
     * @param wort Das Wort, das in der Liste gesucht werden soll.
     * @return <code>true</code> wenn das Wort in der Liste ist,
     *         ansonsten <code>false</code>.
     */
    public boolean enthaelt(String wort)
    {
        darfNichtNullSein(wort);

        DoppellinkKnoten knoten = _listenkopf;
        while ((knoten = knoten.gibNachfolger()) != _listenende)
        {
            if (knoten.gibWort().equals(wort))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Gib das Wort an der angegebenen Position zurueck.
     * 
     * @param position Die Position des Worts, das zurueckgeben werden soll.
     * @return Das Wort an der Position <code>position</code>.
     */
    public String gibWort(int position)
    {
        mussGueltigePositionSein(position);

        return knotenAnPosition(position).gibWort();
    }

    /**
     * Entferne das Wort an der angegebenen Position. Alle folgenden Eintraege
     * werden um eine Position verschoben.
     * 
     * @param position Die Position des Worts, das entfernt werden soll.
     */
    public void entferne(int position)
    {
        mussGueltigePositionSein(position);
        
        DoppellinkKnoten knoten = knotenAnPosition(position);
        DoppellinkKnoten links = knoten.gibVorgaenger();
        DoppellinkKnoten rechts = knoten.gibNachfolger();
        links.setzeNachfolger(rechts);
        rechts.setzeVorgaenger(links);
        
        --_anzahlWoerter;
    }

    /**
     * Gib die Laenge der Liste zurueck.
     * 
     * @return Anzahl der Woerter in der Liste.
     */
    public int gibLaenge()
    {
        return _anzahlWoerter;
    }

    /**
     * Entferne alle Woerter aus der Liste.
     */
    public void leere()
    {
        _listenkopf.setzeNachfolger(_listenende);
        _listenende.setzeVorgaenger(_listenkopf);
        _anzahlWoerter = 0;
    }

    /**
     * Liefert true fuer alle gueltigen Positionen innerhalb der Liste.
     */
    public boolean istGueltigePosition(int position)
    {
        return (position >= 0) && (position < gibLaenge());
    }

    /**
     * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungueltige Position handelt.
     */
    private void mussGueltigePositionSein(int position)
    {
        if (!istGueltigePosition(position))
        {
            throw new IndexOutOfBoundsException(position + " ist keine gueltige Position");
        }
    }
    
    /**
     * Liefert true fuer alle gueltigen Einfuegepositionen innerhalb der Liste.
     */
    public boolean istGueltigeEinfuegeposition(int position)
    {
        return (position >= 0) && (position <= gibLaenge());
    }

    /**
     * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungueltige Einfuegeposition handelt.
     */
    private void mussGueltigeEinfuegepositionSein(int position)
    {
        if (!istGueltigeEinfuegeposition(position))
        {
            throw new IndexOutOfBoundsException(position + " ist keine gueltige Einfuegeposition");
        }
    }
    
    /**
     * Wirft eine IllegalArgumentException, falls die uebergebene Wort-Referenz null ist.
     */
    private static void darfNichtNullSein(String titel)
    {
        if (titel == null)
        {
            throw new IllegalArgumentException("Die Wort-Referenz darf nicht null sein.");
        }
    }
}
