
import java.util.Optional;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * Eine GUI fuer Tic-Tac-Toe basierend auf JAVAFX
 * 
 * @author Henri Burau & Franek Stark
 * @author Axel Schmolitzky
 * @version 2018
 */
class TicTacToeGUI
{
    private Stage _stage;
    private VBox _root;
    private Label _label;
    private GridPane _spielfeld;
    private TicTacToe _ttt;

    private StringProperty[][] _buttonText;

    private final int BUTTON_SIZE = 80;
    private final String CROSS = "\u2715"; // Unicode
    private final String CIRCLE = "\u25ef"; // Unicode

    /**
     * Initialisiert eine neue GUI. 
     * Die GUI erzeugt sich selbst ein neues TicTacToe-Spiel.
     */
    public TicTacToeGUI()
    {
        initialisiereButtonText();
        _ttt = new TicTacToe();
        new JFXPanel();
        Platform.setImplicitExit(false);
        Platform.runLater(() -> {
            _stage = new Stage();
            initialisiere(_stage);
            _stage.setAlwaysOnTop(true);
            _stage.show();
            _stage.setAlwaysOnTop(false);
            aktualisiereLabel();
        });
    }

    /**
     * initalisiert die ButtonTextProperties
     */
    private void initialisiereButtonText()
    {
        _buttonText = new StringProperty[3][3];
        for (int zeile = 0; zeile < 3; zeile++)
        {
            for (int spalte = 0; spalte < 3; spalte++)
            {
                _buttonText[zeile][spalte] = new SimpleStringProperty();
            }
        }

    }

    /**
     * Initalisiert Das Spielfeld auf eine Stage
     * @param stage die Stage
     */
    private void initialisiere(Stage stage)
    {
        initialisiereSpielfeld();
        initialisiereRoot();
        stage.setTitle("Tic Tac Toe");
        Scene scene = new Scene(_root);
        scene.getStylesheets().add("TicTacToe.csshide");
        stage.setScene(scene);
    }

    /**
     * Hilfsmethode zum initalisieren des Spielfeldes
     */
    private void initialisiereSpielfeld()
    {
        _spielfeld = new GridPane();
        _spielfeld.getStyleClass().add("grid");
        fuegeButtonsHinzu();

        ColumnConstraints buttonColumn = new ColumnConstraints();
        buttonColumn.setPercentWidth(33);
        ColumnConstraints borderColumn = new ColumnConstraints();
        borderColumn.setPercentWidth(1);

        _spielfeld.getColumnConstraints().addAll(buttonColumn, borderColumn, buttonColumn, borderColumn, buttonColumn);

        RowConstraints buttonRow = new RowConstraints();
        buttonRow.setPercentHeight(33);
        RowConstraints borderRow = new RowConstraints();
        borderRow.setPercentHeight(1);
        _spielfeld.getRowConstraints().addAll(buttonRow, borderRow, buttonRow, borderRow, buttonRow);

    }

    /**
     * Hilfsmethode, welche die Buttons zum Spielfeld hinzufügt
     */
    private void fuegeButtonsHinzu()
    {
        for (int i = 0; i <= 4; i += 2)
        {
            for (int j = 0; j <= 4; j += 2)
            {
                Button button = new Button();
                button.setMinSize(BUTTON_SIZE, BUTTON_SIZE);
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                button.setScaleShape(true);
                final int spalte = i / 2;
                final int zeile = j / 2;
                button.setOnAction(event -> wurdeAngeklickt(zeile, spalte));
                button.textProperty().bind(_buttonText[zeile][spalte]);
                _spielfeld.add(button, i, j);
            }
        }
    }

    private void initialisiereRoot()
    {
        _root = new VBox();
        _root.getChildren().add(_spielfeld);
        VBox.setVgrow(_spielfeld, Priority.ALWAYS);

        _label = new Label("PlatzhalterText");
        _label.setMinHeight(50);
        _root.setAlignment(Pos.CENTER);
        _root.getChildren().add(_label);
    }

    private void aktualisiereButton(int zeile, int spalte)
    {
        String beschriftung = zeichenFuer(_ttt.gibBesitzer(zeile, spalte));

        _buttonText[zeile][spalte].set(beschriftung);
    }

    private void aktualisiereButtons()
    {
        for (int zeile = 0; zeile < 3; zeile++)
        {
            for (int spalte = 0; spalte < 3; spalte++)
            {
                aktualisiereButton(zeile, spalte);
            }
        }
    }

    private void aktualisiereLabel()
    {
        _label.setText(beschriftungFuer(_ttt.gibAktuellenSpieler()));
    }

    
    private String zeichenFuer(int besitzer)
    {
        switch (besitzer)
        {
            case 1:
                return CROSS;
            case 2:
                return CIRCLE;
            default:
                return " ";
        }
    }

    private String beschriftungFuer(int spieler)
    {
        switch (spieler)
        {
            case 1:
                return "Spieler 1 (" + CROSS + ")";
            case 2:
                return "Spieler 2 (" + CIRCLE + ")";
            default:
                return "Keiner";
        }
    }

    /**
     * Reagiert auf einen Button-Click und teil dies der Spielogik mit
     * @param zeile Zeile des Buttons
     * @param spalte Spalte des Buttons
     */
    private void wurdeAngeklickt(int zeile, int spalte)
    {
        if (_ttt.istFrei(zeile, spalte))
        {
            _ttt.besetzePosition(zeile, spalte);
            aktualisiereButton(zeile, spalte);

            if (_ttt.spielIstZuende())
            {
                Alert alertSpielZuEnde = new Alert(AlertType.INFORMATION, "neues Spiel?", ButtonType.YES,
                        ButtonType.NO);
                alertSpielZuEnde.setTitle("Spielende");
                alertSpielZuEnde.setHeaderText(beschriftungFuer(_ttt.gibGewinner()) + " hat gewonnen!");

                Optional<ButtonType> result = alertSpielZuEnde.showAndWait();
                if (result.get() == ButtonType.YES)
                {
                    _ttt = new TicTacToe();
                    aktualisiereButtons();

                }
                else
                {
                    _stage.close();
                }

            }
            aktualisiereLabel();

        }
        else // Spielfeld nicht mehr frei
        {
            Alert alertBelegt = new Alert(Alert.AlertType.ERROR, "Die Position ist bereits belegt", ButtonType.OK);
            alertBelegt.setHeaderText("Auswahl nicht moeglich!");
            alertBelegt.setTitle("Belegt");
            alertBelegt.showAndWait();
        }

    }

}
