import static java.util.Objects.requireNonNull;

/**
 * Vergleicht zwei Personen anhand eines primaeren Vergleichers.
 * Wenn die beiden Personen laut diesem primaeren Vergleicher gleich sind,
 * dann werden die Personen anhand eines sekundaeren Vergleichers verglichen.
 * 
 * @author Fredrik Winkler
 * @version 2018
 */
class Zweistufig implements Vergleicher
{
    private final Vergleicher _primaer;
    private final Vergleicher _sekundaer;
    
    /**
     * @param primaer der primaere Vergleicher
     * @param sekundaer der sekundaere Vergleicher
     */
    public Zweistufig(Vergleicher primaer, Vergleicher sekundaer)
    {
        _primaer = requireNonNull(primaer);
        _sekundaer = requireNonNull(sekundaer);
    }

    /**
     * @see Vergleicher.vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        int ergebnis = _primaer.vergleiche(a, b);
        if (ergebnis == 0)
        {
            ergebnis = _sekundaer.vergleiche(a, b);
        }
        return ergebnis;
    }
}
