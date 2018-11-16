

class Motor
{
    private boolean _laeuft;
    
    public Motor(boolean anfangsAn)
    {
        _laeuft = anfangsAn;
    }
    
    public void umschalten()
    {
        _laeuft = !_laeuft;
    }
    
    public boolean laeuft()
    {
        return _laeuft;
    }
}
