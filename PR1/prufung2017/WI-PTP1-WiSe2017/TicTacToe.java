/**
 * In dieser Klasse ist die Spiellogik von Tic Tac Toe realisiert.
 * 
 * Zwei Spieler spielen auf einem Spielfeld der Groesse 3x3 = 9 Positionen.
 * Die Spieler besetzen abwechselnd Positionen auf dem Spielfeld, bis ein Spieler
 * drei Positionen in einer Reihe besetzt hat oder das Spielfeld voll ist.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2017
 */
class TicTacToe
{
    private Spielfeld _spielfeld;
    private int _aktuellerSpieler;
    private int _gewinner;

    /**
     * Initialisiert ein neues Tic Tac Toe Spiel mit einem leeren Spielfeld.
     * Spieler 1 ist als erster dran, und das Spiel ist noch nicht zu Ende.
     */
    public TicTacToe()
    {
        _spielfeld = (Spielfeld)new ServiceMixTest.Util().erzeugeExemplarParameterlos("SpielfeldGeflecht");
        _aktuellerSpieler = 1;
        _gewinner = -1;
    }

    /**
     * Gibt an, welcher Spieler gerade dran ist.
     * 
     * @return 1 (Spieler 1) oder 2 (Spieler 2)
     * oder 0 (Spiel ist unentschieden ausgegangen)
     */
    public int gibAktuellenSpieler()
    {
        return _aktuellerSpieler;
    }

    /**
     * Wechselt den aktuellen Spieler von 1 zu 2 und umgekehrt.
     */ 
    private void wechsleSpieler()
    {
        _aktuellerSpieler = 3 - _aktuellerSpieler;
    }

    /**
     * Gibt an, ob das Spiel zu Ende ist. Falls es zu Ende ist,
     * liefert gibAktuellenSpieler() den Gewinner.
     */
    public boolean spielIstZuende()
    {
        return _gewinner != -1;
    }

    /**
     * Gibt an, ob das Spiel noch laeuft, ob das Spiel unentschieden geendet
     * ist, oder ob einer der beiden Spieler gewonnen hat.
     * 
     * @return -1 (Spiel laeuft noch), 0 (unentschieden), 1 (Spieler 1 hat
     *         gewonnen), 2 (Spieler 2 hat gewonnen)
     */
    public int gibGewinner()
    {
        return _gewinner;
    }

    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        return _spielfeld.gibBesitzer(zeile, spalte);
    }

    /**
     * Ist das Spielfeld an der angegebenen Position noch frei?
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     */
    public boolean istFrei(int zeile, int spalte)
    {
        return gibBesitzer(zeile, spalte) == 0;
    }

    /**
     * Besetzt eine Position auf dem Spielfeld fuer den aktuellen Spieler.
     * Anschliessend wird geprueft, ob der aktuelle Spieler gewonnen hat, oder
     * ob das Spielfeld voll ist. Ansonsten wird der aktuelle Spieler
     * gewechselt.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale    Position (0-2)
     */
    public void besetzePosition(int zeile, int spalte)
    {
        if (!spielIstZuende() && istFrei(zeile, spalte))
        {
            _spielfeld.besetzePosition(zeile, spalte, _aktuellerSpieler);

            if (aktuellerSpielerHatGewonnen())
            {
                _gewinner = _aktuellerSpieler;
            }
            else if (_spielfeld.istVoll())
            {
                _gewinner = 0;
            }
            else
            {
                wechsleSpieler();
            }
        }
    }

    /**
     * Diese Methode ueberprueft, ob der aktuelle Spieler
     * an allen drei uebergebenen Positionen p1, p2 und p3 das Spielfeld besetzt hat.
     * 
     * @param pos1Zeile Zeilennummer der ersten Position (0-2)
     * @param pos1Spalte Spaltennummer der ersten Position (0-2)
     * @param pos2Zeile Zeilennummer der zweiten Position (0-2)
     * @param pos2Spalte Spaltennummer der zweiten Position (0-2)
     * @param pos3Zeile Zeilennummer der dritten Position (0-2)
     * @param pos3Spalte Spaltennummer der dritten Position (0-2)
     * @return true, wenn der aktuelle Spieler alle drei spezifizierten
     *         Positionen besetzt, sonst false.
     */
    private boolean aktuellerSpielerBesitzt(int pos1Zeile, int pos1Spalte,
                                            int pos2Zeile, int pos2Spalte,
                                            int pos3Zeile, int pos3Spalte)
    {
        return aktuellerSpielerBesitzt(pos1Zeile,pos1Spalte)
           &&  aktuellerSpielerBesitzt(pos2Zeile,pos2Spalte)
           &&  aktuellerSpielerBesitzt(pos3Zeile,pos3Spalte);
    }
    
    private boolean aktuellerSpielerBesitzt(int zeile, int spalte)
    {
        return gibBesitzer(zeile,spalte) == gibAktuellenSpieler();
    }

    /**
     * Diese Methode ueberprueft, ob der aktuelle Spieler das Spiel
     * gewonnen hat. Der Spieler hat gewonnen, wenn er alle Felder in einer
     * Zeile, alle Felder in einer Spalte oder alle Felder in einer
     * Diagonalen besetzt hat.
     * 
     * @return true, falls der aktuelle Spieler eine
     * der acht moeglichen Gewinnsituationen erreicht hat, sonst false.
     */
    private boolean aktuellerSpielerHatGewonnen()
    {
        return aktuellerSpielerBesitzt(0,0 , 0,1 , 0,2) // Zeile 0
            || aktuellerSpielerBesitzt(1,0 , 1,1 , 1,2) // Zeile 1
            || aktuellerSpielerBesitzt(2,0 , 2,1 , 2,2) // Zeile 2

            || aktuellerSpielerBesitzt(0,0 , 1,0 , 2,0) // Spalte 0
            || aktuellerSpielerBesitzt(0,1 , 1,1 , 2,1) // Spalte 1
            || aktuellerSpielerBesitzt(0,2 , 1,2 , 2,2) // Spalte 2

            || aktuellerSpielerBesitzt(0,0 , 1,1 , 2,2) // Diagonale 1
            || aktuellerSpielerBesitzt(0,2 , 1,1 , 2,0);// Diagonale 2
    }
}
