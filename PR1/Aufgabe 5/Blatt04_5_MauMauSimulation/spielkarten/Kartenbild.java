package spielkarten;

import static spielkarten.Kartenfarbe.*;
import static spielkarten.Kartenrang.*;

/**
 * Die möglichen Kartenbilder eines Kartenspiels als Aufzählung.
 * Ein Kartenbild setzt sich zusammen aus einer Kartenfarbe und einem
 * Kartenrang.<br>
 * Da es im Unicode-Zeichensatz auch Zeichen für Kartenbilder gibt,
 * kennt jedes Kartenbild zusätzlich seinen passenden Codepunkt.<br><br>
 * Beispiel: Das Pik-As (engl.: Ace of Spades) hat den (hexadezimal
 * dargestellten) Codepunkt 1f0a1.<br><br>
 * Dieses Zeichen kann auch direkt hier in HTML dargestellt werden: &#x1f0a1;,
 * etwas vergrößert: <font size="+7">&#x1f0a1;</font>
 * 
 * @author Axel Schmolitzky 
 * @version 2018
 */ 
public enum Kartenbild
{
    /** Herz Zwei */ H2(HERZ, ZWEI, 0x1f0b2), 
    /** Herz Drei */ H3(HERZ, DREI, 0x1f0b3),
    /** Herz Vier */ H4(HERZ, VIER, 0x1f0b4),
    /** Herz Fuenf */ H5(HERZ, FUENF, 0x1f0b5),
    /** Herz Sechs */ H6(HERZ, SECHS, 0x1f0b6),
    /** Herz Sieben */ H7(HERZ, SIEBEN, 0x1f0b7),
    /** Herz Acht */ H8(HERZ, ACHT, 0x1f0b8),
    /** Herz Neun */ H9(HERZ, NEUN, 0x1f0b9),
    /** Herz Zehn */ H10(HERZ, ZEHN, 0x1f0ba),
    /** Herz Bube */ HB(HERZ, BUBE, 0x1f0bb),
    /** Herz Dame */ HD(HERZ, DAME, 0x1f0bd),
    /** Herz Koenig */ HK(HERZ, KOENIG, 0x1f0be),
    /** Herz As */ HA(HERZ, AS, 0x1f0b1),

    /** Karo Zwei */ KA2(KARO, ZWEI, 0x1f0c2),
    /** Karo Drei */ KA3(KARO, DREI, 0x1f0c3),
    /** Karo Vier */ KA4(KARO, VIER, 0x1f0c4),
    /** Karo Fuenf */ KA5(KARO, FUENF, 0x1f0c5),
    /** Karo Sechs */ KA6(KARO, SECHS, 0x1f0c6),
    /** Karo Sieben */ KA7(KARO, SIEBEN, 0x1f0c7),
    /** Karo Acht */ KA8(KARO, ACHT, 0x1f0c8),
    /** Karo Neun */ KA9(KARO, NEUN, 0x1f0c9),
    /** Karo Zehn */ KA10(KARO, ZEHN, 0x1f0ca),
    /** Karo Bube */ KAB(KARO, BUBE, 0x1f0cb),
    /** Karo Dame */ KAD(KARO, DAME, 0x1f0cd),
    /** Karo Koenig */ KAK(KARO, KOENIG, 0x1f0ce),
    /** Karo As */ KAA(KARO, AS, 0x1f0c1),


    /** Pik Zwei */ P2(PIK, ZWEI, 0x1f0a2),
    /** Pik Drei */ P3(PIK, DREI, 0x1f0a3),
    /** Pik Vier */ P4(PIK, VIER, 0x1f0a4),
    /** Pik Fuenf */ P5(PIK, FUENF, 0x1f0a5),
    /** Pik Sechs */ P6(PIK, SECHS, 0x1f0a6),
    /** Pik Sieben */ P7(PIK, SIEBEN, 0x1f0a7),
    /** Pik Acht */ P8(PIK, ACHT, 0x1f0a8),
    /** Pik Neun */ P9(PIK, NEUN, 0x1f0a9),
    /** Pik Zehn */ P10(PIK, ZEHN, 0x1f0aa),
    /** Pik Bube */ PB(PIK, BUBE, 0x1f0ab),
    /** Pik Dame */ PD(PIK, DAME, 0x1f0ad),
    /** Pik Koenig */ PK(PIK, KOENIG, 0x1f0ae),
    /** Pik As */ PA(PIK, AS, 0x1f0a1),

    /** Kreuz Zwei */ KR2(KREUZ, ZWEI, 0x1f0d2),
    /** Kreuz Drei */ KR3(KREUZ, DREI, 0x1f0d3),
    /** Kreuz Vier */ KR4(KREUZ, VIER, 0x1f0d4),
    /** Kreuz Fuenf */ KR5(KREUZ, FUENF, 0x1f0d5),
    /** Kreuz Sechs */ KR6(KREUZ, SECHS, 0x1f0d6),
    /** Kreuz Sieben */ KR7(KREUZ, SIEBEN, 0x1f0d7),
    /** Kreuz Acht */ KR8(KREUZ, ACHT, 0x1f0d8),
    /** Kreuz Neun */ KR9(KREUZ, NEUN, 0x1f0d9),
    /** Kreuz Zehn */ KR10(KREUZ, ZEHN, 0x1f0da),
    /** Kreuz Bube */ KRB(KREUZ, BUBE, 0x1f0db),
    /** Kreuz Dame */ KRD(KREUZ, DAME, 0x1f0dd),
    /** Kreuz Koenig */ KRK(KREUZ, KOENIG, 0x1f0de),
    /** Kreuz As */ KRA(KREUZ, AS, 0x1f0d1);
    
    private Kartenfarbe _farbe;
    private Kartenrang _rang;
    private int _codepoint;
    
    private Kartenbild(Kartenfarbe farbe, Kartenrang rang, int codepoint)
    {
        _farbe = farbe;
        _rang = rang;
        _codepoint = codepoint;
    }
    
    public Kartenfarbe farbe()
    {
        return _farbe;
    }
    
    public Kartenrang rang()
    {
        return _rang;
    }
    
    /**
     * Liefert den Codepoint des passenden Zeichens im Unicode-Zeichensatz.
     */
    public int codepoint()
    {
        return _codepoint;
    }

    public String toString()
    {
        return "" + _farbe + "-" + _rang;
    }
        
}
