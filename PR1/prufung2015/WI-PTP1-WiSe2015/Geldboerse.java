import java.util.List;
import java.util.Map;

/**
 * Ein Interface für einfache Geldboersen (im Deutschen auch Portmonee
 * oder Brieftasche genannt, im Englischen ein wallet). 
 * Eine Geldboerse kann Geld enthalten, hier zur Vereinfachung nur Euro-Scheine.
 * Scheine koennen eingesteckt und entnommen werden.
 * 
 * Implementierende Klassen muessen einen parameterlosen Konstruktor
 * anbieten, der eine Geldboerse mit 0 Euro initialisiert.
 * 
 * @author Axel Schmolitzky
 * @version WiSe 2015/2016
 */
interface Geldboerse
{
    /**
     * Scheine in diese Geldboerse stecken.
     * Ein Aufruf mit negativer Anzahl oder 0 fuehrt zu einer IllegalArgumentException.
     * @param anzahl die Anzahl der Scheine; muss > 0 sein.
     * @param scheintyp der Typ des Euroscheins
     */
    void scheineEinstecken(int anzahl, Euroschein scheintyp);
    
    /**
     * Scheine in diese Geldboerse stecken.
     * @param buendel eine Liste von Scheinen
     */
    void scheineEinstecken(List<Euroschein> buendel);
    
    /**
     * Scheine eines Typs aus dieser Geldboerse entnehmen.
     * Ein Aufruf mit negativer Anzahl oder 0 fuehrt zu einer IllegalArgumentException.
     * Ein Aufruf mit mehr Scheinen als in der Geldboerse vorhanden fuehrt zu einer
     * IllegalStateException.
     * @param anzahl die Anzahl der Scheine; muss > 0 sein.
     * @param scheintyp der Typ des Euroscheins
     */
    void scheineEntnehmen(int anzahl, Euroschein scheintyp);
        
    /**
     * Ein Buendel Scheine aus dieser Geldboerse entnehmen. Der Parameter beschreibt
     * fuer jeden Key in der Map (einen Scheintyp) die Anzahl der zu entnehmenden 
     * Scheine dieses Typs; diese muss jeweils > 0 sein.
     * Ein Aufruf mit negativer Anzahl oder 0 fuehrt zu einer IllegalArgumentException.
     * Ein Aufruf mit mehr Scheinen als vom jeweiligen Typ in der Geldboerse vorhanden
     * fuehrt zu einer IllegalStateException.
     * @param buendel Eine Map vom Scheintyp auf die jeweilige Anzahl; darf nicht null sein.
     */
    void scheineEntnehmen(Map<Euroschein,Integer> buendel);

    /**
     * Liefert die Info, wie viel Geld gerade in dieser Geldboerse ist.
     * @return das enthaltene Geld in Euro.
     */
    int enthaltenesGeld();
    
    /**
     * Die Anzahl aller Scheine in dieser Geldboerse.
     */
    int anzahlScheine();

    /**
     * Die Anzahl der Scheine des genannten Scheintyps in dieser Geldboerse.
     * @param scheintyp Scheintyp, dessen Anzahl geliefert werden soll
     */
    int anzahlScheine(Euroschein scheintyp);
        
    /**
     * Liefert die Information, ob ein bestimmter Betrag passend in dieser
     * Geldboerse ist, also ohne Wechselgeld bezahlt werden kann.
     * Beispiel: mit zwei 20-Euro-Scheinen können 20 und 40 Euro passend bezahlt
     * werden, aber beispielsweise nicht 30 oder 10 Euro.
     * @param euroBetrag der gewuenschte Betrag in Euro; darf nicht kleiner 0 sein.
     * @return true, wenn passend gezahlt werden kann, false sonst.
     */
    boolean geldPassendVorhanden(int euroBetrag);
    
}