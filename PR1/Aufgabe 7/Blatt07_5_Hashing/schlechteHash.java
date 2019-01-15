
/**
 * Write a description of class schlechteHash here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class schlechteHash implements HashWertBerechner
{
    public int hashWert(String wort)
    {
        return 1;
    }
    
    /**
     * Liefert eine Beschreibung fuer die Art der Berechnung.
     */
    public String gibBeschreibung()
    {
        return "Das Studium hat mich diesen hashAlgorithmus gelehrt.";
    }
}
