import java.util.List;

/**
 * Diese Klasse dient als Startup fuer die Aufgabe zur
 * Implementierung von Hash-Verfahren.
 * 
 * @author Fredrik Winkler, Petra Becker-Pechau, Axel Schmolitzky
 * @version 2018
 */
class Startup
{
    // Einige Primzahlen, die sich gut zur Dimensionierung von Hashtabellen eignen:
    private static final int MINI   =    11;
    private static final int KLEIN  =   101;
    private static final int MITTEL =  1009;
    private static final int GROSS  = 10007;

    /**
     * Zeigt die Hashtabelle eines Wortschatzes auf der Konsole an.
     */
    public static void visualisiereHashtabelle()
    {
        List<String> kurz = Worteinleser.dateiAlsText("trinken.txt");
        HashWertBerechner delegation = new Delegation();

        extrahiereWortschatz(kurz, delegation, MINI).schreibeAufKonsole();
    }
    
    /**
     * Vergleicht die Performance verschiedener Hashfunktionen.
     */
    public static void vergleichePerformance()
    {
        List<String> lang = Worteinleser.dateiAlsText("moby10b.txt");
        HashWertBerechner delegation = new Delegation();
        
        vermesse(lang, delegation, KLEIN);
    }

    /**
     * Extrahiert einen Wortschatz aus dem gegebenenen Text.
     *
     * @param text der zu verarbeitende Text
     * @param berechner der zu verwendende HashWertBerechner
     * @param groesse die Anzahl der Ueberlaufbehaelter
     * @return der extrahierte Wortschatz
     */
    private static HashWortschatz extrahiereWortschatz(List<String> text,
                                                       HashWertBerechner berechner,
                                                       int groesse)
    {
        HashWortschatz wortschatz = new HashWortschatz(berechner, groesse);
        for (String wort : text)
        {
            wortschatz.fuegeWortHinzu(wort);
        }
        return wortschatz;
    }
    
    /**
     * Diese Methode misst, wie lange es dauert,
     * einen Wortschatz aus dem gegebenen Text zu extrahieren.
     *
     * @param text der zu verarbeitende Text
     * @param berechner der zu verwendende HashWertBerechner
     * @param groesse die Anzahl der Ueberlaufbehaelter
     */
    private static void vermesse(List<String> text,
                                 HashWertBerechner berechner,
                                 int groesse)
    {
        Stoppuhr uhr = new Stoppuhr(System.out, berechner.gibBeschreibung());
        Wortschatz wortschatz = extrahiereWortschatz(text, berechner, groesse);
        uhr.stopp();
        System.out.println(wortschatz.anzahlWoerter() + " verschiedene Woerter gefunden");
        if (wortschatz instanceof HashWortschatz)
        {
            HashWortschatz hash = (HashWortschatz)wortschatz;
            System.out.println("Fuellgrad der Hash-Tabelle: " + hash.fuellgrad() + "%");
            System.out.println("Laengste Kette: " + hash.laengsteKette() + "\n");
        }

    }
}
