
/**
 * Exemplare dieser Klasse zeichnen eine einfache Zeichnung.
 * Um die Zeichnung auf dem Bildschirm anzuzeigen, muss die
 * zeichne-Operation an einem Exemplar aufgerufen werden.
 *
 * Diese Klasse ist als fruehes Java-Lehrbeispiel mit BlueJ gedacht.
 * 
 * @author  Petra Becker-Pechau, Axel Schmolitzky
 */
class Zeichner2
{
    
    /**
     * Zeichnet die Zeichnung.
     * @param s farbe der hauswand, bei ungultig schwarz
     */
    public void zeichne(){
        Quadrat wand; 
        Quadrat fenster;
        Dreieck dach;
        Kreis sonne;
        String strasse; /*die variable strasse wird als String 
        als zeichenkette deklariert, ohne wert, keine initialisierung
        
        formale Parameter sind Parameter denen noch kein Wert zugewiesen ist,
        sondern nur eine klasse. Aktuelle Parameter haben reelle aktuelle
        Werte bzw. einen Zustand.
        
        Die Signatur einer Methode gibt alle Infos, die zum Aufruf sind.
        ruckgabetyp und wieviele und welche formalen Parameter gebraucht werden
        */

        sonne = new Kreis();
        sonne.sichtbarMachen();
        sonne.farbeAendern("rot");
        sonne.horizontalBewegen(180);
        sonne.vertikalBewegen(-10);
        sonne.groesseAendern(60);
        
        zeichneHaus(100, 0, "blau", "gelb", "rot");
        zeichneHaus(300, 0, "gelb", "blau", "rot");
        zeichneHaus(0, 100, "blau", "rot", "gelb");
        
        
    }
    
    /*
     * zeichnet ein haus in immer derselben grosse
     * parameter selbsterklarend
     */
    private void zeichneHaus(int x, int y, String wandF, String fensterF, String dachF){
        Quadrat wand; 
        Quadrat fenster;
        Dreieck dach;

        wand = new Quadrat();
        wand.sichtbarMachen();
        wand.farbeAendern(wandF); //bearbeitet
        wand.horizontalBewegen(x);
        wand.vertikalBewegen(80+y);
        wand.groesseAendern(100);
        
        fenster = new Quadrat();
        fenster.sichtbarMachen();
        fenster.farbeAendern(fensterF);
        fenster.horizontalBewegen(20+x);
        fenster.vertikalBewegen(100+y);
        
        dach = new Dreieck();  
        dach.sichtbarMachen();
        dach.farbeAendern(dachF);
        dach.groesseAendern(50, 140);
        dach.horizontalBewegen(60+x);
        dach.vertikalBewegen(70+y);  
        
        
    }
    
    
}
