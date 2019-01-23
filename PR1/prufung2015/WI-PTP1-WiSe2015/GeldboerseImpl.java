import java.util.*;
/**
 * Write a description of class GeldboerseImpl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GeldboerseImpl implements Geldboerse
{
    private HashMap<Euroschein, Integer> _tasche;
    /**
     * Constructor for objects of class GeldboerseImpl
     */
    public GeldboerseImpl()
    {
        _tasche = new HashMap<Euroschein, Integer>();
        _tasche.put(Euroschein.E5, 0);
        _tasche.put(Euroschein.E10, 0);
        _tasche.put(Euroschein.E20, 0);
        _tasche.put(Euroschein.E50, 0);
        _tasche.put(Euroschein.E100, 0);
        _tasche.put(Euroschein.E200, 0);
    
    }

    /**
     * Scheine in diese Geldboerse stecken.
     * Ein Aufruf mit negativer Anzahl oder 0 fuehrt zu einer IllegalArgumentException.
     * @param anzahl die Anzahl der Scheine; muss > 0 sein.
     * @param scheintyp der Typ des Euroscheins
     */
    public void scheineEinstecken(int anzahl, Euroschein scheintyp)
    {
        _tasche.put(scheintyp, anzahl + _tasche.get(scheintyp));
    }
    
    /**
     * Scheine in diese Geldboerse stecken.
     * @param buendel eine Liste von Scheinen
     */
    public void scheineEinstecken(List<Euroschein> buendel)
    {
       for(Euroschein schein : buendel)
       {
           scheineEinstecken(1, schein);
       }
    }
    
    /**
     * Scheine eines Typs aus dieser Geldboerse entnehmen.
     * Ein Aufruf mit negativer Anzahl oder 0 fuehrt zu einer IllegalArgumentException.
     * Ein Aufruf mit mehr Scheinen als in der Geldboerse vorhanden fuehrt zu einer
     * IllegalStateException.
     * @param anzahl die Anzahl der Scheine; muss > 0 sein.
     * @param scheintyp der Typ des Euroscheins
     */
    public void scheineEntnehmen(int anzahl, Euroschein scheintyp)
    {
        if(anzahl<=0)
        {
            throw new IllegalArgumentException();
        } else if (anzahl>_tasche.get(scheintyp))
        {
            throw new IllegalStateException();
        }
        scheineEinstecken( -anzahl, scheintyp);
    }
        
    /**
     * Ein Buendel Scheine aus dieser Geldboerse entnehmen. Der Parameter beschreibt
     * fuer jeden Key in der Map (einen Scheintyp) die Anzahl der zu entnehmenden 
     * Scheine dieses Typs; diese muss jeweils > 0 sein.
     * Ein Aufruf mit negativer Anzahl oder 0 fuehrt zu einer IllegalArgumentException.
     * Ein Aufruf mit mehr Scheinen als vom jeweiligen Typ in der Geldboerse vorhanden
     * fuehrt zu einer IllegalStateException.
     * @param buendel Eine Map vom Scheintyp auf die jeweilige Anzahl; darf nicht null sein.
     */
    public void scheineEntnehmen(Map<Euroschein,Integer> buendel)
    {
       for(Euroschein schein : buendel.keySet())
       {
           scheineEntnehmen(buendel.get(schein), schein);
       }
    }

    /**
     * Liefert die Info, wie viel Geld gerade in dieser Geldboerse ist.
     * @return das enthaltene Geld in Euro.
     */
    public int enthaltenesGeld()
    {
        int geld = 0;
       for(Euroschein schein : _tasche.keySet())
       {
           int a = _tasche.get(schein);
           geld += a*schein.wert();
       }
        return geld;
    }
    
    /**
     * Die Anzahl aller Scheine in dieser Geldboerse.
     */
    public int anzahlScheine()
    {
       int a = 0;
       for(Euroschein schein : _tasche.keySet())
       {
           a += _tasche.get(schein);
       }
        return a;
    }

    /**
     * Die Anzahl der Scheine des genannten Scheintyps in dieser Geldboerse.
     * @param scheintyp Scheintyp, dessen Anzahl geliefert werden soll
     */
    public int anzahlScheine(Euroschein scheintyp)
    {
        return _tasche.get(scheintyp);
    }
        
    /**
     * Liefert die Information, ob ein bestimmter Betrag passend in dieser
     * Geldboerse ist, also ohne Wechselgeld bezahlt werden kann.
     * Beispiel: mit zwei 20-Euro-Scheinen können 20 und 40 Euro passend bezahlt
     * werden, aber beispielsweise nicht 30 oder 10 Euro.
     * @param euroBetrag der gewuenschte Betrag in Euro; darf nicht kleiner 0 sein.
     * @return true, wenn passend gezahlt werden kann, false sonst.
     */
    public boolean geldPassendVorhanden(int euroBetrag)
    {
        System.out.println("\n" + euroBetrag);
        Euroschein[] scheinarray = new Euroschein[6];        
        scheinarray[5] = Euroschein.E5;
        scheinarray[4] = Euroschein.E10;
        scheinarray[3] = Euroschein.E20;
        scheinarray[2] = Euroschein.E50;
        scheinarray[1] = Euroschein.E100;
        scheinarray[0] = Euroschein.E200;
        
        System.out.println(_tasche + "<--vorm bezahlen"); 
        for(int a = 0; a< scheinarray.length; ++a)
        {
            Euroschein schein = scheinarray[a];
            
            if(schein.wert() <= euroBetrag)
            {
               int tmp = _tasche.get(schein);
               for (int i = 1; i<=tmp ; ++i)
               {
                   if(schein.wert() <= euroBetrag)
                   {
                       System.out.println("diesen schein zahlen: " + schein.wert());
                       euroBetrag = euroBetrag - schein.wert();
                   }
                }
            }
        }
        System.out.println("danach: -->" + _tasche);
        return (euroBetrag == 0);
    }
}
