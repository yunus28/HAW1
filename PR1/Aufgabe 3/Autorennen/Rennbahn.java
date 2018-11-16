
/**
 * Write a description of class Rennbahn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rennbahn
{
    // instance variables - replace the example below with your own
    private int _streckenlaenge;
    private Rennauto _auto1;
    private Rennauto _auto2;
    private Rennauto _auto3;
    private Rennauto _auto4;
    
    /**
     * Constructor for objects of class Rennbahn
     * @param streckenlaenge in meter
     */
    public Rennbahn(int streckenlaenge)
    {
        _streckenlaenge = streckenlaenge;
    }
    public void entferne (Rennauto auto)
    {
        if (_auto1 == auto) _auto1 = null;
        else if (_auto2 == auto) _auto2 = null;
        else if (_auto3 == auto) _auto3 = null;
        else if (_auto4 == auto) _auto4 = null;
    }
    
    public Rennauto liefereSieger()
    {
        if (_auto1 != null && _auto1.gibStrecke() >= _streckenlaenge)
        {
            return _auto1;
        } else if (_auto2 != null && _auto2.gibStrecke() >= _streckenlaenge)
        {
            return _auto2;
        } else if (_auto3 != null && _auto3.gibStrecke() >= _streckenlaenge)
        {
            return _auto3;
        } else if (_auto4 != null && _auto4.gibStrecke() >= _streckenlaenge)
        {
            return _auto4;
        } else 
        {
            return null;
        }
    }
    
    public void simuliereZeitabschnitt() //1sekunde
    {
        if (_auto1 != null) _auto1.fahre();
        if (_auto2 != null) _auto2.fahre();
        if (_auto3 != null) _auto3.fahre();
        if (_auto4 != null) _auto3.fahre();
        
    }
    
    public void rennenDurchfuehren()
    {
        boolean zuEnde = false;
        while (!zuEnde)
        {
            simuliereZeitabschnitt();
            if (liefereSieger() != null)
            {
                zuEnde = true;
            }
            
        }
    }
    
    public boolean setzeAufSpur(Rennauto auto) //false, wenn voll
    {
        boolean b = false;
        if (_auto1 == null) 
        {
            _auto1 = auto;
            b = true;
        } else if (_auto2 == null){
            _auto2 = auto;
            b = true;
        } else if (_auto3 == null){
            _auto3 = auto;
            b = true;
        } else if (_auto4 == null)
        {
            _auto4 = auto;
            b = true;
        }
        return b;
    }

}
