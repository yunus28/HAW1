import java.util.Comparator;
/**
 * Beschreibe hier die Klasse PerVorname.
 * 
 * @author (Dein Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class PerVorname implements Comparator<Person>
{
    /**
     * @see Vergleicher.vergleiche
     */
    public int compare(Person a, Person b)
    {
        return a.gibVorname().compareTo(b.gibVorname());
    }
}
