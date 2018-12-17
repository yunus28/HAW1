import java.util.Comparator;
/**
 * Kehrt anderen Vergleicher um.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Umgekehrt implements Comparator<Person>
{
    private Comparator _vgl;
    public Umgekehrt(Comparator vgl)
    {
        _vgl = vgl;
    }
    
    /**
     * @see Vergleicher.vergleiche
     */
    public int compare(Person a, Person b)
    {
        return -(_vgl.compare(a, b));
    }
}
