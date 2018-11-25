/**
 * Beschreibe hier die Klasse SpielfeldInteger.
 * 
 * @author (Dein Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class SpielfeldInteger implements Spielfeld
{
    int _feld;
    
    public SpielfeldInteger ()
    {
        _feld = 0b00_0000_0000_0000_0000; //2Bit pro Feld
        //00->unbesetzt, 1=0b01->sp1, 2=0b10->sp2
    }
    
    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        int index = berechneIndex(zeile, spalte);
        return (_feld>>index) & 0b11;
    }
    
    /**
     * Besetzt die angegebene Position auf dem Spielfeld fuer einen Spieler.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @param spieler
     *            0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetzePosition(int zeile, int spalte, int spieler)
    {
        int index = berechneIndex(zeile, spalte);
        if (gibBesitzer(zeile, spalte)!=0)
        {
            int maskXOR = gibBesitzer(zeile, spalte)<<index;
            _feld = _feld ^ maskXOR;
        }
        int mask = spieler<<index;
        // if (spieler==0)
        // {
            // int hintereMask= Math.pow(2, index)-1;
            // int vorderemask = _feld>>(index+2)
        // }
        // if (spieler==1)
        // {
            // mask = 0b01<<index;
        // } else if (spieler==2)
        // {
            // mask = 0b10<<index;
        // }
        //_feld = _feld & (0b00<<index);
        _feld = _feld | mask;
    }
    
    private int berechneIndex (int zeile, int spalte)
    {
        return (zeile*3+spalte)*2; //0,2,4,6,8,10,12,14,16
    }
    
    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        for (int i = 0; i<=16; i+=2)
        {
            if (((_feld>>i) & 0b11) == 0)
            {
                return false;
            }
        }
        return true;
    }
}
