
/**
 * Ein Interface mit mehreren Dienstleister-Operationen.
 * 
 * @author Axel Schmolitzky
 * @version WiSe 2015/2016
 */
interface ServiceMix
{
    /**
    * Gibt an, ob die Zeichenkette eine Ziffer enthaelt.
    * @param eine beliebige Zeichenkette, darf nicht null sein.
    * @return ob die Zeichenkette eine Ziffer enthaelt.
    */
   public boolean enthaeltZiffer(String s);
    
    /**
     * Liefert nur die Vokale der uebergebenen Zeichenkette. Fuer den Parameter "HAllo Welt!"      
     * liefert diese Methode beispielweise den String "Aoe".
     * @param eine beliebige Zeichenkette; darf nicht null sein und keine Umlaute enthalten. 
     * @return einen String mit den Vokalen des gegebenen Strings in der urspruenglichen Reihenfolge.
     */
    public String nurVokale(String wort);
    
    /**
     * Diese Methode liefert Informationen über die ersten 100 Zahlen (beginnend mit der 1)
     * nach dem "FizzBuzz-Prinzip": Für jede Zahl, die durch 3 teilbar ist, wird "Fizz"
     * geliefert, für jede Zahl, die durch 5 teilbar ist, wird "Buzz" geliefert und für jede 
     * Zahl, die durch 3 und durch 5 teilbar ist, wird "FizzBuzz" geliefert. Alle anderen
     * Zahlen werden einfach als String geliefert (also beispielsweise die 2 als "2").
     * @returns die ersten 100 Zahlen nach dem FizzBuzz-Prinzip, beginnend mit der 1. 
     */
    public String[] fizzBuzz();
    
    /**
     * Bekommt ein Array von Zahlen und liefert ein neues Arrays der gleichen Groesse,
     * in dem an der n-ten Position die Summe der erste n Zahlen des Parameter-Arrays steht.
     * Beispiel: für { 1, 2, 3 } liefert die Methode { 1, 3, 6 }, denn 1 ist die Summe der ersten
     * 1 Zahlen, 3 ist die Summe der ersten 2 Zahlen und 6 ist die Summe der ersten 3 Zahlen
     * aus dem Parameter-Array.
     * Das Parameter-Array darf nicht veraendert werden!
     * @param zahlen ein Array von int-Werten, darf nicht null sein
     * @return ein Array mit der gleichen Anzahl an Werten wie in zahlen
     */
    public int[] kummuliere(int[] zahlen);
    
}