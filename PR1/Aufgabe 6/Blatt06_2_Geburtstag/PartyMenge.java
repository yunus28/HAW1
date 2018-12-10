import java.util.*;
/**
 * Write a description of class PartyMenge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PartyMenge implements Party
{
    private Set<Tag> _geburtstage;
    private boolean _dopplungVorhanden;

    /**
     * Constructor for objects of class PartyMenge
     */
    public PartyMenge()
    {
        _dopplungVorhanden = false;
        _geburtstage = new HashSet<Tag>();
    }

    /**
     * Ein weiterer Gast hat seinen Geburtstag verraten :)
     * 
     * @param geburtstag der Geburtstag des Gasts; darf nicht null sein
     */
    public void fuegeGeburtstagHinzu(Tag geburtstag)
    {
        if (!_geburtstage.add(geburtstag))
        {
            _dopplungVorhanden = true;
        }
    }
	
    /**
     * Gibt an, ob mehrere Gaeste am gleichen Tag Geburtstag haben.
     */
    public boolean mindestensEinGeburtstagMehrfach()
    {
        return _dopplungVorhanden;
    }
}
