import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

import java.util.Map;
import java.util.HashMap;

/**
 * Eine Klasse, die einfache Zeichenoperationen auf einer leinwandartigen
 * Zeichenflaeche ermoeglicht. <br><br>
 * 
 * ACHTUNG: Diese Klasse ist anders: von ihr koennen interaktiv keine Exemplare
 * erzeugt werden. Die hierfuer verwendeten Konzepte werden im Lauf von
 * Programmieren 1 und 2 noch erlaeutert, sind hier aber noch nicht relevant. <br><br>
 * 
 * Entwickelt nach einer Vorlage von Bruce Quig und Michael Koelling.
 * 
 * @author Axel Schmolitzky
 * 
 * @version Februar 2018
 */
class Leinwand
{
    private static Leinwand leinwand;

    /**
     * Liefert eine Referenz auf das einzige Exemplar dieser Klasse.
     * 
     * @return Leinwand
     */
    private static Leinwand gibLeinwand()
    {
        if (leinwand == null)
        {
            leinwand = new Leinwand("Leinwand - Rechts-Klick für kompletten Reset", 550, 350, Color.WHITE);
        }
        return leinwand;
    }

    private Stage _stage;
    private Group _root;
    private final Map<String, Color> _farben;
    private final Map<Object,Shape> _figuren;

    /**
     * Initialisierung der Leinwand.
     * 
     * @param titel Titel, der im Rahmen der Leinwand angezeigt wird
     * @param breite die gewuenschte Breite der Leinwand
     * @param hoehe die gewuenschte Hoehe der Leinwand
     * @param grundfarbe die Hintergrundfarbe der Leinwand
     */
    private Leinwand(String titel, int breite, int hoehe, Color grundfarbe)
    {
        new JFXPanel();
        Platform.setImplicitExit(false);
        Platform.runLater(() -> initGUI(titel,breite,hoehe,grundfarbe));

        _farben = new HashMap<String,Color>();
        initFarben();

        _figuren = new HashMap<Object,Shape>();

    }

    private void initGUI(String titel, int breite, int hoehe, Color grundfarbe)
    {
        _stage = new Stage();
        _stage.setTitle(titel);
        _root = new Group();
        Scene scene = new Scene(_root,breite,hoehe,grundfarbe);
            scene.addEventHandler(MouseEvent.MOUSE_CLICKED, (me) -> {
                    if (me.getButton() == MouseButton.SECONDARY)
                    {
                        System.exit(0);
                    }
                } );
        _stage.setScene(scene);
        // _stage.setOnCloseRequest(e -> System.exit(0));
        sichtbarMachen();
    }

    private void initFarben()
    {
        _farben.put("rot", Color.RED);
        _farben.put("blau", Color.BLUE);
        _farben.put("gelb", Color.YELLOW);
        _farben.put("gruen", Color.GREEN);
        _farben.put("lila", Color.MAGENTA);
        _farben.put("weiss", Color.WHITE);
    }

    /**
     * Mache diese Leinwand sichtbar.
     */
    public static void sichtbarMachen()
    {
        Leinwand leinwand = gibLeinwand();
        Platform.runLater( () -> 
        {
            leinwand._stage.setAlwaysOnTop(true);
            leinwand._stage.show();
            leinwand._stage.setAlwaysOnTop(false);
        });
    }

    /**
     * Zeichne fuer das gegebene Figur-Objekt eine Java-Figur (einen Shape) auf
     * die Leinwand.
     * 
     * @param figur
     *            das Figur-Objekt, fuer das ein Shape gezeichnet werden soll
     * @param farbe
     *            die Farbe der Figur
     * @param shape
     *            ein Objekt der Klasse Shape, das tatsaechlich gezeichnet wird
     */
    public void zeichne(Object figur, String farbe, Shape shape)
    {
        Color color = _farben.get(farbe);
        if (color == null)
        {
            color = Color.BLACK;
        }
        shape.setStroke(color);
        shape.setFill(color);
        synchronized (_figuren)
        {
            if (!_figuren.containsKey(figur))
            {
                neuerShape(figur,shape);
            }
            else
            {
                tauscheShape(figur,shape);
            }
        }
    }

    /**
     * Entferne die gegebene Figur von der Leinwand.
     * 
     * @param figur
     *            die Figur, deren Shape entfernt werden soll
     */
    public void entferne(Object figur)
    {
        synchronized (_figuren)
        {
            entferneShape(figur);
        }
    }

    private void neuerShape(Object figur, Shape neuerShape)
    {
        _figuren.put(figur,neuerShape);
        Platform.runLater(() -> _root.getChildren().add(neuerShape));
    }

    private void tauscheShape(Object figur, Shape neuerShape)
    {
        Shape alterShape = _figuren.remove(figur);
        Platform.runLater(() -> alterShape.setVisible(false));
        Platform.runLater(() -> _root.getChildren().remove(alterShape));
        _figuren.put(figur,neuerShape);
        Platform.runLater(() -> _root.getChildren().add(neuerShape));
    }

    private void entferneShape(Object figur)
    {
        Shape alterShape = _figuren.remove(figur);
        Platform.runLater(() -> alterShape.setVisible(false));
        Platform.runLater(() -> _root.getChildren().remove(alterShape));
    }

    /**
     * Warte fuer die angegebenen Millisekunden. Mit dieser Operation wird eine
     * Verzoegerung definiert, die fuer animierte Zeichnungen benutzt werden
     * kann.
     * 
     * @param millisekunden die zu wartenden Millisekunden
     */
    public void warte(int millisekunden)
    {
        try
        {
            Thread.sleep(millisekunden);
        }
        catch (Exception e)
        {
            // Exception ignorieren
        }
    }
    
    public static class Helfer
    {
        public static Leinwand gibLeinwand()
        {
            return Leinwand.gibLeinwand();
        }
    }

}

