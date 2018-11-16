
/**
 * Exemplare dieser Klasse zeichnen eine einfache Zeichnung.
 * Um die Zeichnung auf dem Bildschirm anzuzeigen, muss die
 * zeichne-Operation an einem Exemplar aufgerufen werden.
 *
 * Diese Klasse ist als fruehes Java-Lehrbeispiel mit BlueJ gedacht.
 * 
 * @author  Petra Becker-Pechau, Axel Schmolitzky
 */
class Zeichner
{
    Quadrat wand; 
    Quadrat fenster;
    Dreieck dach;
    Kreis sonne;
    String strasse; /*die variable strasse wird als String 
        bzw als zeichenkette deklariert, ohne wert, keine initialisierung
        
        formale Parameter sind Parameter denen noch kein Wert zugewiesen ist,
        sondern nur eine klasse. Aktuelle Parameter haben reelle aktuelle
        Werte bzw. einen Zustand.
        
        Die Signatur einer Methode gibt alle Infos, die zum Aufruf sind.
        ruckgabetyp und wieviele und welche formalen Parameter gebraucht werden
        */
    /**
     * Zeichnet die Zeichnung.
     * @param s farbe der hauswand, bei ungultig schwarz
     */
    public void zeichne(String s)
    {
        fenster = new Quadrat();
        fenster.sichtbarMachen();
        fenster.farbeAendern("blau");
        fenster.horizontalBewegen(20);
        fenster.vertikalBewegen(100);

        sonne = new Kreis();
        sonne.sichtbarMachen();
        sonne.farbeAendern("rot");
        sonne.horizontalBewegen(180);
        sonne.vertikalBewegen(-10);
        sonne.groesseAendern(60);
        
        zeichneDach();
        zeichneWand(s);
    }
    private void zeichneDach(){
        dach = new Dreieck();  
        dach.sichtbarMachen();
        dach.groesseAendern(50, 140);
        dach.horizontalBewegen(60);
        dach.vertikalBewegen(70);    
    }
    private void zeichneWand(String s){
        wand = new Quadrat();
        wand.sichtbarMachen();
        wand.farbeAendern("rot"); //bearbeitet
        wand.vertikalBewegen(80);
        wand.groesseAendern(100);
        wand.farbeAendern(s);
    }
    
    
}
