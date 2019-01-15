import java.io.File;
import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Diese Klasse liest Bilddateien ein und liefert ein Array von Pixeln. 
 * Das Array ist zweidimensional, 
 * die erste Dimension ist die y-Koordinate und die
 * zweite Dimension die x-Koordinate. 
 * Die Bilder sind SW-Bilder. 
 * Die jeweiligen Pixel sind Grauwerte von 0-255, wobei: 
 * 0=schwarz 
 * 255=weiss 
 * 
 * @author Franek Stark
 * @version 2018
 */
class BildEinleser 
{

    /**
     * Liest eine Bild-Datei ein und liefert die Bilddaten als Pixelarray. Die Datei
     * wird interaktiv vom Benutzer gewaehlt.
     * 
     * @return Das Array mit den Bilddaten; wenn keine Datei gewaehlt, null.
     */
    public static short[][] liesBilddaten() 
    {
        new JFXPanel(); // Initalisiert JavaFX
        Platform.setImplicitExit(false);
        BlockingQueue<File> pipe = new LinkedBlockingDeque<File>(); // Muss sein, fuer die Threadkommunikation

        Platform.runLater(() -> {
                FileChooser browser = new FileChooser();
                browser.setInitialDirectory(new File(System.getProperty("user.dir") + "/bilder"));
                browser.setTitle("Bild oeffnen");

                // Die Stage ist der Workauround um ab BLUEJ4.1.1 den Opendialialog nach Vorne
                // zu bringen ------------
                Stage stage = new Stage();
                stage.setWidth(0);
                stage.setHeight(0);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setAlwaysOnTop(true);
                stage.show();
                stage.toFront();
                // -----------------------

                File imagefile = browser.showOpenDialog(stage);
                stage.hide();

                try 
                {
                    pipe.put(imagefile);
                }
                catch (InterruptedException e) 
                {
                }
                catch (NullPointerException e)
                {
                    pipe.offer(new File("")); // Keine Datei ausgewaehlt
                }

            });

        File imagefile = null;
        Image bild = null;
        short[][] byteArr = null;

        try 
        {
            // Nimmt die File aus der Que, falls keine Vorhanden:
            // blockiert der Thread so lange, bis der FX-Thread liefert
            imagefile = pipe.take();
        }
        catch (InterruptedException ie) 
        {
        }

        if (imagefile.exists()) // Wenn die Datei existiert = Ein Bild wurde ausgewählt
        {
            bild = imageAusDatei("file:///" + imagefile.getAbsolutePath());
            byteArr = byteArrayAusImage(bild);
        }

        return byteArr;

    }

    /**
     * Liest eine Bild-Datei ein und liefert die Bilddaten als Pixelarray. Die Datei
     * wird ueber ihren Namen im Klassen-Verzeichniss gesucht.
     * 
     * @param dateiname Der Name der Bilddatei
     * @return Das Array mit den Bilddaten, wenn keine Datei gefunden null.
     */
    public static short[][] liesBilddaten(String dateiname) 
    {
        new JFXPanel();
        URL imageURL = new BildEinleser().getClass().getClassLoader().getResource(dateiname);
        if (imageURL == null) // Falls nichts gefunden wurde
        {
            return null;
        }

        Image image = imageAusDatei("file:///" + imageURL.getPath());
        return byteArrayAusImage(image);
    }

    /**
     * Macht aus einem Image das Pixel-Array und konvertiert dabei auf SW
     * 
     * @param bild das Image
     * @return das zweidimensionale Pixe-Array
     */
    private static short[][] byteArrayAusImage(Image bild) 
    {
        PixelReader pReader = bild.getPixelReader();
        int width = (int) bild.getWidth();
        int heigth = (int) bild.getHeight();

        short[][] byteArr = new short[heigth][width];

        for (int y = 0; y < heigth; y++) 
        {
            for (int x = 0; x < width; x++) 
            {
                int argb = pReader.getArgb(x, y);
                // 2-bit Integer ARGB besteht jeweils aus einem BYTE
                // A, R, G und B
                //short a = (short) ((argb & 0xFF_00_00_00) >> 24); // A-Channel wird spaeter ignoriert!
                short r = (short) ((argb & 0x00_FF_00_00) >> 16);
                short g = (short) ((argb & 0x00_00_FF_00) >> 8);
                short b = (short) ((argb & 0x00_00_00_FF) >> 0);
                byteArr[y][x] = (short) ((r + g + b) / 3);
            }
        }
        return byteArr;
    }

    /**
     * Macht aus eine, Dateipfad ein Image
     * 
     * @param datei der Dateipfad
     * @return das Image
     */
    private static Image imageAusDatei(String datei) 
    {
        Image bild = new Image(datei);
        return bild;
    }

}
