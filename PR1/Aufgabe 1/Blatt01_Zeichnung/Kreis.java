import javafx.scene.shape.Ellipse;

/**
 * Ein Kreis, der manipuliert werden kann und sich selbst auf einer
 * Leinwand zeichnet. <br><br>
 * 
 * Nach einer Vorlage von Michael Koelling und David J. Barnes
 * 
 * @author  Axel Schmolitzky
 * @version 2017
 */

public class Kreis
{
    private int _durchmesser;
    private int _xPosition;
    private int _yPosition;
    private String _farbe;
    private boolean _istSichtbar;

    /**
     * Ein neuer Kreis startet an einer Standardposition mit
     * einer Standardfarbe und ist anfangs unsichtbar.
     */
    public Kreis()
    {
        _durchmesser = 30;
        _xPosition = 30;
        _yPosition = 70;
        _farbe = "blau";
        _istSichtbar = false;
    }

    /**
     * Mache diesen Kreis sichtbar. Wenn er bereits sichtbar ist, tue
     * nichts.
     */
    public void sichtbarMachen()
    {
        _istSichtbar = true;
        zeichnen();
    }

    /**
     * Mache diesen Kreis unsichtbar. Wenn er bereits unsichtbar ist, tue
     * nichts.
     */
    public void unsichtbarMachen()
    {
        loeschen();
        _istSichtbar = false;
    }

    /**
     * Bewege diesen Kreis einige Bildschirmpunkte nach rechts.
     */
    public void nachRechtsBewegen()
    {
        horizontalBewegen(20);
    }

    /**
     * Bewege diesen Kreis einige Bildschirmpunkte nach links.
     */
    public void nachLinksBewegen()
    {
        horizontalBewegen(-20);
    }

    /**
     * Bewege diesen Kreis einige Bildschirmpunkte nach oben.
     */
    public void nachObenBewegen()
    {
        vertikalBewegen(-20);
    }

    /**
     * Bewege diesen Kreis einige Bildschirmpunkte nach unten.
     */
    public void nachUntenBewegen()
    {
        vertikalBewegen(20);
    }

    /**
     * Bewege diesen Kreis horizontal.
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
     * Bewege diesen Kreis vertikal.
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
     * Bewege diesen Kreis langsam horizontal.
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
     * Bewege diesen Kreis langsam vertikal.
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
     * Aendere den Durchmesser dieses Kreises.
     * @param neuerDurchmesser
     *          Der neue Durchmesser des Kreies in Bildschirmpunkten. 
     *          Dieser muss groesser als Null sein.
     */
    public void groesseAendern(int neuerDurchmesser)
    {
        if(neuerDurchmesser > 0){
            _durchmesser = neuerDurchmesser;
            zeichnen();
        }
    }

    /**
     * Aendere die Farbe dieses Kreises.
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
     * Zeichne diesen Kreis mit seinen aktuellen Werten auf den Bildschirm.
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
                new Ellipse(_xPosition, _yPosition, _durchmesser/2, _durchmesser/2));
            leinwand.warte(10);
        }
    }

    /*
     * Loesche diesen Kreis vom Bildschirm.
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
