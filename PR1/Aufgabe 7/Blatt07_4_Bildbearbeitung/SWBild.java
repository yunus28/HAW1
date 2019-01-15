import java.util.*;
/**
 * SWBild ist eine Klasse, die Graustufenbilder repraesentiert und
 * manipuliert. Die Implementierung erfolgt durch ein einfaches
 * Bildformat: Die Bildpunkte werden in einem zweidimensionalen
 * Array von 'short'-Werten gehalten. Jeder Feldeintrag kann einen
 * Wert zwischen 0 und 255 annehmen. Andere Werte sind unzulaessig.
 * Der Wertebereich [0..255] repraesentiert den Graustufenbereich:
 * 0 fuer Schwarz, 255 fuer Weiss und dazwischenliegende Werte fuer
 * die Grauabstufungen.
 * 
 * Beispielmethode 'dunkler': Ein geladenes Bild kann um
 * ein gegebenes 'delta' abgedunkelt werden.
 * 
 * @author  Axel Schmolitzky, Petra Becker-Pechau
 * @version 2018
 */
class SWBild
{
    
    // die Bilddaten dieses Bildes
    private short[][] _bilddaten;

    // die Breite dieses Bildes
    private int _breite;

    // die Hoehe dieses Bildes
    private int _hoehe;

    // Leinwand zur Anzeige
    private Leinwand _leinwand;

    /**
     * Initialisiert ein Bild mit einer Bilddatei. Der Benutzer kann interaktiv mit
     * Hilfe eines Dateidialogs die zu ladende Datei auswaehlen.
     */
    public SWBild()
    {
        _bilddaten = BildEinleser.liesBilddaten();
        if (_bilddaten != null)
        {
            aktualisiereBildgroesse(_bilddaten);
            erzeugeLeinwand();
        }
    }
   
    /**
     * Initialisiert ein Bild mit einer Bilddatei. Der Dateiname kann als absoluter
     * oder relativer Pfad uebergeben werden.
     * 
     * @param bilddateiName
     *            der Name der Bilddatei
     */
    public SWBild(String bilddateiName)
    {
        _bilddaten = BildEinleser.liesBilddaten(bilddateiName);
        aktualisiereBildgroesse(_bilddaten);
        erzeugeLeinwand();
    }

    /**
     * Dieses Bild um einen Wert abdunkeln. 
     * 
     * @param delta
     *            Wert der Abdunkelung. Es wird mit dem Betrag von delta gerechnet, 
     *            deshalb darf der Parameter sowohl positiv als auch negativ sein.  
     */
    public void dunkler(int delta)
    {
        if (delta < 0)
        {
            delta = -delta;
        }

        /**
         * Durch alle Bytes des Bildes gehen und jeden Wert dekrementieren
         */
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                if ((_bilddaten[y][x] - delta) > 0) // Wert darf 0 nicht unterschreiten
                {
                    _bilddaten[y][x] = (short) (_bilddaten[y][x] - delta);
                }
                else
                {
                    _bilddaten[y][x] = 0;
                }
            }
        }
        // Neuzeichnen der Bildleinwand, basierend auf den Werten in _bilddaten:
        zeichneBild();
    }

    /**
     * Dieses Bild um einen Wert aufhellen.
     * 
     * @param delta
     *            Wert der Aufhellung. Es wird mit dem Betrag von delta gerechnet, 
     *            deshalb darf der Parameter sowohl positiv als auch negativ sein.  
     */
    public void heller(int delta)
    {
        if (delta < 0)
        {
            delta = -delta;
        }

        /**
         * Durch alle Bytes des Bildes gehen und jeden Wert dekrementieren
         */
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                if ((_bilddaten[y][x] + delta) < 256) // Wert darf 0 nicht unterschreiten
                {
                    _bilddaten[y][x] = (short) (_bilddaten[y][x] + delta);
                }
                else
                {
                    _bilddaten[y][x] = 255;
                }
            }
        }
        // Neuzeichnen der Bildleinwand, basierend auf den Werten in _bilddaten:
        zeichneBild();
    }

    /**
     * Dieses Bild invertieren.
     */
    public void invertieren()
    {
        // Durch alle Bildpunkte des Bildes gehen und jeden Wert "invertieren"
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                _bilddaten[y][x] = (short) (255 - _bilddaten[y][x]);
            }
        }
        zeichneBild();
    }

    /**
     * Dieses Bild horizontal spiegeln.
     */
    public void horizontalSpiegeln()
    {
        for (int y = 0; y < _hoehe/2; ++y)
        {
            for (int x = 0; x < _breite; x++)
            {
                short tmp = _bilddaten[y][x]; 
                _bilddaten[y][x] = _bilddaten[_hoehe-1-y][x];
                _bilddaten[_hoehe-1-y][x] = tmp;
            }
        }
        zeichneBild();
    }
    
    /**
     * Dieses Bild weichzeichnen.
     */
    public void weichzeichnen()
    {
        short[][] weichesBild = new short[_hoehe][_breite];
        for(int y = 0; y < _hoehe; ++y)
        {
            for(int x = 0; x < _breite ; ++x)
            {
                LinkedList<Short> nachbarpixel = new LinkedList<Short>();
                for(int yi = -1; yi < 2; yi++)
                {
                    if (yi + y > 0 && yi+ y < _hoehe)
                        {
                            for(int xi = -1; xi < 2; xi++)
                            {
                                if (xi + x > 0 && xi+x < _breite)
                                {
                                    nachbarpixel.add(_bilddaten[yi+y][xi+x]);
                                }
                            }
                        }
                }
                weichesBild[y][x] = mittelwert(nachbarpixel);
            }
        }
        _bilddaten = weichesBild;
        zeichneBild();
    }
            
    private short mittelwert(List<Short> werte)
    {
        short ergebnis = 0;
        for (short wert: werte)
        {
            ergebnis += wert;
        }
        ergebnis = (short) (ergebnis/werte.size());
        return ergebnis;
    }

    /**
     * Dieses Bild am Mittelpunkt spiegeln.
     */
    public void punktpiegeln()
    {
        horizontalSpiegeln();
        for (int y = 0; y < _hoehe; ++y)
        {
            for (int x = 0; x < _breite/2; x++)
            {
                short tmp = _bilddaten[y][x]; 
                _bilddaten[y][x] = _bilddaten[y][_breite-1-x];
                _bilddaten[y][_breite-1-x] = tmp;
            }
        }
        zeichneBild();
    }

    /**
     * Erzeuge bei diesem Bild einen Spot mit Radius r, Mittelpunkt x0,y0 und
     * Beleuchtungsintensitaet i. Ausserhalb von r nimmt die Ausleuchtung linear ab.
     * Wie im wirklichen Leben...
     * 
     * @param xo
     *            x-Koordinate des Mittelpunktes
     * @param yo
     *            y-Koordinate des Mittelpunktes
     * @param r
     *            Radius
     * @param i
     *            Beleuchtungsintesitaet
     */
    public void spot(int x0, int y0, int r, short i)
    {
        for(int yi = y0- r/2; yi < y0 + r/2; yi++)
        {
            if (yi + y0 > 0 && yi+ y0 < _hoehe)
                {
                    for(int xi = x0 - r /2; xi < x0 + r/2; xi++)
                    {
                        if (xi + x0 > 0 && xi+x0 < _breite)
                        {
                            _bilddaten[yi+y0][xi+x0] += i ;
                        }
                    }
                }
        }
        zeichneBild();
    }

    /**
     * Gib den Wert eines einzelnen Bildpunktes zurueck.
     * 
     * @param y
     *            die y-Koordinate des Bildpunktes.
     * @param x
     *            die x-Koordinate des Bildpunktes.
     * @return den Wert des angegebenen Bildpunktes.
     */
    public short gibBildpunkt(int y, int x)
    {
        return _bilddaten[y][x];
    }

    // ==== private Hilfsmethoden ====

    /**
     * Zeichnet das Bild in _bilddaten neu
     */
    private void zeichneBild()
    {
        _leinwand.sichtbarMachen();
        _leinwand.zeichneBild(_bilddaten);
    }

    /**
     * Hoehe und Breite neu berechnen, nachdem die Bilddaten veraendert worden sind.
     */
    private void aktualisiereBildgroesse(short[][] bilddaten)
    {
        _hoehe = bilddaten.length;
        if (_hoehe == 0)
        {
            _breite = 0;
        }
        else
        {
            _breite = bilddaten[0].length;
        }
    }

    /**
     * Erzeuge die Leinwand zur Darstellung und zeige sie an.
     */
    private void erzeugeLeinwand()
    {
        _leinwand = new Leinwand("Bildbetrachter", _breite, _hoehe);

        zeichneBild();
    }
}
