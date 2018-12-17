import java.util.Comparator;
/**
 * Vergleicht zwei Personen anhand ihres Alters.
 * 
 * @author Fredrik Winkler
 * @version 2017
 */
class PerAlter implements Comparator<Person>
{
    /**
     * @see Vergleicher.vergleiche
     */
    public int compare(Person a, Person b)
    {
        // Achtung: Dieser Trick funktioniert nur, wenn die Differenz garantiert in einen int passt.
        return a.gibGeburtsjahr() - b.gibGeburtsjahr();
    }
}
