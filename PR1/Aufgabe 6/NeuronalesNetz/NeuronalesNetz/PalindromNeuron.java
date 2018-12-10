import java.util.*;
/**
 * Ein PalindromNeuron ist in der Lage, Palindrome zu erkennen. Um seinen Ausgangswert
zu bestimmen, prüft es seine Eingangswerte auf Palindrome. Ist nur einer der
Eingangswerte ein Palindrom, wird dieser Wert zurückgegeben; liegen mehrere Palindrome an
den Eingängen an, wird das längste geliefert; ansonsten wird null geliefert. Ein
PalindromNeuron kann in einem von zwei Modi arbeiten: Entweder wird Groß- und
Kleinschreibung unterschieden oder nicht; diese Eigenschaft wird über einen
Konstruktorparameter gesetzt.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PalindromNeuron implements Neuron
{
    // instance variables - replace the example below with your own
    private boolean _caseSensitive;
    private Set<Neuron> _neuronen;
    /**
     * @param caseSensitive true wenn gross/kleinschreibung zu beachten ist
     */
    public PalindromNeuron(boolean caseSensitive)
    {
        _caseSensitive = caseSensitive;
        _neuronen = new HashSet<Neuron>();
    }
    
    public void eingangHinzufuegen(Neuron neuron)
    {
        _neuronen.add(neuron);
    }

    /**
     * Gibt das laengste Palindrom der bekannten Neuronen zurueck.
     * Falls kein Palindrom gefunden wird null zurueckgegeben.
     *
     * @return das laengste palindrom oder null
     */
    public String getAusgangswert ()
    {
        if (_neuronen.isEmpty())
        {
            return null;
        }
        String laengstesPalindrom ="";
        
        for (Neuron neuron: _neuronen)
        {
            String ausgangswert = neuron.getAusgangswert();
            
            if(istPalindrom(ausgangswert) && 
                ausgangswert.length() > laengstesPalindrom.length())
            {
                laengstesPalindrom = ausgangswert;
            }
        }
        return laengstesPalindrom;
    }
    
    private boolean istPalindrom(String s)
    {
        if(_caseSensitive)
        {
            return s.equals(new StringBuilder(s).reverse().toString());
    
        } else
        {
            return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
        }
    }
}
