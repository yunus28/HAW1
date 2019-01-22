import java.util.*;

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

    public int anzahlDuplikate(List<String> woerter)
    {
        HashSet<String> set = new HashSet<String>(woerter);
        return woerter.size() - set.size();
    }

    public int anzahlAuftreten(char vonChar, String inString)
    { //rekusriv!!!!!!
        int a = 0;
        if (inString.length()==0) {
            return 0;
        }
        else 
        {
            if (inString.charAt(0) == vonChar) a = 1;
            return a + anzahlAuftreten(vonChar, inString.substring(1));
        }
        //int counter = 0;
        //for (int i = 0; i< inString.length() ; ++i)
        //{
        //    if(inString.charAt(i) == vonChar) counter++;
        //}
        //return counter;
    }

    public String worteVerbinden(List<String> worte)
    {
        String s = "";
        int i = 1;
        for (String wort : worte)
        {
            
            if (i!= 1)
            {
                s+= ";" + wort;
            } else 
            {
                s+=wort;
            }
            
            ++i;
        }
        return s;
    }

    public String[] konkateniere(String[] s1, String[] s2)
    {
        String[] lange = s1;
        String[] kurz = s2;
        if (s2.length > s1.length)
        {
            lange = s2;
            kurz = s1;
        }
        String[] result = new String [lange.length];
        for (int i = 0; i<kurz.length; ++i)
        {
            String l = lange[i];
            String k = kurz[i];
            if (l.length() < k.length())
            {
                l = kurz[i];
                k = lange[i];
            }
            
            result[i]= k+l;
            if (l.length() == k.length())
            {
                result[i] = s1[i]+s2[i];
            }
        }
        for (int i = kurz.length ; i<lange.length; ++i)
        {
            result[i] = lange[i];
        }
        return result;
    }

    public String snakeCaseToCamelCase(String name)
    {
        boolean b = false;
        String s = "";
        boolean schoneinBuchstabe = false;; //überschreieb?
        for (int i = 0; i<name.length(); ++i)
        {
            char c = name.charAt(i);
            System.out.print(c);
            if (c!='_') schoneinBuchstabe = true;
            if(c == '_' && i!=0 && schoneinBuchstabe)
            {
                b = true;
            } else if(b)
            {
                c = Character.toUpperCase(c);
                s +=c;
                b = false;
            } else
            {
                b = false;
                if(i>0 && name.charAt(i-1) == name.charAt(i) && name.charAt(i-1) == '_') {}
                else
                s+=c;
            }
        }
        System.out.println("        " + s);
        return s;
    }

}
