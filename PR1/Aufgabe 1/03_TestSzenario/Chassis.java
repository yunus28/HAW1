

class Chassis
{
    private int _farbe;
    
    public Chassis (int f)
    {
        _farbe = f;
    }
    
    public void veraendernUm(int delta)
    {
        _farbe = _farbe + delta;
    }
    
    public int gibAktuelleFarbe()
    {
        return _farbe;
    }
}
