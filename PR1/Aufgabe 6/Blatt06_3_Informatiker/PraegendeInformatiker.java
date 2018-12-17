import java.util.Comparator;
/**
 * Eine Zusammenstellung von Informatikern, die die Informatik entscheidend gepraegt haben.
 * 
 * @author Fredrik Winkler
 * @version 2018
 */
class PraegendeInformatiker 
{
    /**
     * Keine Sorge, das musst Du noch nicht verstehen! Arrays kommen erst in Woche 11.
     */
    private final Person[] _urspruenglicheReihenfolge =
    {
        new Person("Ada", "Lovelace", 1815, false),
        new Person("Charles", "Babbage", 1791, true),
        new Person("Grace", "Hopper", 1906, false),
        new Person("Konrad", "Zuse", 1910, true),

        new Person("Alan", "Kay", 1940, true),
        new Person("Alonzo", "Church", 1903, true),
        new Person("Brian", "Kernighan", 1942, true),
        new Person("Dennis", "Ritchie", 1941, true),
        new Person("John", "Baccus", 1924, true),
        new Person("Kristen", "Nygaard", 1926, true),
        new Person("Niklaus", "Wirth", 1934, true),
        new Person("Ole-Johan", "Dahl", 1931, true),

        new Person("Ken", "Thompson", 1943, true),
        new Person("Linus", "Torvalds", 1969, true),
        new Person("Richard", "Stallman", 1953, true),

        new Person("Alan", "Turing", 1912, true),
        new Person("Claude", "Shannon", 1916, true),
        new Person("George", "Boole", 1815, true),
        new Person("Harry", "Nyquist", 1889, true),
        new Person("John", "Neumann von", 1903, true),
        new Person("Kurt", "Goedel", 1906, true),
        new Person("Richard", "Hamming", 1915, true),

        new Person("Christiane", "Floyd", 1943, false),
        new Person("Donald", "Knuth", 1938, true),
        new Person("Edsger", "Dijkstra", 1930, true),
        new Person("Herman", "Hollerith", 1860, true),
        new Person("Tony", "Hoare", 1934, true)
    };

    private Person[] _informatiker;
    
    /**
     * Schreibt die Informatiker auf die Konsole, geordnet nach einem Kriterium.
     */
    public void schreibeGeordnet(Vergleicher vergleicher)
    {
        _informatiker = _urspruenglicheReihenfolge.clone();
        insertionsort(vergleicher);
        System.out.println("========== " + vergleicher.getClass().toString().substring(6) + " ==========");
        for (Person p : _informatiker)
        {
            System.out.println(p);
        }
        System.out.println();
    }
    
    public void schreibeGeordnet(Comparator vergleicher)
    {
        _informatiker = _urspruenglicheReihenfolge.clone();
        insertionsort(vergleicher);
        System.out.println("========== " + vergleicher.getClass().toString().substring(6) + " ==========");
        for (Person p : _informatiker)
        {
            System.out.println(p);
        }
        System.out.println();
    }

    /**
     * Insertionsort ist ein einfacher, aber nicht besonders effizienter Sortieralgorithmus.
     * Bitte verwendet in der Praxis Collections.sort, statt eigene Sortierroutinen zu schreiben!
     * Aber vielleicht interessiert ja den einen oder anderen Studierenden,
     * wie man ein Sortierverfahren von Hand programmieren koennte :)
     */
    private void insertionsort(Vergleicher vergleicher)
    {
        for (int i = 1; i < _informatiker.length; ++i)
        {
            // Vorbedingung: Die Liste ist von 0 bis i-1 sortiert
            insert(i, vergleicher);
            // Nachbedingung: Die Liste ist von 0 bis i sortiert
        }
    }
    
    /**
     * Insertionsort ist ein einfacher, aber nicht besonders effizienter Sortieralgorithmus.
     * Bitte verwendet in der Praxis Collections.sort, statt eigene Sortierroutinen zu schreiben!
     * Aber vielleicht interessiert ja den einen oder anderen Studierenden,
     * wie man ein Sortierverfahren von Hand programmieren koennte :)
     */
    private void insertionsort(Comparator vergleicher)
    {
        for (int i = 1; i < _informatiker.length; ++i)
        {
            // Vorbedingung: Die Liste ist von 0 bis i-1 sortiert
            insert(i, vergleicher);
            // Nachbedingung: Die Liste ist von 0 bis i sortiert
        }
    }

    private void insert(int j, Vergleicher vergleicher)
    {
        Person einzufuegen = _informatiker[j];
        while ((j > 0) && vergleicher.vergleiche(einzufuegen, _informatiker[j - 1]) < 0)
        {
            _informatiker[j] = _informatiker[j - 1];
            --j;
        }
        _informatiker[j] = einzufuegen;
    }
    
    private void insert(int j, Comparator vergleicher)
    {
        Person einzufuegen = _informatiker[j];
        while ((j > 0) && vergleicher.compare(einzufuegen, _informatiker[j - 1]) < 0)
        {
            _informatiker[j] = _informatiker[j - 1];
            --j;
        }
        _informatiker[j] = einzufuegen;
    }
}
