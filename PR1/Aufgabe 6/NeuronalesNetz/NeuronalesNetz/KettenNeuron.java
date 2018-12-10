import java.util.*;
/**
 * Write a description of class KettenNeuron here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KettenNeuron implements Neuron
{
    private List<String> _kette;

    /**
     * Constructor for objects of class KettenNeuron
     */
    public KettenNeuron()
    {
        _kette = new ArrayList<String>();
    }
    
    public void eingangHinzufuegen(Neuron neuron)
    {
        _kette.add(neuron.getAusgangswert());
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getAusgangswert()    
    {
        String str = String.join(" ", _kette);
        _kette.add(String.join(" ", _kette));
        return str;
    }
}
