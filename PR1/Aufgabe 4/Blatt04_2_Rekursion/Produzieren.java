/**
 * In dieser Klasse sind rekursive Algorithmen umzusetzen.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2018
 */
class Produzieren
{
    
    public boolean test()
    {
        boolean b = true;
        if (2 != modulo(23,7) ) b = false;
        if (!enthaeltVokal("String s")) b = false;
        if (istPalindrom("String s") ) b = false;
        if(1 != anzahlLeerzeichen("String s")) b = false;
        if (!( "gnirtS".equals( umgedreht("String") ) )) b = false;
        return b;
    }
    
    /**
    * Liefert die Fakultaet von n, also das Produkt aller natuerlichen Zahlen bis n.
    * Die Fakultaet von 0 ist per mathematischer Definition 1.
    *
    * Beispielauswertung:
    * 
    *   fak(4)
    * -> 4 * fak(3)
    * -> 4 * (3 * fak(2))
    * -> 4 * (3 * (2 * fak(1)))
    * -> 4 * (3 * (2 * (1 * fak(0))))
    * -> 4 * (3 * (2 * (1 * 1)))
    * -> 4 * (3 * (2 * 1))
    * -> 4 * (3 * 2)
    * -> 4 * 6
    * -> 24
    */
    public int fak(int n)
    {
        if (n < 0) return -1;
        if (n == 0) 
        {
            return 1;
        }
        else 
        {
            return n * fak(n-1);
        }
    }
    
    /**
     * Berechnet n modulo m, also den Rest der ganzzahligen Division n/m.
     * 
     * modulo(14,3) -> modulo(11,3) -> modulo(8,3) -> modulo(5,3) -> modulo(2,3) -> 2
     * 
     * @param n ein beliebiger Wert >= 0
     * @param m ein beliebiger Wert > 0
     */
    public int modulo(int n, int m)
    {
        if (n < m) return n;
        else 
        {
            return modulo(n-m, m);
        }
    }
    
    /**
    * Gibt an, ob die Zeichenkette einen Vokal enthaelt. Auswertungen:
    * 
    * enthaeltVokal("brei") -> enthaeltVokal("rei") -> enthaeltVokal("ei") -> true
    * enthaeltVokal("xyz") -> enthaeltVokal("yz") -> enthaeltVokal("z") -> enthaeltVokal("") -> false
    * @param s ein beliebiger String ungleich null
    */
    public boolean enthaeltVokal(String s)
    {
        if (s != null && s.length() > 0)
        {
            char c = s.toLowerCase().charAt(0);
            switch(c)
            {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                {
                    return true;
                }
                default: return  enthaeltVokal(s.substring(1));
        
            }
        } else return false;
    }
    
    /**
    * Gibt an, ob die Zeichenkette ein Palindrom ist. Auswertungen:
    * 
    * istPalindrom("anna") -> istPalindrom("nn") -> istPalindrom("") -> true
    * istPalindrom("asta") -> istPalindrom("st") -> false
    * istPalindrom("axa") -> istPalindrom("x") -> true
    * istPalindrom("xyz") -> false
    * @param s ein beliebiger String ungleich null
    */
    public boolean istPalindrom(String s)
    {
        boolean b = false;
        if (s != null && s.length() > 1)
        {
            char c1 = s.toLowerCase().charAt(0);
            char c2 = s.toLowerCase().charAt(s.length()-1);
            if (c1 == c2 && istPalindrom(s.substring(1, s.length()-1) )) 
            {
                b = true;
            }
        }
        else b = true;
        
        return b;
    }
    
    /**
    * Berechnet die Anzahl Leerzeichen in der Zeichenketten. Auswertung:
    * 
    * anzahlLeerzeichen("a bc d")
    * -> 0 + anzahlLeerzeichen(" bc d")
    * -> 0 + (1 + anzahlLeerzeichen("bc d"))
    * -> 0 + (1 + (0 + anzahlLeerzeichen("c d")))
    * -> 0 + (1 + (0 + (0 + anzahlLeerzeichen(" d"))))
    * -> 0 + (1 + (0 + (0 + (1 + anzahlLeerzeichen("d")))))
    * -> 0 + (1 + (0 + (0 + (1 + (0 + anzahlLeerzeichen(""))))))
    * -> 0 + (1 + (0 + (0 + (1 + (0 + 0)))))
    * -> 0 + (1 + (0 + (0 + (1 + 0))))
    * -> 0 + (1 + (0 + (0 + 1)))
    * -> 0 + (1 + (0 + 1))
    * -> 0 + (1 + 1)
    * -> 0 + 2
    * -> 2
    * @param s ein beliebiger String ungleich null
    */
    public int anzahlLeerzeichen(String s)
    {
        int spaces = 0;
        if (s != null && s.length() > 0)
        {
            char c = s.toLowerCase().charAt(0);
            if (c == ' ') spaces += 1 + anzahlLeerzeichen(s.substring(1));
            else spaces += anzahlLeerzeichen(s.substring(1));
        }
        return spaces;
    }
    
    /**
    * Liefert die umgedrehte Zeichenkette. Auswertung:
    * 
    *   umgedreht("regal")
    * -> umgedreht("egal") + 'r'
    * -> (umgedreht("gal") + 'e') + 'r'
    * -> ((umgedreht("al") + 'g') + 'e') + 'r'
    * -> (((umgedreht("l") + 'a') + 'g') + 'e') + 'r'
    * -> (((          "l"  + 'a') + 'g') + 'e') + 'r'
    * -> ((           "la"        + 'g') + 'e') + 'r'
    * -> (            "lag"              + 'e') + 'r'
    * ->              "lage"                    + 'r'
    * ->              "lager"
    * @param s ein beliebiger String ungleich null
    */
    public String umgedreht(String s)
    {
        String s2 = "";
        if(s.length() > 0)
        {
            s2 = umgedreht(s.substring(1)) + s.charAt(0) ;;
            
        }
        else return "";
        return s2;
    }
    
    
}
