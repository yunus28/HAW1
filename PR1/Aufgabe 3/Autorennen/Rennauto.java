/**
 * Write a description of class Rennauto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rennauto
{
    String _name;
    String _typ;
    double _strecke; //meter    
    double _maxV; //meter pro sekunde
    /**
     * 
     * @param maximale Geschwindigkeit in kmh
     * 
     */
    public Rennauto(String name, String typ, double maxV)
    {
        _name = name;
        _typ = typ;
        _strecke = 0;
        _maxV = maxV * 0.277778; //kmh to ms
    }
    
    public Rennauto (String name)
    {
        this(name, "Smart", 100);
    }

    /**
     * lasst auto eine sekunde fahren
     *
     * @return gesamte strecke
     */
    public double fahre()
    {
        _strecke += Math.random() * _maxV; //*1sekunde nicht notig aufzuschreiben
        return _strecke;
    }
    public double gibStrecke()
    {
        return _strecke;
    }
}
