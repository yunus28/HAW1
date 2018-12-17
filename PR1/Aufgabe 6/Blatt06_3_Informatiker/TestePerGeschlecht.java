

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Die Test-Klasse TestePerGeschlecht.
 *
 * @author  (Dein Name)
 * @version (Versionsnummer oder Datum)
 */
public class TestePerGeschlecht
{
    Person _mann1;
    Person _frau1;
    Person _mann2;
    Person _frau2;
    PerGeschlecht _pG;
    
    public TestePerGeschlecht()
    {
        _mann1 = neuePerson(true);
        _mann2 = neuePerson(true);
        _frau1 = neuePerson(false);
        _frau2 = neuePerson(false);
        _pG = new PerGeschlecht();
    }
    /**
     *  Testet alle moeglichkeiten fuer die einzige methde.vollstaendiger test
      */
    @Test
    public void testvergleiche()
    {
        assertEquals(0,_pG.compare(_frau1,_frau2));
        assertEquals(0,_pG.compare(_mann1,_mann2));
        assertEquals(1,_pG.compare(_mann1,_frau2));
        assertEquals(-1,_pG.compare(_frau1,_mann1));
    }
    
    private Person neuePerson (boolean maennlich)
    {
        return new Person("otto", "hans", 1900, maennlich);
    }

}