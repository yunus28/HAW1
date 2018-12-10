
/**
 * Write a description of class Signal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Signal implements Neuron
{
    private String _signalwert;

    /**
     * Constructor for objects of class Signal
     */
    public Signal(String signalwert)
    {
        // initialise instance variables
        _signalwert = signalwert;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getAusgangswert()
    {
        // put your code here
        return _signalwert;
    }
}
