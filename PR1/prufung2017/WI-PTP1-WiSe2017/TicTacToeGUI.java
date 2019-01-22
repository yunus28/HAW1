import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Die Grafische Benutzungsoberflaeche fuer Tic Tac Toe.
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2017
 */
class TicTacToeGUI
{
    private TicTacToe _ttt;
    private JFrame _frame;
    private final JPanel _rows;
    private final JLabel _label;
    private final JPanel _panel;

    private final String
        ENDE_TEXT = " hat gewonnen. OK druecken fuer ein weiteres Spiel!";
    private final String
        BELEGT = "Diese Position ist bereits belegt. Bitte eine andere waehlen!";

    public TicTacToeGUI()
    {
        _frame = new JFrame("Tic Tac Toe");
        _ttt = new TicTacToe();

        _rows = new JPanel();
        _rows.setLayout(new BoxLayout(_rows, BoxLayout.Y_AXIS));

        final Font font = new Font("MONOSPACED", Font.PLAIN, 36);
        for (int y = 0; y < 3; ++y)
        {
            final JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
            for (int x = 0; x < 3; ++x)
            {
                final JButton button = new JButton();
                button.setFont(font);
                button.addActionListener(new ButtonListener(y, x));
                row.add(button);
            }
            _rows.add(row);
        }

        _label = new JLabel();
        _label.setFont(new Font("SANS SERIF", Font.PLAIN, 24));

        _panel = new JPanel();
        _panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));

        _rows.setAlignmentX(0.5f);
        _label.setAlignmentX(0.5f);
        _panel.add(_rows);
        _panel.add(_label);
        _frame.add(_panel);

        refresh();

        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setSize(256, 256);
        _frame.setVisible(true);
        _frame.setAlwaysOnTop(true);
    }

    private void refreshPlayfield()
    {
        for (int y = 0; y < 3; ++y)
        {
            final JPanel row = (JPanel) (_rows.getComponent(y));
            for (int x = 0; x < 3; ++x)
            {
                final JButton button = (JButton) (row.getComponent(x));
                button.setText(beschriftungFuer(_ttt.gibBesitzer(y, x)));
            }
        }
        _label.setText(nameFuer(_ttt.gibAktuellenSpieler()));
    }

    private void refreshLabel()
    {
        _label.setText(nameFuer(_ttt.gibAktuellenSpieler()));
    }

    private void refresh()
    {
        refreshPlayfield();
        refreshLabel();
    }
    
    private String nameFuer(int spieler)
    {
        switch (spieler)
        {
            case 1: return "Spieler 1 (X)";
            case 2: return "Spieler 2 (O)";
            default:  return "Keiner";
        }
    }

    private String beschriftungFuer(int besitzer)
    {
        switch (besitzer)
        {
            case 1: return "X";
            case 2: return "O";
            default: return " ";
        }
    }

    private class ButtonListener implements ActionListener
    {
        private final int zeile, spalte;

        public ButtonListener(int zeile, int spalte)
        {
            this.zeile = zeile;
            this.spalte = spalte;
        }

        public void actionPerformed(ActionEvent e)
        {
            if (_ttt.istFrei(zeile, spalte))
            {
                _ttt.besetzePosition(zeile, spalte);
                refreshPlayfield();

                if (_ttt.spielIstZuende())
                {
                    JOptionPane.showMessageDialog(_rows,
                             nameFuer(_ttt.gibAktuellenSpieler()) + ENDE_TEXT,
                             "Spielende",
                             JOptionPane.INFORMATION_MESSAGE);
                    _ttt = new TicTacToe();
                    refresh();
                }
                else
                {
                    refreshLabel();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(_rows, BELEGT, "Position belegt",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
