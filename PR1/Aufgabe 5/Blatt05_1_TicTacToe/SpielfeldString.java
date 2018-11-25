/**
 * Beschreibe hier die Klasse SpielfeldString.
 * 
 * @author (Dein Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class SpielfeldString implements Spielfeld
{
    private String _feld;
    
    /**
     * Erstellt ein leeres Spielfeld
     */
    public SpielfeldString ()
    {
        _feld = "000000000"; //9 0en, 1->spieler1 2->spieler2
        //xyz000000 x=erste Zeile & spalte, y 2.spalte
        //000xyz000 x=zweite Zeile & spalte, y 2.spalte
        //000000xyz x= dritte zeile & spalte, y 2.spalte
        //   0 1 2
        // 0 0 1 2
        // 1 3 4 5
        // 2 6 7 8
        
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
        char c = _feld.charAt(index);
        
        int a = Integer.parseInt(String.valueOf(c));
        return a;
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
        //eingabewerte auf gueltigkeit prufen
        if (zeile>=0 && zeile <3 &&spalte>=0 && spalte <3 &&spieler>=0 && spieler <3)
        {
            int index = berechneIndex(zeile, spalte);
            char c = _feld.charAt(index);
            besetzePosition(spieler, index);
        }
    }
    private int berechneIndex (int zeile, int spalte)
    {
        return zeile*3+spalte;
    }
    private void besetzePosition(int spieler, int index)
    {
        String s1 = _feld.substring(0, index);
        String s2 = _feld.substring(index+1);
        _feld = s1 + spieler + s2;
    }
    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        return (!_feld.contains("0"));
    }
}
