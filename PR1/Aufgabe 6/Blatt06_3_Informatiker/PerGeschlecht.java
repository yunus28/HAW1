import java.util.Comparator;
/**
 * Beschreibe hier die Klasse PerGeschlecht.
 * 
 * @author (Dein Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class PerGeschlecht implements Comparator<Person>
{
    /**
     * @see Vergleicher.vergleiche
     * 
     */
    public int compare(Person a, Person b) //mw: 1 wm: -1
    {
        if (a.istMaennlich() == b.istMaennlich()) //m|m oder f|f
        {
           return 0; 
        }
        else if (a.istMaennlich() && !b.istMaennlich()) //m|f
        {
            return 1;
        }
        else //f|m
        {
            return -1;
        }
    }
}
