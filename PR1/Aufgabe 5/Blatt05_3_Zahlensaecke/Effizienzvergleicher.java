/**
 * Diese Klasse vergleicht die Effizienz verschiedener Implementationen von Zahlensack.
 *
 * Implementiert in der Methode vermesse(Zahlensack) den fehlenden Code!
 *
 * @author Fredrik Winkler, Christian M. Spaeh
 * @version 2018
 */
class Effizienzvergleicher
{
    /**
     * Vergleicht die Effizienz verschiedener Implementationen von Zahlensack.
     * Alle Zahlensaecke werden mit der gleichen Groesse erzeugt.
     * 
     * @param groesse die Groesse der Zahlensaecke
     */
    public void vergleiche(int groesse)
    {
        if (groesse < 1)
        {
            throw new IllegalArgumentException("groesse < 1");
        }
        
        Zahlensack zs = new Naiv(groesse);
        vermesse(zs);
        
        zs = new Permutation(groesse);
        vermesse(zs);
        
        zs = new Auswahl(groesse);
        vermesse(zs);
    }

    /**
     * Misst die Zeit, die fuer das Entfernen von sehr vielen Zahlen aus dem
     * Zahlensack benoetigt wird. Das Ergebnis wird auf der Konsole ausgegeben.
     * 
     * @param sack der zu vermessende Zahlensack
     */
    private void vermesse(Zahlensack sack)
    {
        // Speichere die aktuelle Zeit als Startzeit
 
        // Rufe 1 Mio. Mal "entferneZahl" auf

        // Speichere die aktuelle Zeit als Stoppzeit

        // Bilde die Differenz aus Stoppzeit und Startzeit
        
        // Teile die Differenz durch 1_000_000, um von ns nach ms umzurechnen

        System.out.print(sack); // Beschreibung des Zahlensacks ausgeben
        System.out.print(": "); // gefolgt von einem Doppelpunkt
        // Gib das Ergebnis auf der Konsole aus
        
    }
}
