import spielkarten.Skatspiel;
import spielkarten.Kartenfarbe;
import spielkarten.Spielkarte;
import static spielkarten.Kartenrang.*;
import static spielkarten.Kartenfarbe.*;

/**
 * Eine Mau-Mau-Runde besteht aus drei Spielern und einem Skatspiel (32 Karten).
 * In einer Mau-Mau-Runde werden mehrere Spiele gespielt. <br>
 * In einem einzelnen Spiel wird bzw. werden nacheinander: <br>
 * - an jeden Spieler fuenf Karten verteilt <br>
 * - von den restlichen Karten die oberste aufgedeckt <br>
 * - von jedem Spieler reihum eine zur obersten Karte passende Karte abgelegt, 
 *   bis ein Spieler keine Karten mehr hat.<br>
 * <br>
 * 
 * @author Axel Schmolitzky 
 * @version 2018
 */
class MauMauRunde
{
    private Spieler _spieler1;
    private Spieler _spieler2;
    private Spieler _spieler3;
    private Skatspiel _kartensatz;

    /**
     * Eine Mau-Mau-Runde besteht aus einem Skatspiel 
     * (32 Karten) und drei Spielern.
     * Anfangs haben alle Spieler noch keine Karten.
     */
    public MauMauRunde()
    {
        _kartensatz = new Skatspiel();
        _spieler1 = new Spieler("Spieler1");
        _spieler2 = new Spieler("Spieler2");
        _spieler3 = new Spieler("Spieler3");
    }

    /**
     * Karten verteilen: Jeder Spieler erhält fünf Karten.
     * Die restlichen Karten werden als Ergebnis geliefert.
     */
    public Kartenstapel kartenVerteilen()
    {
        Kartenstapel stapel = new Kartenstapel(_kartensatz);

        for (int i=0; i < 5; ++i)
        {
            _spieler1.nimmKarte(stapel.obersteKarteZiehen());
            _spieler2.nimmKarte(stapel.obersteKarteZiehen());
            _spieler3.nimmKarte(stapel.obersteKarteZiehen());
        }
        return stapel;
    }

    /**
     * Diese Methode simuliert ein Spiel in einer Mau-Mau-Runde.
     */
    public void spielenBisGewinnerErmittelt()
    {
        Kartenstapel kartenstapel = kartenVerteilen();
        Spielkarte obersteKarte = kartenstapel.obersteKarteZiehen();
        Kartenansicht ansicht = new Kartenansicht("oberste Karte");
        ansicht.zeige(obersteKarte);
        while (jederSpielerHatNochMindestensEineKarte())
        {
            obersteKarte = eineRundeSpielen(ansicht, obersteKarte,kartenstapel);
        }
        Spieler gewinner = gewinnerErmitteln();
        kartenEinsammeln();
    }

    /**
     * Jeder Spieler bekommt Gelegenheit, eine Karte abzulegen, es sei denn,
     * ein Spieler legt seine letzte Karte ab. Liefert als Ergebnis die
     * zuletzt abgelegte Spielkarte. Wenn ein Spieler nicht bedienen kann,
     * muss er eine frische Karte vom Stapel ziehen.
     * @param ablage die Kartenansicht, die die zuletzt abgelegte Karte zeigt.
     * @param obersteKarte die zuletzt abgelegte Karte.
     * @param stapel der Stapel mit den "frischen" Karten, falls ein Spieler
     *               nicht bedienen kann.
     */
    public Spielkarte eineRundeSpielen(Kartenansicht ablage,
                                       Spielkarte obersteKarte, 
                                       Kartenstapel stapel)
    {
        obersteKarte = obersteKarteDurch(_spieler1,ablage,obersteKarte,stapel);
        if (_spieler1.anzahlKarten() == 0)
        {
            return obersteKarte;  // Ausstieg, Spiel zuende
        }
        obersteKarte = obersteKarteDurch(_spieler2,ablage,obersteKarte,stapel);
        if (_spieler2.anzahlKarten() == 0)
        {
            return obersteKarte; // Ausstieg, Spiel zuende
        }
        return obersteKarteDurch(_spieler3,ablage,obersteKarte,stapel);
    }

    private Spielkarte obersteKarteDurch(Spieler spieler, Kartenansicht ansicht,
                                         Spielkarte oberste, Kartenstapel stapel)
    {
        Spielkarte neueOberste = spieler.bediene(oberste);
        if (neueOberste != oberste) // Spieler konnte bedienen
        {
            ansicht.zeige(neueOberste);
        }
        else // Spieler konnte nicht bedienen, Karte ziehen
        {
            spieler.nimmKarte(stapel.obersteKarteZiehen());
        }
        return neueOberste;
    }

    private boolean jederSpielerHatNochMindestensEineKarte()
    { 
        return _spieler1.anzahlKarten() > 0
        && _spieler2.anzahlKarten() > 0
        && _spieler3.anzahlKarten() > 0;
    }

    /**
     * Liefert während eines Spiels den Spieler, der als erster 
     * keine Karten mehr hat.
     */
    private Spieler gewinnerErmitteln()
    {
        if (_spieler1.anzahlKarten() == 0)
        {
            return _spieler1;
        }
        else if (_spieler2.anzahlKarten() == 0)
        {
            return _spieler2;
        }
        else if (_spieler3.anzahlKarten() == 0)
        {
            return _spieler3;
        }
        else
        {
            return null;
        }
    }

    /**
     * Alle Karten einsammeln, damit neu verteilt werden kann.
     */
    public void kartenEinsammeln()
    {
        _spieler1.gibAlleKartenAb();
        _spieler2.gibAlleKartenAb();
        _spieler3.gibAlleKartenAb();
    }

    /**
     * Liefert Spieler 1 dieser Runde.
     */
    public Spieler spieler1()
    {
        return _spieler1;
    }

    /**
     * Liefert Spieler 2 dieser Runde.
     */
    public Spieler spieler2()
    {
        return _spieler2;
    }

    /**
     * Liefert Spieler 3 dieser Runde.
     */
    public Spieler spieler3()
    {
        return _spieler3;
    }

}
