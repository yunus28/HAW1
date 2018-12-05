package spielkarten;

/**
 * Exemplare dieser Klasse modellieren physische Spielkarten.
 * Eine Spielkarte ist immer mit einem Kartenbild "bedruckt".
 * Auf diese Weise kann es mehrere Karten mit dem gleichen
 * Kartenbild geben.
 * 
 * @author Axel Schmolitzky 
 * @version 2018
 */
public class Spielkarte
{ 
    private Kartenbild _bild;
    
    /**
     * Eine Spielkarte wird mit einem Kartenbild "bedruckt".
     */
    Spielkarte(Kartenbild bild)
    {
        _bild = bild;
    }
    
    /**
     * Liefert die Farbe dieser Spielkarte.
     */
    public Kartenfarbe farbe()
    {
        return _bild.farbe();
    }
    
    /**
     * Liefert den Rang dieser Spielkarte.
     */
    public Kartenrang rang() 
    {
        return _bild.rang();
    } 
    
    /**
     * Liefert das Kartenbild dieser Spielkarte.
     */
    public Kartenbild bild()
    {
        return _bild;
    }
    
    public String toString()
    {
        return _bild.toString();
    }
}
