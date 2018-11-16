import javafx.scene.shape.Rectangle;

/**
 * Ein Quadrat, das manipuliert werden kann und sich selbst auf einer
 * Leinwand zeichnet.  <br><br>
 * 
 * Nach einer Vorlage von Michael Koelling und David J. Barnes
 * 
 * @author Axel Schmolitzky
 * @version 2017
 */
class Quadrat
{
    private int _groesse;
    private int _xPosition;
    private int _yPosition;
    private String _farbe;
    private boolean _istSichtbar;

    /**
     * Ein neues Quadrat startet mit einer Standardfarbe an einer
     * Standardposition und ist anfangs unsichtbar.
     */
    public Quadrat()
    {
        _groesse = 30;
        _xPosition = 60;
        _yPosition = 50;
        _farbe = "rot";
        _istSichtbar = false;
    }

    /**
     * Mache dieses Quadrat sichtbar. Wenn es bereits sichtbar ist, tue
     * nichts.
     */
    public void sichtbarMachen()
    {
        _istSichtbar = true;
        zeichnen();
    }

    /**
     * Mache dieses Quadrat unsichtbar. Wenn es bereits unsichtbar ist, tue
     * nichts.
     */
    public void unsichtbarMachen()
    {
        loeschen();
        _istSichtbar = false;
    }

    /**
     * Bewege dieses Quadrat einige Bildschirmpunkte nach rechts.
     */
    public void nachRechtsBewegen()
    {
        horizontalBewegen(20);
    }

    /**
     * Bewege dieses Quadrat einige Bildschirmpunkte nach links.
     */
    public void nachLinksBewegen()
    {
        horizontalBewegen(-20);
    }

    /**
     * Bewege dieses Quadrat einige Bildschirmpunkte nach oben.
     */
    public void nachObenBewegen()
    {
        vertikalBewegen(-20);
    }

    /**
     * Bewege dieses Quadrat einige Bildschirmpunkte nach unten.
     */
    public void nachUntenBewegen()
    {
        vertikalBewegen(20);
    }

    /**
     * Bewege dieses Quadrat horizontal.
     * @param entfernung
     *          Die Entfernung in Bildschirmpunkten, um die das Dreieck
     *          horizontal bewegt werden soll.
     */
    public void horizontalBewegen(int entfernung)
    {
        _xPosition += entfernung;
        zeichnen();
    }

    /**
     * Bewege dieses Quadrat vertikal.
     * @param entfernung
     *          Die Entfernung in Bildschirmpunkten, um die das Dreieck
     *          vertikal bewegt werden soll.
     */
    public void vertikalBewegen(int entfernung)
    {
        _yPosition += entfernung;
        zeichnen();
    }

    /**
     * Bewege dieses Quadrat langsam horizontal.
     * @param entfernung
     *          Die Entfernung in Bildschirmpunkten, um die das Dreieck
     *          horizontal bewegt werden soll.
     */
    public void langsamHorizontalBewegen(int entfernung)
    {
        int delta;

        if (entfernung < 0)
        {
            delta = -1;
            entfernung = -entfernung;
        }
        else
        {
            delta = 1;
        }

        for (int i = 0; i < entfernung; i++)
        {
            _xPosition += delta;
            zeichnen();
        }
    }

    /**
     * Bewege dieses Quadrat langsam vertikal.
     * @param entfernung
     *          Die Entfernung in Bildschirmpunkten, um die das Dreieck
     *          vertikal bewegt werden soll.
     */
    public void langsamVertikalBewegen(int entfernung)
    {
        int delta;

        if (entfernung < 0)
        {
            delta = -1;
            entfernung = -entfernung;
        }
        else
        {
            delta = 1;
        }

        for (int i = 0; i < entfernung; i++)
        {
            _yPosition += delta;
            zeichnen();
        }
    }

    /**
     * Aendere die Groesse dieses Quadrates.
     * @param neueGroesse
     *          Die neue Groesse des Quadrats in Bildschirmpunkten.
     *          Diese muss groesser als Null sein.
     */
    public void groesseAendern(int neueGroesse)
    {
        if(neueGroesse > 0){
            _groesse = neueGroesse;
            zeichnen();
        }
    }

    /**
     * Aendere die Farbe dieses Quadrates.
     * @param neueFarbe
     *          Die neue Farbe des Kreises.
     *          Gueltige Angaben sind "rot", "gelb", "blau", "gruen", "lila" und "schwarz".
     */
    public void farbeAendern(String neueFarbe)
    {
        _farbe = neueFarbe;
        zeichnen();
    }

    /*
     * Zeichne dieses Quadrat mit seinen aktuellen Werten auf den Bildschirm.
     */
    private void zeichnen()
    {
        if (_istSichtbar)
        {
            Leinwand leinwand = Leinwand.Helfer.gibLeinwand();
            Leinwand.sichtbarMachen();
            leinwand.zeichne(
                this,
                _farbe,
                new Rectangle(_xPosition, _yPosition, _groesse, _groesse));
            leinwand.warte(10);
        }
    }

    /*
     * Loesche dieses Quadrat vom Bildschirm.
     */
    private void loeschen()
    {
        if (_istSichtbar)
        {
            Leinwand.sichtbarMachen();
            Leinwand leinwand = Leinwand.Helfer.gibLeinwand();
            leinwand.entferne(this);
        }
    }
}
