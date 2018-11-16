 /**
 * Exemplare dieser Klasse veranlassen Turtles dazu,
 * Spuren auf einer Zeichenflaeche zu hinterlassen.
 *
 * @author Yunus und Finn
 * @version 2018
 */
class Dompteur
{
    /**
     * zeichnet das ideale n-eck
     * @param anzahl der ecken
     */
    public void zeichneNEck(int n)
    {
        zeichneNEck(n, 60, 200, 100, "blau");
    }
    
    /**
     * zeichnet ein n-eck an beliebiger stelle, einfarbig
     * @param n n, die Anzahl der Ecken
     * @param laenge laenge der einzelnen kanten
     * @param x xstartwert
     * @param y ystartwert
     * @param farbe die linienfarbe
     */
    public void zeichneNEck(int n, int laenge, int x, int y, String farbe) 
    {
        // new Turtle(2 * l + 70, 100);
        //Turtle t = guteXYTurtle(laenge);
        Turtle t = new Turtle (x, y);
        t.setzeFarbe(farbe);
        
        int drehung = 360 / n;
        for(int i = 0; i < n ;i++)
        {
            t.drehe(drehung);
            t.geheVor(laenge);
        }
    }
    
    /**
     * zeichnet viele kleiner werdende n-ecke
     * @n eckenanzahl
     * @ laenge laenge der kanten
     */
    public void zeichneNEcken(double n, double laenge) 
    {
        if(laenge>1)
        {
            //schwacher versuch zu zentrieren, ab 8-ecken klappts halbwegs..
            Turtle t = new Turtle(250 + (n/8*laenge), 250 - (n/8*laenge));
            int drehung = 360 /(int) n;
            for(int i = 0; i < n ;i++)
            {
                t.drehe(drehung);
                t.geheVor(laenge);
            }
            zeichneNEcken(n, laenge * 0.95);
        }
    }   
    
    
    /**
     * 'PR1' auf die Zeichenflaeche zeichnen.
     */
    public void start()
    {
        Turtle turtle = new Turtle(50, 100);

        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(180);
        
        // Ohne Spur zum naechsten Buchstaben bewegen:
        turtle.hinterlasseKeineSpur();
        turtle.geheZu(100, 100);

        // 'R' zeichnen:
        turtle.hinterlasseSpur();
        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(180);
        turtle.hinterlasseKeineSpur();
        turtle.geheVor(15);
        turtle.hinterlasseSpur();
        turtle.drehe(60);
        turtle.geheVor(35);

        // Ohne Spur zum naechsten Buchstaben bewegen:
        turtle.hinterlasseKeineSpur();
        turtle.geheZu(170, 100);

        // '1' zeichnen:
        turtle.drehe(-60);
        turtle.hinterlasseSpur();
        turtle.setzeFarbe("rot");
        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(-120);
        turtle.geheVor(20);
    }
}
