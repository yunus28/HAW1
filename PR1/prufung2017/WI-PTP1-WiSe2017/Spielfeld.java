
/**
 * Ein Tic-Tac-Toe-Spielfeld besteht aus drei Zeilen mit je drei Spalten.
 * Man kann an den neun Positionen einen der beiden Spieler als Besitzer
 * eintragen und auslesen.
 * 
 * @author Axel Schmolitzky 
 * @version 2018-1
 */

interface Spielfeld 
{
    public static final int LINKS = 0;
    public static final int MITTE = 1;
    public static final int RECHTS = 2;
    public static final int OBEN = 0;
    public static final int UNTEN = 2;

    public static final int KEINER = 0;
    public static final int SPIELER1 = 1;
    public static final int SPIELER2 = 2;
    
    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile vertikale Position (0-2)
     * @param spalte horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     * @throws IllegalArgumentException bei ungueltigen Parametern
     */
    public int gibBesitzer(int zeile, int spalte);

    /**
     * Besetzt die angegebene Position auf dem Spielfeld fuer einen Spieler.
     * 
     * @param zeile vertikale Position (0-2)
     * @param spalte horizontale Position (0-2)
     * @param spieler 0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     * @throws IllegalArgumentException bei ungueltigen Parametern
     */
    public void besetzePosition(int zeile, int spalte, int spieler);
    
    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll();
}
