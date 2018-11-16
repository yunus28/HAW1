
class Fahrzeug
{
    private Chassis _c;
    private Motor _m;

    /**
     * Initialisiert ein neues Fahrzeug mit einem 
     * Chassis und einem Motor.
     */
    public Fahrzeug(Chassis c, Motor m)
    {
        _c = c;
        _m = m;
    }
        
    public void naechsteFarbe()
    {
        _c.veraendernUm(1);
    }
    
    public void zuendungstasteDruecken()
    {
        _m.umschalten();
    }
    
    public int gibFarbe()
    {
        return _c.gibAktuelleFarbe();
    }
    
    public boolean laeuft()
    {
        return _m.laeuft();
    }

}
