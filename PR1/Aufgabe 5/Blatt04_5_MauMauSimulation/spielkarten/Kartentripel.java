package spielkarten;


/**
 * Beschreibe hier die Klasse Kartentripel.
 * 
 * @author (Dein Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class Kartentripel
{
    private Spielkarte _sk1;
    private Spielkarte _sk2;
    private Spielkarte _sk3;
    
    public Kartentripel (Spielkarte sk1, Spielkarte sk2, Spielkarte sk3)
    {
        if (sk1 ==null || sk2 == null || sk3 == null)
        {
            throw new IllegalArgumentException();
        }
        _sk1 = sk1;
        _sk2 = sk2;
        _sk3 = sk3;
    }
    /**
     * @param index (1-3)
     * @throws IllegalArgumentException
     */
    public Spielkarte gibkarteIndex (int index)
    {
        switch (index)
        {
            case 1:
            {
                return _sk1;
            }
            case 2:
            {
                return _sk2;
            }
            case 3:
            {
                return _sk3;
            }
            default:
            throw new IllegalArgumentException();
        }
        
    }
}
