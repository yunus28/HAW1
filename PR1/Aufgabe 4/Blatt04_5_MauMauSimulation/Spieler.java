import spielkarten.*;
import java.util.*;

/**
 * Ein Spieler in einer Mau-Mau-Runde. Ein Mau-Mau-Spieler hat 
 * einen Namen und kann Karten aufnehmen und wieder ablegen.
 * 
 * @author Axel Schmolitzky
 * @version 2018
 */
class Spieler 
{
    private final String _name;
    private List<Spielkarte> _hand;
    private Kartenansicht _kartensicht;

    /**
     * Initialisierung eines Spielers: Anfangs hat
     * er keine Karte.
     * @param name der Name des Spielers
     */
    public Spieler(String name)
    {
        _name = name;
        _hand = new LinkedList<Spielkarte>();
        _kartensicht = new Kartenansicht("Karten von " + _name);
    }

    /**
     * Nimm eine Karte auf die Hand.
     * @param k die aufzunehmende Karte.
     */
    public void nimmKarte(Spielkarte k)
    {
        _hand.add(k);
        zeigeHand();
    }

    /**
     * Bediene die Karte, falls moeglich. Falls nich möglich, mache nix.
     * @param karte die oberste Karte auf dem Spielstapel
     * @return die bedienende Karte, falls bedient werden kann, 
     * sonst die alte oberste Karte.
     */
    public Spielkarte bediene(Spielkarte karte)
    {
        Spielkarte passendeKarte = passendZu(karte);
        if (passendeKarte != null)
        {
            _hand.remove(passendeKarte);
            zeigeHand();
            return passendeKarte;
        }
        else
        {
            return karte;
        }
    }

    private Spielkarte passendZu(Spielkarte karte)
    {
        Spielkarte passend = null;
        for (Spielkarte k : _hand)
        {
            if (karte.farbe() == k.farbe()
            ||  karte.rang() == k.rang()   )
            {
                passend = k;
            }
        }
        return passend;
    }

    public int anzahlKarten()
    {
        return _hand.size();
    }

    /**
     * Dieser Spieler soll alle Karten auf der Hand abgeben.
     */
    public void gibAlleKartenAb()
    {
        _hand.clear();
        zeigeHand();
    }

    public String toString()
    {
        return _hand.toString();
    }
    
    private void zeigeHand()
    {
        _kartensicht.zeige(new ArrayList<Spielkarte>(_hand));
    }
}
