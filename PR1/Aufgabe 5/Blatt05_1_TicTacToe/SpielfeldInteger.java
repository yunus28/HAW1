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
        //00->unbesetzt, 01->sp1, 10->sp2
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
        return (_feld>>index)%3;
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
        int mask = 0;
        if (gibBesitzer(zeile, spalte) == 0)
        {
            if (spieler==1)
            {
                mask = 0b01;
            } else if (spieler==2)
            {
                mask = 0b10;
            }
        }
        mask = mask<<index;
        //_feld = _feld & (0b00<<index);
        _feld = _feld | (mask<<index);
    }
    
    private int berechneIndex (int zeile, int spalte)
    {
        return (zeile*3+spalte)*2;
    }
    
    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        
        return false;
    }
}
