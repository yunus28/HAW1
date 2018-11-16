
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
 
    /**
     * Zeichne die Zeichnung.
     */
    public void zeichne()
    {
        Quadrat wand; 
        Quadrat fenster;
        Dreieck dach;
        Kreis sonne;
        String strasse; //die variable strasse wird als String 
        // bzw als zeichenkette deklariert, ohne wert, keine initialisierung

        wand = new Quadrat();
        wand.sichtbarMachen();
        wand.farbeAendern("rot"); //bearbeitet
        wand.vertikalBewegen(80);
        wand.groesseAendern(100);
        
        fenster = new Quadrat();
        fenster.sichtbarMachen();
        fenster.farbeAendern("blau");
        fenster.horizontalBewegen(20);
        fenster.vertikalBewegen(100);

        dach = new Dreieck();  
        dach.sichtbarMachen();
        dach.groesseAendern(50, 140);
        dach.horizontalBewegen(60);
        dach.vertikalBewegen(70);

        sonne = new Kreis();
        sonne.sichtbarMachen();
        sonne.farbeAendern("rot");
        sonne.horizontalBewegen(180);
        sonne.vertikalBewegen(-10);
        sonne.groesseAendern(60);
    }
}
