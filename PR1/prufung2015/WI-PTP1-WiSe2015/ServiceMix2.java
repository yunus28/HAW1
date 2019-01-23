
/**
 * Ein weiteres Interface mit isolierten Service-Operationen.
 * 
 * @author Axel Schmolitzky
 * @version WiSe 2015/16
 */
interface ServiceMix2
{
    /**
     * Diese Methode bekommt ein zweidimensionales Array und ermittelt
     * für dieses Array, wieviele Zellen vom Typ "int" es anbietet.
     * @param intarr ein beliebiges zweidimensionales int-Array; darf nicht null sein.
     * @throws IllegalArgumentException
     */
    int arrayKapazitaet(int[][] intarr);
    
    /**
     * Diese Methode erhaelt eine beliebige Zeichenkette und liefert 
     * aus dieser Zeichenkette das laengste Palindrom. Wenn es mehrere
     * laengste Palindrome gibt, kann von diesen ein beliebiges geliefert
     * werden.
     * Ob eine Zeichenkette ein Palindrom ist, soll hier unabhaengig
     * von der Gross-Kleinschreibung sein; also ist "Regallager" hier
     * ein Palindrom und wird, falls sie das laengste Palindrom
     * im Parameter ist, als "Regallager" geliefert.
     * @param s eine beliebige Zeichenkette; darf nicht null sein.
     * @throws IllegalArgumentException
     */
    String laengstesPalindrom(String s);
}
