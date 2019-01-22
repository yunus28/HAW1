import java.util.List;

/**
 * Ein Interface mit mehreren Dienstleister-Operationen. 
 * 
 * @author Axel Schmolitzky
 * @version WiSe 2017/2018
 */
interface ServiceMix
{
    /**
     * Bekommt eine Liste mit Woertern und liefert die Anzahl der Duplikate darin.<br>
     * Beispiel: [ "a", "b", "c", "d", "c", "b", "a", "c" ] liefert 4 <br>
     * Die Parameter-Liste darf nicht veraendert werden!
     * @param woerter eine Liste mit Woertern
     * @return die Anzahl der Duplikate in der Parameterliste
     */
    public int anzahlDuplikate(List<String> woerter);

    /**
     * Liefert fuer einen uebergebenen String die Anzahl der Auftreten
     * des ebenfalls uebergebenen Zeichens innerhalb des Strings.
     * @param vonChar das Zeichen, dessen Auftreten gezaehlt werden soll
     * @param inString der String, in dem gezaehlt werden soll
     * @return 
     */
    public int anzahlAuftreten(char vonChar, String inString);
    
    /**
     * Verbindet die in einer String-Liste gegebenen Worte zu einem einzigen String.
     * Der String enthaelt als Trennzeichen zwischen den Worten ein Semikolon. Am 
     * Anfang oder am Schluss soll kein Semikolon stehen.
     * Beispiel: fuer eine Liste der Laenge 2 mit den Worten "Hallo" und "Welt" liefert
     * diese Methode als Ergebnis den String "Hallo;Welt".
     * @param worte eine Liste von nicht-leeren Strings, darf nicht null sein
     * @return einen String, der die in der Liste gegebenen Worte verbindet,
     * Trennzeichen: Semikolon.
     */
    public String worteVerbinden(List<String> worte);

    /**
     * Bekommt zwei Arrays von Strings und liefert ein neues Array,
     * in dem an der n-ten Position die Verkettung der beiden Strings an Position n der
     * Parameter-Arrays steht. Dabei wird immer der laengere String an den kuerzeren
     * gehaengt. Sind die Strings gleich lang, wird der String aus dem zweiten Array
     * an den String aus dem ersten Array gehaengt.<br>
     * Beispiel: fuer { "A", "BB", "CCC" } und { "DDD", "EE", "F" }
     * liefert die Methode { "ADDD", "BBEE", "FCCC" } <br>
     * Wenn ein Array kuerzer ist als das andere, sollen die "freien" Zellen fuer die 
     * Konkatenation logisch mit leeren Strings aufgefuellt werden. <br>
     * Beispiel: fuer { "1", "2" } und { "3", "4", "5" }
     * liefert die Methode { "13", "24", "5" } <br>
     * Die Parameter-Arrays duerfen nicht veraendert werden!
     * @param werte1 ein Array von Strings, darf nicht null sein
     * @param werte2 ein Array von Strings, darf nicht null sein
     * @return ein Array mit der gleichen Laenge wie das laengere der Parameter-Arrays.
     */
    public String[] konkateniere(String[] s1, String[] s2);
    
    /**
     * Liefert fuer einen uebergebenen Namen im Snake-Case-Format
     * den entsprechenden Namen im Camel-Case-Format.
     * Die Konvention fuer zusammengesetzte Namen (fuer Klassen, Methoden
     * oder Variablen) in Java-Quelltexten ist, dass sie Camel-Case befolgen.
     * Eine Alternative ist "Snake-Case" in C-ähnlichen Sprachen, dabei
     * werden Namensbestandteile voneinander durch Unterstriche getrennt
     * und alle Bestandteile ausser dem ersten bestehen nur aus Kleinbuchstaben.
     * Beispiel:
     * fuer "anzahl_duplikate" soll "anzahlDuplikate" geliefert werden.
     * fuer "_anzahl_ziffern" soll "_anzahlZiffern" geliefert werden.
     * fuer "Linked_list" soll "LinkedList" geliefert werden.
     * @param name ein zulaessiger Name in Snake-Case, garantiert nicht null
     * @return den Namen in Camel-Case 
     */
    public String snakeCaseToCamelCase(String name);

}