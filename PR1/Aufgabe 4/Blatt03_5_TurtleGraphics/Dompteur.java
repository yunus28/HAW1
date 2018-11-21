
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
     * @see zeichneBaum(int, double, double, double)
     */
    public void zeichneBaum(int aeste, int astlaenge)
    {
        zeichneBaum(aeste, astlaenge, 250, 500);
    }
    
    /**
     * zeichnet einen baum
     * param astlange, mindestlaenge 30
     */
    public void zeichneBaum(int aeste, double astlaenge, double x, double y)
    {
        if (astlaenge >= 30)
        {
            Turtle turtle = new Turtle(x, y);
            turtle.drehe(90d/aeste + 180);
            double winkel = 180d / aeste; //30 90 150 bei 3 asten
            turtle.setzeFarbe((int)astlaenge/5);
            // for (int i = 1; i<=aeste; i++)
            // {
                
                // turtle.geheVor(astlaenge);
                
                // x = turtle.gibX();
                // y = turtle.gibY();
                // zeichneBaum(aeste, astlaenge-10, x, y);
                
                // turtle.geheVor(-astlaenge);
                // turtle.drehe(winkel);
            // }
            hilfe(1, aeste, turtle, astlaenge, winkel);
        }
        
    }
    private void hilfe(int i, int aeste, Turtle turtle, double astlaenge, double winkel)
    {
        if(i<=aeste)
        {
            turtle.geheVor(astlaenge);
            double x = turtle.gibX();
            double y = turtle.gibY();
            zeichneBaum(aeste, astlaenge-10, x, y);
                            
            turtle.geheVor(-astlaenge);
            turtle.drehe(winkel);
            
            hilfe(++i, aeste, turtle, astlaenge, winkel);
        }
    }
    
    /**
     * zeichnet Kochkurve, wie in pdf dokumentiert
     * param detail detailstufe (>1)
     */
    public void zeichneKochKurve (int detail) 
    {
        double laenge = 150;
        Turtle turtle = new Turtle(30, 250);
        zeichneKochkurve2(turtle, laenge, detail);
    }
    /**
     * zeichnet kurve oder bei detail<=0 eine gerade linie
     */
    private void zeichneKochkurve2(Turtle turtle, double laenge, double detail)
    {
        
        if (detail > 0)
        {    
            zeichneKochkurve2(turtle, laenge/3, detail-1);
            turtle.drehe(-60); //bei 60grad ist hypo/cosAlpha = x+=laenge/2
            zeichneKochkurve2(turtle, laenge/3, detail-1);
            turtle.drehe(120); //gegenwinkel zu 60
            zeichneKochkurve2(turtle, laenge/3, detail-1);
            turtle.drehe(-60); 
            zeichneKochkurve2(turtle, laenge/3, detail-1);
        } else 
        {
            turtle.geheVor(3*laenge);
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
