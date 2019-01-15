import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Ein Exemplar der Klasse Leinwand bietet eine Zeichenflaeche,
 * auf der ein zweidimensionales Array von Bildpunkten dargestellt werden kann.
 * 
 * 
 * Die erste Dimension des Arrays haelt die y-Koordinate (Zeilen) und
 * die zweite Dimension die x-Koordinate. Die Bilder sind SW-Bilder. Die
 * Bildpunkte sind short-Werte aus dem Bereich 0-255, die Grauwerte darstellen,
 * für die gilt: 0=schwarz 255=weiss
 * 
 * @author Franek Stark, Axel Schmolitzky
 * @version 2018
 */
class Leinwand
{

    private Stage _stage;
    private ImageView _imageView;

    /**
     * Initialisiert eine neue Leinwand.
     * 
     * @param title
     *            Der Titel der Leinwand
     * @param width
     *            Die Breite der Leinwand
     * @param height
     *            Die Hoehe der Leinwand
     * @param bgColour
     *            Die Hintergrundfarbe
     */
    public Leinwand(String title, int width, int height, Color bgColour)
    {
        new JFXPanel(); // Dient zur initalisierung von JAVAFX
        Platform.setImplicitExit(false);

        Platform.runLater(() -> { // Auf dem FX-Thread

            _stage = new Stage();
            _stage.setTitle(title);
            _stage.setResizable(false);
            _stage.setWidth(width);
            _stage.setHeight(height);

            Group root = new Group();
            Scene scene = new Scene(root, width, height, bgColour);

            _imageView = new ImageView();
            root.getChildren().add(_imageView);
            _stage.setScene(scene);

        });
    }

    /**
     * Erzeugt eine Leinwand mit Standardhintergrund(Weiss)
     * 
     * @param title
     *            Der Titel der Leinwand
     * @param width
     *            Die Breite der Leinwand
     * @param height
     *            Die Hoehe der Leinwand
     */
    public Leinwand(String title, int width, int height)
    {
        this(title, width, height, Color.WHITE);
    }

    /**
     * Diese Leinwand sichtbar machen. Diese Methode kann auch benutzt werden,
     * um eine sichtbare Leinwand wieder vor andere Fenster zu holen.
     */
    public void sichtbarMachen()
    {
        Platform.runLater(() -> {
            _stage.setAlwaysOnTop(true);
            _stage.show();
            _stage.toFront();
            _stage.setAlwaysOnTop(false);
        });

    }

    /**
     * Zeichnet ein Bild, das in unserem internen Format angegeben ist (ein
     * zweidimensionales Array von Grauwerten als short-Werte).
     */
    public void zeichneBild(short[][] bild)
    {
        Platform.runLater(() -> {

            int height = bild.length;
            int width = bild[0].length;

            WritableImage wi = new WritableImage(width, height);
            PixelWriter pw = wi.getPixelWriter();

            for (int y = 0; y < height; y++)
            {
                for (int x = 0; x < width; x++)
                {
                    short value = bild[y][x];
                    pw.setColor(x, y, Color.rgb(value, value, value));
                }
            }

            _imageView.setImage(wi);
            _stage.sizeToScene();

        });

    }

}
