/**
 * Ein Spielfeld besteht aus drei Zeilen mit je drei Spalten. Man kann an den neun
 * Positionen einen der beiden Spieler als Besitzer eintragen und auslesen.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2015-11
 */
class SpielfeldGeflecht implements Spielfeld
{
    private SpielfeldZeile _zeile0;
    private SpielfeldZeile _zeile1;
    private SpielfeldZeile _zeile2;

    /**
     * Initialisiert ein neues, leeres Spielfeld.
     */
    public SpielfeldGeflecht()
    {
        _zeile0 = new SpielfeldZeile();
        _zeile1 = new SpielfeldZeile();
        _zeile2 = new SpielfeldZeile();
    }

    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        int besitzer;
        switch (zeile)
        {
        case 0:
            besitzer = _zeile0.gibBesitzer(spalte);
            break;

        case 1:
            besitzer = _zeile1.gibBesitzer(spalte);
            break;

        case 2:
            besitzer = _zeile2.gibBesitzer(spalte);
            break;

        default:
            throw new IllegalArgumentException(String.valueOf(zeile));
        }
        return besitzer;
    }

    /**
     * Besetzt die angegebene Position auf dem Spielfeld fuer einen Spieler.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @param spieler
     *            0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetzePosition(int zeile, int spalte, int spieler)
    {
        switch (zeile)
        {
        case 0:
            _zeile0.besetze(spalte, spieler);
            break;

        case 1:
            _zeile1.besetze(spalte, spieler);
            break;

        case 2:
            _zeile2.besetze(spalte, spieler);
            break;

        default:
            throw new IllegalArgumentException(String.valueOf(zeile));
        }
    }

    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        return _zeile0.istVoll() && _zeile1.istVoll() && _zeile2.istVoll();
    }
}
