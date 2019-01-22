
/**
 * Write a description of class SanduhrFinderImpl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SanduhrFinderImpl implements SanduhrFinder
{
   
    /**
     * Constructor for objects of class SanduhrFinderImpl
     */
    public SanduhrFinderImpl()
    {
       
    }

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
    public int addiereSanduhren(int[][] arr)
    {
        int ergebnis = 0;
        //i = zeile;;;; j=spalte
        for(int i = 0; i<arr.length; ++i) //zeilendurchlaufen 
        {
            if(arr!=null && i+2<arr.length &&arr[i]!=null && arr[i+1]!=null && arr[i+2]!=null) 
            {
                for(int j = 0; j<arr.length ; ++j) //spalten durchlaufen
                {
                    if(arr[i]!=null && j+2<arr[i].length && j+1<arr[i+1].length  && j+2<arr[i+2].length)
                    {
                        ergebnis += berechneSanduhr(i,j, arr);
                        System.out.println(ergebnis);
                    }
                }
                
            }
            
        }   
        
        // put your code here
        return ergebnis;
    }
    
    private int berechneSanduhr(int x, int y, int[][] arr)
    {
        int ergebnis = 0;
        ergebnis = arr[x][y] +arr[x][y+1] +arr[x][y+2] +arr[x+1][y+1] +arr[x+2][y] +arr[x+2][y+1] +arr[x+2][y+2];        
        
        return ergebnis;
    }
}
