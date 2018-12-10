/**
 * Vergleicht zwei Personen anhand ihres Alters.
 * 
 * @author Fredrik Winkler
 * @version 2017
 */
class PerAlter implements Vergleicher
{
    /**
     * @see Vergleicher.vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        // Achtung: Dieser Trick funktioniert nur, wenn die Differenz garantiert in einen int passt.
        return a.gibGeburtsjahr() - b.gibGeburtsjahr();
    }
}
