import static java.util.Objects.requireNonNull;
import java.util.Comparator;
/**
 * Vergleicht zwei Personen anhand eines primaeren Vergleichers.
 * Wenn die beiden Personen laut diesem primaeren Vergleicher gleich sind,
 * dann werden die Personen anhand eines sekundaeren Vergleichers verglichen.
 * 
 * @author Fredrik Winkler
 * @version 2018
 */
class Zweistufig implements Comparator<Person>
{
    private final Comparator _primaer;
    private final Comparator _sekundaer;
    
    /**
     * @param primaer der primaere Vergleicher
     * @param sekundaer der sekundaere Vergleicher
     */
    public Zweistufig(Comparator primaer, Comparator sekundaer)
    {
        _primaer = requireNonNull(primaer);
        _sekundaer = requireNonNull(sekundaer);
    }

    /**
     * @see Vergleicher.vergleiche
     */
    public int compare(Person a, Person b)
    {
        int ergebnis = _primaer.compare(a, b);
        if (ergebnis == 0)
        {
            ergebnis = _sekundaer.compare(a, b);
        }
        return ergebnis;
    }
}
