
/**
 * Etwas Anhaengbares kann an andere Zugteile angehaengt werden.
 * 
 * @author Axel Schmolitzky 
 * @version WiSe 2015/16
 */
interface Anhaengbar
{
    /**
     * Liefere die Anzahl der Passagiere in diesem anhaengbaren
     * Zugteil.
     */
    int anzahlPassagiere();

    /**
     * Liefert die Anzahl der Zugelemente des Zugteils, von dem dieses
     * Zugelement selbst der Kopf ist. Das Ergebnis ist mindestens 1.
     */
    int anzahlZugelemente();
}
