import java.util.*;
/**
 * Write a description of class SpielfeldGeflecht here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SpielfeldGeflecht implements Spielfeld
{
    // instance variables - replace the example below with your own
    private Map<Integer,SpielfeldZeile> _zeilen;

    /**
     * Constructor for objects of class SpielfeldGeflecht
     */
    public SpielfeldGeflecht()
    {
        _zeilen = new HashMap<Integer, SpielfeldZeile>();
        _zeilen.put(0, new SpielfeldZeile());
        _zeilen.put(1, new SpielfeldZeile());
        _zeilen.put(2, new SpielfeldZeile());
    }

    private Spieler intZuSpieler(int a)
    {
        if (a==0) return Spieler.NIEMAND;
        if (a==1) return Spieler.P1;
        if(a==2) return Spieler.P2;
        return Spieler.NIEMAND;
    }
    
    private int spielerZuInt(Spieler a)
    {
        if (a==Spieler.NIEMAND) return 0;
        if (a==Spieler.P1) return 1;
        if (a==Spieler.P2) return 2;
        return 0;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        if(zeile<0 || zeile >2 || spalte<0 || spalte >2) throw new IllegalArgumentException();
        return    spielerZuInt(_zeilen.get(zeile).gibBesitzer(spalte)) ;
    }
    public void besetzePosition(int zeile, int spalte, int spieler)
    {
        if(zeile<0 || zeile >2 || spalte<0 || spalte >2 || spieler<0 || spieler >2) throw new IllegalArgumentException();
        _zeilen.get(zeile).besetze(spalte, intZuSpieler(spieler));
    }
    public boolean istVoll()
    {
     return (_zeilen.get(0).istVoll() && _zeilen.get(1).istVoll() && _zeilen.get(2).istVoll());
    }
    
}
