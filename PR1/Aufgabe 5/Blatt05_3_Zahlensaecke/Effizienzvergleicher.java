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
        long start = System.nanoTime();// Speichere die aktuelle Zeit als Startzeit
 
        for (int i = 0; i<1_000_000; i++) {
            sack.entferneZahl();// Rufe 1 Mio. Mal "entferneZahl" auf
        }
        long stop1 = System.nanoTime();
        // Speichere die aktuelle Zeit als Stoppzeit

        long diff = stop1-start;
        // Bilde die Differenz aus Stoppzeit und Startzeit
        
        double diffd = diff / 1_000_000;
        // Teile die Differenz durch 1_000_000, um von ns nach ms umzurechnen

        System.out.print(sack); // Beschreibung des Zahlensacks ausgeben
        System.out.println(": " + diffd + "ms"); // gefolgt von einem Doppelpunkt
        // Gib das Ergebnis auf der Konsole aus
        
    }
}
