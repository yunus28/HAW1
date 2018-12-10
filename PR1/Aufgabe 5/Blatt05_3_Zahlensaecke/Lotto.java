
/**
 * Write a description of class Lotto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lotto
{
    private Zahlensack sack;

    /**
     * Constructor for objects of class Lotto
     */
    public Lotto()
    {
        sack =  new Naiv(49);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sechsaus49()
    {
        sack.leereSack();
        for (int i = 1; i<=6; i++)
        {
            System.out.println( sack.entferneZahl() +1);
        }
    }
}
