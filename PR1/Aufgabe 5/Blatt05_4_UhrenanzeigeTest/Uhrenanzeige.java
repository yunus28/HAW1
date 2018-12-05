/**
 * Die Klasse Uhrenanzeige simuliert digitale Uhren mit Stunden- und
 * Minutenanzeige. Der Minutentakt wird ueber einen Methodenaufruf vorgegeben.
 * Nach dem ersten Laden dieses Projekts befindet sich ein Fehler in der Methode
 * taktSignalGeben().
 * 
 * @author Christian Spaeh
 * @version 2018
 */
class Uhrenanzeige
{
    // Referenz auf eine Nummernanzeige fuer die Stunden dieser Anzeige
    private Nummernanzeige _stunden;

    // Referenz auf eine Nummernanzeige fuer die Minuten dieser Anzeige
    private Nummernanzeige _minuten;

    /**
     * Eine neue Uhrenanzeige wird auf 00:00 initialisiert.
     */
    public Uhrenanzeige()
    {
        _stunden = new Nummernanzeige(24);
        _stunden.setzeWert(0);
        _minuten = new Nummernanzeige(60);
        _minuten.setzeWert(0);
    }

    /**
     * Setzt die Uhrzeit auf die uebergebenen Werte.
     * 
     * @param stunden
     *            Der neue Stundenwert
     * @param minuten
     *            Der neue MinutenwertS
     */
    public void setzeUhrzeit(int stunden, int minuten)
    {
        _stunden.setzeWert(stunden);
        _minuten.setzeWert(minuten);
    }

    /**
     * Gibt einen Minutentakt und schaltet die Uhr eine Minute weiter.
     * @TODO Hier steckt noch ein Fehler im Detail.
     */
    public void taktSignalGeben()
    {
        _minuten.erhoehen();
        if (_minuten.gibWert() == 0)
        {
            _stunden.erhoehen();
        }
    }

    /**
     * Gibt die aktuelle Uhrzeit im Format "HH:MM" zurueck.
     * Sowohl Stunden als auch Minuten werden immer zweistellig
     * ausgegeben, gegebenenfalls mit fuehrender Null.
     * 
     * @return die Uhrzeit dieser Uhrenanzeige
     */
    public String gibUhrzeit()
    {
        return _stunden.gibAnzeigewert() + ":" + _minuten.gibAnzeigewert();
    }
}
