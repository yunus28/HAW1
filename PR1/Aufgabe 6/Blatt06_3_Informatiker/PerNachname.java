/**
 * Vergleicht zwei Personen anhand ihres Nachnamens.
 */
class PerNachname implements Vergleicher
{
    /**
     * @see Vergleicher.vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        return a.gibNachname().compareTo(b.gibNachname());
    }
}
