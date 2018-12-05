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
        return (_feld>>index) & 0b11; //schiebt wichtige bits auf pos 0,1 und löscht alle anderen mit AND
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
        if (gibBesitzer(zeile, spalte)!=0) //löscht ehemaligen wert
        {
            int maskXOR = gibBesitzer(zeile, spalte)<<index;
            _feld = _feld ^ maskXOR;
        }
        int mask = spieler<<index;
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
            if (((_feld>>i) & 0b11) == 0) //feld um 2 bits kuerzen, mit AND nur diese mit 0 vergleichen
            {
                return false;
            }
        }
        return true;
    }
}
