import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

import java.util.Map;
import java.util.HashMap;

/**
 * Diese Klasse definiert Turtles, die mit einfachen
 * Operationen "bewegt" werden koennen. Die Bewegungen
 * einer Turtle koennen auf einer Zeichenflaeche sichtbar
 * gemacht werden, die Turtle hinterlaesst quasi eine
 * Spur. Die Turtle selbst ist nicht sichtbar.
 * <br><br>
 * Warum gerade eine Turtle, also eine Schildkroete?
 * Hauptsaechlich aufgrund der Programmiersprache LOGO, mit
 * der die Idee der Turtle Graphics bekannt geworden ist.
 * Etwas mehr Hintergrund ist hier zu finden:
 * <a href="https://en.wikipedia.org/wiki/Turtle_graphics">
 * https://en.wikipedia.org/wiki/Turtle_graphics</a>
 * <br><br>
 * Diese Java-Version nach einer Vorlage von Alfred Hermes (14.12.2003)
 * 
 * @author Simon Gerlach
 * @author Fredrik Winkler
 * @author Axel Schmolitzky (JavaFX)
 * @version 2018
 */
class Turtle
{
    // Position dieser Turtle
    private double _x;
    private double _y;

    // Richtung dieser Turtle
    private double _richtung;

    // Die Farbe der Spur, die diese Turtle hinterlaesst
    private Color _farbe;

    // Gibt an, ob diese Turtle eine Spur hinterlaesst oder nicht
    private boolean _spurHinterlassen;

    // Reaktionszeit einer Turtle auf Befehle
    private int _verzoegerung;

    // Moegliche Farbwerte
    private static final HashMap<String, Color> farben;
    private static final Color[] farbArray;

    static
    {
        farben = new HashMap<String, Color>();
        farben.put("schwarz", Color.BLACK);
        farben.put("blau", Color.BLUE);
        farben.put("cyan", Color.CYAN);
        farben.put("dunkelgrau", Color.DARKGRAY);
        farben.put("grau", Color.GRAY);
        farben.put("gruen", Color.GREEN);
        farben.put("hellgrau", Color.LIGHTGRAY);
        farben.put("magenta", Color.MAGENTA);
        farben.put("orange", Color.ORANGE);
        farben.put("pink", Color.PINK);
        farben.put("rot", Color.RED);
        farben.put("weiss", Color.WHITE);
        farben.put("gelb", Color.YELLOW);
        farbArray = farben.values().toArray(new Color[farben.size()]);
    }

    /**
     * Initialisiert eine neue Turtle auf den Mittelpunkt der Welt.
     * Die Ausrichtung ist nach rechts (0 Grad),
     * und es wird eine schwarze Spur hinterlassen.
     */
    public Turtle()
    {
        this(TurtleWelt.WIDTH / 2, TurtleWelt.HEIGHT / 2);
    }

    /**
     * Loescht alle Spuren, die die Turtle bisher hinterlassen hat.
     */
    public void loescheAlleSpuren()
    {
        TurtleWelt.globaleWelt.loescheAlleSpuren();
    }

    /**
     * Initialisiert eine neue Turtle auf einen gegebenen Startpunkt.
     * Die Ausrichtung ist nach rechts (0 Grad),
     * und es wird eine schwarze Spur hinterlassen.
     * @param x die X-Koordinate
     * @param y die Y-Koordinate
     */
    public Turtle(double x, double y)
    {
        _x = x;
        _y = y;
        _richtung = 0;
        _verzoegerung = 1;
        _farbe = Color.BLACK;
        _spurHinterlassen = true;
    }

    /**
     * Bewegt die Turtle vorwaerts in Blickrichtung.
     * @param schritte Anzahl der Pixel, die die Turtle zuruecklegen
     *            soll
     */
    public void geheVor(double schritte)
    {
        double radians = Math.toRadians(_richtung);
        double nextX = _x + Math.cos(radians) * schritte;
        double nextY = _y + Math.sin(radians) * schritte;
        geheZu(nextX, nextY);
    }

    /**
     * Bewegt die Turtle auf einer Linie zu einer neuen Position.
     * @param x X-Koordinate der neuen Position
     * @param y Y-Koordinate der neuen Position
     */
    public void geheZu(double x, double y)
    {
        if (_spurHinterlassen)
        {
            TurtleWelt.globaleWelt.zeichneLinie(_x, _y, x, y, _farbe);
        }
        _x = x;
        _y = y;
        verzoegern();
    }

    /**
     * Setzt die Blickrichtung der Turtle.
     * @param winkel 0 = rechts, 90 = unten, 180 = links, 270 = oben
     */
    public void setzeRichtung(double winkel)
    {
        _richtung = winkel;
        verzoegern();
    }

    /**
     * Dreht die Turtle um eine angegebene Winkeldifferenz.
     * @param winkel zu drehende Winkeldifferenz in Grad
     */
    public void drehe(double winkel)
    {
        setzeRichtung(_richtung + winkel);
    }

    /**
     * Laesst die Turtle auf den angegebenen Punkt (x, y) schauen.
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void schaueAuf(double x, double y)
    {
        double deltaX = x - _x;
        double deltaY = y - _y;
        setzeRichtung(Math.toDegrees(Math.atan2(deltaY, deltaX)));
    }

    /**
     * Setzt die Farbe der Spur, die diese Turtle hinterlaesst.
     * Moegliche Farben sind "schwarz", "blau", "cyan", "dunkelgrau", "grau", "gruen", "hellgrau", "magenta", "orange", "pink", "rot", "weiss", "gelb".
     * @param neueFarbe die neue Spur-Farbe der Turtle
     */
    public void setzeFarbe(String neueFarbe)
    {
        if ((neueFarbe == null) || ((_farbe = farben.get(neueFarbe.toLowerCase())) == null))
        {
            _farbe = Color.BLACK;
        }
    }

    /**
     * Setzt eine der 13 moeglichen Farben.
     * @param farbnummer die Farbummer (0 = schwarz, 12 = gelb)
     */
    public void setzeFarbe(int farbnummer)
    {
        _farbe = farbArray[Math.abs(farbnummer % 13)];
    }

    /**
     * Bewegungen der Turtle sind ab sofort unsichtbar.
     */
    public void hinterlasseKeineSpur()
    {
        _spurHinterlassen = false;
    }

    /**
     * Bewegungen der Turtle sind ab sofort sichtbar.
     */
    public void hinterlasseSpur()
    {
        _spurHinterlassen = true;
    }

    /**
     * Setzt die Geschwindigkeit, mit der die Turtle auf Anweisungen reagiert.
     * @param geschwindigkeit von 0 (langsam) bis 10 (schnell)
     */
    public void setzeGeschwindigkeit(int geschwindigkeit)
    {
        if (geschwindigkeit > 10)
        {
            geschwindigkeit = 10;
        }
        else if (geschwindigkeit < 0)
        {
            geschwindigkeit = 0;
        }
        _verzoegerung = 10 - geschwindigkeit;
    }

    /**
     * Gibt die X-Position der Turtle zurueck.
     * @return die X-Position
     */
    public double gibX()
    {
        return _x;
    }

    /**
     * Gibt die Y-Position der Turtle zurueck.
     * @return die Y-Position
     */
    public double gibY()
    {
        return _y; 
    }

    /**
     * Gibt die Richtung der Turtle zurueck.
     * @return die Richtung
     */
    public double gibRichtung()
    {
        return _richtung;
    }

    /**
     * Abhaengig von der Geschwindigkeit dieser Turtle wird hier kurze Zeit verzoegert.
     */
    private void verzoegern()
    {
        if (_verzoegerung > 0)
        {
            try
            {
                Thread.sleep(_verzoegerung);
            }
            catch (InterruptedException ignore)
            {
            }
        }
    }

    private static class TurtleWelt
    {
        public static final int WIDTH = 500;
        public static final int HEIGHT = 500;

        public static final TurtleWelt globaleWelt = new TurtleWelt();

        private GraphicsContext _gc;

        public TurtleWelt()
        {
            new JFXPanel();
            Platform.setImplicitExit(false);
            Platform.runLater( () -> init() );
        }

        private void init()
        {
            Stage stage = new Stage();
            stage.setAlwaysOnTop(true);
            stage.setTitle("Turtle Graphics - loeschen mit Rechts-Klick");
            stage.setResizable(false);
            Group root = new Group();
            Canvas canvas = new Canvas(WIDTH,HEIGHT);
            canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (me) -> {
                    if (me.getButton() == MouseButton.SECONDARY)
                    {
                        loescheAlleSpuren();
                    }
                } );
            _gc = canvas.getGraphicsContext2D();
            root.getChildren().add(canvas);
            stage.setScene(new Scene(root));
            stage.show();
            stage.toFront();
            stage.setOnCloseRequest(e -> System.exit(0));
            stage.setAlwaysOnTop(false);
        }

        public void zeichneLinie(double x1, double y1, double x2, double y2, Color farbe)
        {
            Platform.runLater( () -> {
                    _gc.setStroke(farbe);
                    _gc.strokeLine((int)(x1+0.5), (int)(y1+0.5), (int)(x2+0.5), (int)(y2+0.5));
                } );
        }

        public void loescheAlleSpuren()
        {
            Platform.runLater( () -> {
                    _gc.setFill(Color.WHITE);
                    _gc.fillRect(0, 0, WIDTH, HEIGHT);
                } );
        }
    }

}
