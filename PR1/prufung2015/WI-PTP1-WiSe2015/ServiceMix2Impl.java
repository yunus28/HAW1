
/**
 * Write a description of class ServiceMix2Impl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ServiceMix2Impl implements ServiceMix2
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ServiceMix2Impl
     */
    public ServiceMix2Impl()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * Diese Methode bekommt ein zweidimensionales Array und ermittelt
     * für dieses Array, wieviele Zellen vom Typ "int" es anbietet.
     * @param intarr ein beliebiges zweidimensionales int-Array; darf nicht null sein.
     * @throws IllegalArgumentException
     */
    public int arrayKapazitaet(int[][] intarr)
    {
        if (intarr == null)
        {
            throw new IllegalArgumentException();
        }
        int counter = 0;
        for(int i = 0; i < intarr.length; ++i)
        {
            if (intarr[i] != null)
            {
                for(int k = 0; k < intarr[i].length; k++)
                {
                    counter++;
                }
            }
        }
        return counter;
    }
    
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
    public String laengstesPalindrom(String s)
    {
        int langeP = 0;
        int indexPi = -11;
        int indexPk = -11;
        System.out.println(s);
        for(int i = 0; i<s.length(); ++i)
        {
            System.out.println("\n" + i);
            for(int k = 0; k<(s.length()-i); k++)
            {
                System.out.print(" k: " + k);
                if(istPalindrom(s.substring(i, s.length()-k)))
                {
                    if(s.substring(i, s.length()-k).length() > langeP)
                    {
                    langeP = s.substring(i, s.length()-k).length();
                    indexPi = i;
                    indexPk = s.length()-k;
                    }
                }
            }
        }
        if (indexPi==-11) return "";
        return s.substring(indexPi, indexPk);
    }
    
    private boolean istPalindrom(String s)
    {
         s = s.toLowerCase();
        if (s.length()<2) return true;
        for(int i = 0, j=s.length()-1 ; i<j ; i++, j-- )
        {   
             if(s.charAt(i)!= s.charAt(j)) return false;
        }
        return true;
    }
    
}
