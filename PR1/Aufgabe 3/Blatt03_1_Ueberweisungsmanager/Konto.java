/**
 * Diese Klasse modelliert einfache Konten, die ihren Saldo in Euro
 * als ganze Zahl speichern. Auf einem Konto kann abgehoben und
 * eingezahlt werden. Ein Konto kann ueberzogen werden.
 * 
 * @author Axel Schmolitzky
 * @version 2018
 */
class Konto
{
    // der ganzzahlige Saldo
    private int _saldo;

    /**
     * Initialisiert ein neues Konto ohne Guthaben.
     */
    public Konto()
    {
        _saldo = 0;
    }

    /**
     * Initialisiert ein neues Konto mit einem Startguthaben.
     * 
     * @param startguthaben das gewuenschte Startguthaben in Euro
     */
    public Konto(int startguthaben)
    {
        _saldo = startguthaben;
    }

    /**
     * Zahlt einen Betrag auf diesem Konto ein.
     * 
     * @param betrag der einzuzahlende Betrag in Euro; darf nicht
     * negativ sein
     * @throws IllegalArgumentException
     */
    public void zahleEin(int betrag)
    {
        if (betrag >= 0)
        {
            _saldo = _saldo + betrag;
        }
        else
        {
            throw new IllegalArgumentException("Negativer Betrag");
        }
    }

    /**
     * Hebt einen Betrag von diesem Konto ab.
     * 
     * @param betrag der abzuhebende Betrag in Euro; darf nicht
     * negativ sein
     * @throws IllegalArgumentException
     */
    public void hebeAb(int betrag)
    {
        if (betrag >= 0)
        {
            _saldo = _saldo - betrag;
        }
        else
        {
            throw new IllegalArgumentException("Negativer Betrag");
        }
    }

    /**
     * Liefert den Saldo dieses Kontos.
     * 
     * @return den Saldo dieses Kontos in Euro
     */
    public int gibSaldo()
    {
        return _saldo;
    }
}
