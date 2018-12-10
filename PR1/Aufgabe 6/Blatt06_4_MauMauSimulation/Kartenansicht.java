import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import static spielkarten.Kartenfarbe.*;
import static spielkarten.Kartenbild.*;
import static spielkarten.Kartenrang.*;
import spielkarten.Spielkarte;

import java.util.List;

/**
 * Eine Kartenansicht liefert eine grafische Darstellung von einer 
 * gegebenen Menge an Spielkarten.
 * 
 * @author Axel Schmolitzky
 * @version 2018
 */
class Kartenansicht
{

    private FlowPane _root;
    private Stage _stage;

    /**
     * Initialisiert eine neue Kartenansicht mit einem Titel.
     * @param titel der Titel des Fensters
     */
    public Kartenansicht(String titel)
    {
        new JFXPanel();
        Platform.setImplicitExit(false);
        Platform.runLater( () -> init(titel) );
    }

    private void init(String titel)
    {
        _stage = new Stage();
        _stage.setTitle(titel);
        _stage.setAlwaysOnTop(true);
        _root = new FlowPane();
        Scene scene = new Scene(_root,500,150);
        _stage.setScene(scene);
        _stage.show();
        _stage.setAlwaysOnTop(false);
    }

    /**
     * Zeigt eine einzelne Spielkarte an.
     * @param karte die anzuzeigende Spielkarte
     */
    public void zeige(Spielkarte karte)
    {
        Platform.runLater( () -> {
                _root.getChildren().clear();
                _root.getChildren().add(macheTextAusKarte(karte.bild()));
            } );
    }

    /**
     * Zeigt alle Karten aus einer Liste von Karten an.
     * @param kartenliste eine Liste mit Spielkarten
     */
    public void zeige(List<Spielkarte> kartenliste)
    {
        Platform.runLater( () -> {
                _root.getChildren().clear();
                for (Spielkarte k : kartenliste)
                {
                    _root.getChildren().add(macheTextAusKarte(k.bild()));
                }
            } );
    }

    /**
     * Zieht alle Karten von einem Kartenstapel und zeigt diese an.
     * @param stapel der Kartenstapel mit den anzuzeigenden Spielkarten
     */
    public void zeige(Kartenstapel stapel)
    {
        Platform.runLater( () -> {
                _root.getChildren().clear();
                while (stapel.anzahlKarten() > 0)
                {
                    Spielkarte k = stapel.obersteKarteZiehen();
                    _root.getChildren().add(macheTextAusKarte(k.bild()));
                }
            } );
    }

    private Text macheTextAusKarte(spielkarten.Kartenbild karte)
    {
        Text t = new Text(gibStringVonCodepoint(karte.codepoint()));
        t.setFont(new Font(96));
        Color farbe = Color.BLACK;
        if (karte.farbe() == HERZ || karte.farbe() == KARO)
        {
            farbe = Color.RED;
        }
        t.setFill(farbe);
        return t;
    }

    private String gibStringVonCodepoint(int codepoint)
    {
        char high = Character.highSurrogate(codepoint);
        char low = Character.lowSurrogate(codepoint);
        return "" + high + low;

    }


}
