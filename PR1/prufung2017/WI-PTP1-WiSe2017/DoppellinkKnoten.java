/**
 * Diese Klasse modelliert doppelt verkettbare Knoten, die jeweils ein Element
 * vom Typ String enthalten koennen.
 * 
 * @author Axel Schmolitzky
 * @version SoSe 2014
 */
class DoppellinkKnoten
{ 
    // Der vorherige Knoten
    private DoppellinkKnoten _vorgaenger;

    // Der nachfolgende Knoten
    private DoppellinkKnoten _nachfolger;

    // Das Element des Knotens, ein Titel
    private String _wort;

    /**
     * Erzeuge einen neuen Knoten ohne Element und Verkettungsinformationen.
     */
    public DoppellinkKnoten()
    {
    }

    /**
     * Erzeuge einen neuen Knoten und setze gleich Vorgaenger, Nachfolger und
     * Element.
     * 
     * @param element
     *            Das Element, das der Knoten tragen soll
     * @param vorgaenger
     *            Der vorherige Knoten
     * @param nachfolger
     *            Der naechste Knoten
     */
    public DoppellinkKnoten(String wort, DoppellinkKnoten vorgaenger,
            DoppellinkKnoten nachfolger)
    {
        _wort = wort;
        _vorgaenger = vorgaenger;
        _nachfolger = nachfolger;
    }

    /**
     * Gib den nachfolgenden Knoten zurueck.
     * 
     * @return den Nachfolgerknoten
     */
    public DoppellinkKnoten gibNachfolger()
    {
        return _nachfolger;
    }

    /**
     * Setze den nachfolgenden Knoten.
     * 
     * @param nachfolger
     *            der Nachfolgerknoten.
     */
    public void setzeNachfolger(DoppellinkKnoten nachfolger)
    {
        _nachfolger = nachfolger;
    }

    /**
     * Gib den vorherigen Knoten zurueck.
     * 
     * @return den Vorgaenger dieses Knotens
     */
    public DoppellinkKnoten gibVorgaenger()
    {
        return _vorgaenger;
    }

    /**
     * Setze den Vorgaenger dieses Knotens.
     * 
     * @param vorgaenger
     *            der Vorgaengerknoten.
     */
    public void setzeVorgaenger(DoppellinkKnoten vorgaenger)
    {
        _vorgaenger = vorgaenger;
    }

    /**
     * Gib das (Daten-)Element dieses Knotens.
     * 
     * @return den gespeicherten Titel dieses Knotens.
     */
    public String gibWort()
    {
        return _wort;
    }

    /**
     * Setze das (Daten-)Element dieses Knotens.
     * 
     * @param element
     *            Ein Titel.
     */
    public void setzeWort(String wort)
    {
        _wort = wort;
    }
    
    /**
     * Diese Methode faengt einen typischen Fehler ab, 
     * der hin und wieder gemacht wird.
     */
    public boolean equals(String wort)
    {
        throw new IllegalArgumentException("Fehler: DoppellinkKnoten mit Strings zu vergleichen ist nicht sinnvoll!");
    }
}
