
/**
 * Eine Klasse mit mehreren Dienstleister-Methoden.
 * Die Ruempfe sind sinnvoll zu fuellen!
 * 
 * @author (Dein Name, Deine Matrikelnummer)
 */
class ServiceMixImpl implements ServiceMix
{
    public ServiceMixImpl()
    {
        // Diesen Konstruktor unbedingt stehen lassen!
    }
    
    /**
    * Gibt an, ob die Zeichenkette eine Ziffer enthaelt. Auswertungen:
    * 
    * enthaeltZiffer("ab2i") -> enthaeltZiffer("b2i") -> enthaeltZiffer("2i") -> true
    * enthaeltZiffer("xyz") -> enthaeltZiffer("yz") -> enthaeltZiffer("z") -> enthaeltZiffer("") -> false
    */
    public boolean enthaeltZiffer(String s)
    {
        return (s.length() !=0 && (istZiffer(s.charAt(0)) || enthaeltZiffer (s.substring(1))));
        
    }
 
    /**
    * Gibt an, ob das gegebene Zeichen eine Ziffer ist.
     */
    private boolean istZiffer(char c)
    {
        return c >= '1' && c <= '9';
    }

    
    public String nurVokale(String wort)
    {//REKURSIV
        if (wort.length() ==0)
        {
            return "";
        }
        char c = wort.charAt(0);
        if (istVokal(c))
        {   
            return (c + nurVokale(wort.substring(1)));
        }
        return (nurVokale(wort.substring(1)));
        
    }
    /**
    * Gibt an, ob das gegebene Zeichen ein Vokal ist.
    */
    private boolean istVokal(char c)
    {
        c = Character.toLowerCase(c);
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    public String[] fizzBuzz()
    {
        String[] b = new String[100];
        for(int i = 0; i<100; ++i)
        {
            int a = i+1;
            if(a%3==0 && a%5==0)
            {
                b[i]= "FizzBuzz";
            } else if (a%3==0)
            {
                b[i] = "Fizz";
            } else if (a%5==0)
            {
                b[i] = "Buzz";
            } else
            {
                b[i] = String.valueOf(i);
            }
        }
        // ToDo: implementieren
        return b;
    }
    
    

    public int[] kummuliere(int[] zahlen)
    {
        int[] erg = new int[zahlen.length];
        for(int i = 0; i<zahlen.length; ++i)
        {
            for(int j = 0; j<=i; ++j)
            {
                erg[i]+= zahlen[j];
            }
        }
        return erg;
    }

}
