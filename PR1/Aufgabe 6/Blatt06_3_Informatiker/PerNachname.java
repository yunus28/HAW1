import java.util.Comparator;
/**
 * Vergleicht zwei Personen anhand ihres Nachnamens.
 */
class PerNachname implements Comparator<Person>
{
    /**
     * @see Vergleicher.vergleiche
     */
    public int compare(Person a, Person b)
    {
        return a.gibNachname().compareTo(b.gibNachname());
    }
}
