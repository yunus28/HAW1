
/**
 * Eine Aufzaehlungsklasse der Euroscheine.
 * Jeder Schein kann nach seinem Wert in Euro gefragt werden.
 * 
 * Beispielnutzung:
 * Euroschein e = Euroschein.E10;
 * int geldwert = e.wert();
 * 
 * @author  Axel Schmolitzky
 * @version WiSe 2015/16
 */
enum Euroschein
{
    E5, E10, E20, E50, E100, E200, E500;

    public int wert()
    {
        switch (this)
        {
            case E5   : return 5;
            case E10  : return 10;
            case E20  : return 20;
            case E50  : return 50;
            case E100 : return 100;
            case E200 : return 200;
            case E500 : return 500;
            default   : return 0;
        }
    }
}
