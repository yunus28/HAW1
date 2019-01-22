
/**
 * Tragen Sie hier eine Beschreibung des Interface Sanduhr ein.
 * 
 * @author Axel Schmolitzky
 * @version 2018-1
 */

interface SanduhrFinder
{
    /**
     * Liefert fuer ein zweidimensionales Array von int-Werten 
     * die Summe aller Sanduhren in diesem Array. Eine Sanduhr in einem Array
     * ist eine Menge von benachbarten Zellen mit folgender Form:
     * 
     *  a b c      
     *    d         
     *  e f g       
     * 
     * Der Wert einer Sanduhr berechnet sich aus der Summe ihrer Zellen.
     * Für das folgende int-Array beispielsweise:
     * 
     * 1 1 1 2
     * 2 1 2 2
     * 1 1 1 2
     * 2 2 2 2
     *
     * ist der Wert der ersten Sanduhr in der linken oberen Ecke 7 (nur Einsen),
     * die um eine Zelle nach rechts verschobene Sanduhr hat den Wert 10.
     * Das ganze Array enthaelt vier Sanduhren, deren Summe 7+10+12+12 = 41 beträgt.
     */
    int addiereSanduhren(int[][] arr);
}
