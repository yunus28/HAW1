import spielkarten.Skatspiel;
import spielkarten.Kartenrang;
import spielkarten.Kartenfarbe;
import spielkarten.Spielkarte;
import static spielkarten.Kartenrang.*;
import static spielkarten.Kartenfarbe.*;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;


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
    private Map<Kartenrang, Integer> _punkteMap; 

    /**
     * Eine Mau-Mau-Runde besteht aus einem Skatspiel 
     * (32 Karten) und drei Spielern.
     * Anfangs haben alle Spieler noch keine Karten.
     */
    public MauMauRunde()
    {
        _kartensatz = new Skatspiel();
        _punkteMap = erstellePunkteMap();
        _spieler1 = new Spieler("Spieler1", _punkteMap);
        _spieler2 = new Spieler("Spieler2", _punkteMap);
        _spieler3 = new Spieler("Spieler3", _punkteMap);
    }
    
    public Map<Kartenrang, Integer> gibRangZuPunkteMap()
    {
        return _punkteMap;
    }
  
    
    private HashMap<Kartenrang, Integer> erstellePunkteMap()
    {
        HashMap<Kartenrang, Integer> map = new HashMap<Kartenrang, Integer>();
        map.put(SIEBEN, 3);
        map.put(ACHT, 3);
        map.put(NEUN, 3);
        map.put(BUBE, 2);
        map.put(DAME, 6);
        map.put(KOENIG, 6);
        map.put(ZEHN, 4);
        map.put(AS, 11);
        return map;
    }
    
    public KartenTripel zieheDrilling()
    {
        Kartenstapel stapel = new Kartenstapel();
        HashSet<Spielkarte> gezogeneKarten = new HashSet<Spielkarte>();
        HashMap<Kartenrang, Integer> zaehler = new HashMap<Kartenrang, Integer>();
        Kartenrang tripelRang = null;
        
        boolean keinDrilling = true;
        while(keinDrilling)
        {
            // if(stapel.anzahlKarten() == 0) //mehr karten falls kein drilling exisitiert
            // {
                // stapel = new Kartenstapel();
            // }
            Spielkarte sk = stapel.obersteKarteZiehen();
            gezogeneKarten.add(sk);
            
            if (zaehler.containsKey( sk.rang() ) )
            {
                zaehler.put(sk.rang(), zaehler.get(sk.rang()) + 1 );
                if (zaehler.get(sk.rang()) == 3)
                {
                    keinDrilling = false;
                    tripelRang = sk.rang();
                }
            } else
            {
                zaehler.put(sk.rang(), 1);
            }
        }
        return gib3Ranggleiche(gezogeneKarten, tripelRang);
    }
    
    private KartenTripel gib3Ranggleiche(HashSet<Spielkarte> karten, Kartenrang tripelRang)
    {
        Spielkarte k1 = null;
        Spielkarte k2 = null;
        Spielkarte k3 = null;
        for (Spielkarte sk: karten)
        {
            if(sk.rang() == tripelRang)
            {
                if(k1 == null)
                {
                    k1 = sk;
                } else if(k2 == null)
                {
                    k2 = sk;
                } else if(k3 == null)
                {
                    k3 = sk;
                    return new KartenTripel(k1,k2,k3);
                }                
            } 
        }
        return null;
    }

    public KartenTripel zieheDreiBilder()
    {
        Kartenstapel stapel = new Kartenstapel();
        Spielkarte k1 = zieheEinBild(stapel);
        Spielkarte k2 = zieheEinBild(stapel);
        Spielkarte k3 = zieheEinBild(stapel);
        KartenTripel tripel = new KartenTripel(k1,k2,k3);
        return tripel;
    }
    
    private Spielkarte zieheEinBild(Kartenstapel stapel)
    {
        Spielkarte karte = null;
        do
        {
            karte = stapel.obersteKarteZiehen();
        } while (!istBild(karte));
        return karte;
    }
    
    private boolean istBild(Spielkarte karte)
    {
        return karte.rang() == KOENIG || karte.rang() == DAME || karte.rang() == BUBE;
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
        Spieler verlierer = verliererErmitteln();
        System.out.println("Der Gewinner ist " + gewinner + 
            "\t Der Verlierer ist " + verlierer);
    }
    
    private Spieler verliererErmitteln()
    {
        int punkte = 0;
        Spieler verlierer = null;
        if (_spieler1.zaehlePunkte() > punkte)
        {
            punkte = _spieler1.zaehlePunkte();
            verlierer = _spieler1;
        }
        if (_spieler2.zaehlePunkte() > punkte)
        {
            punkte = _spieler2.zaehlePunkte();
            verlierer = _spieler2;
        }
        if (_spieler3.zaehlePunkte() > punkte)
        {
            punkte = _spieler3.zaehlePunkte();
            verlierer = _spieler3;
        }
        return verlierer;
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
