/**
 * In dieser Klasse wird dass Geburtstagsparadoxon anhand der
 * Messergebnisse simulierter Parties ueberprueft.
 * 
 * @author Fredrik Winkler
 * @version 2017
 */
class Simulation
{
    /**
     * Simuliere das Geburtstagsparadoxon.
     * 
     * @param gaeste
     *            die Anzahl der Gaeste auf einer Party
     * @param parties
     *            die Anzahl der Parties.
     *            Je hoeher dieser Wert, desto genauer das Messergebnis!
     * 
     * @return die Wahrscheinlichkeit einer Kollision in Prozent
     */
    public int simuliere(int gaeste, int parties)
    {
        int ueberschneidungen = 0;
        for (int p = 0; p < parties; ++p)
        {
            Party party = new PartyMenge();
            for (int g = 0; g < gaeste; ++g)
            {
                party.fuegeGeburtstagHinzu(Tag.gibZufaelligenTag());
            }
            if (party.mindestensEinGeburtstagMehrfach())
            {
                ++ueberschneidungen;
            }
        }
        return 100 * ueberschneidungen / parties;
    }

    /**
     * Simuliere das Geburtstagsparadoxon mit 10000 Parties.
     * 
     * @param gaeste
     *            die Anzahl der Gaeste auf einer Party
     * 
     * @return die Wahrscheinlichkeit einer Kollision in Prozent
     */
    public int simuliere(int gaeste)
    {
        return simuliere(gaeste, 10000);
    }

    /**
     * Testet die Implementation von PartyMenge.
     * @return true, falls der Test erfolgreich war
     */
    public boolean test()
    {
        return Math.abs(simuliere(23) - 50) < 5;
    }
}
