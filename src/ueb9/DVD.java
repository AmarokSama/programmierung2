
/**
 * Diese Klasse stellt einen Artikel dar, genauer gesagt eine CD
 * 
 * @author Luis Willnat & Pascal Fickert 
 * @version 1.0
 */
public class DVD extends Artikel
{
    private String titel;
    private int    dauer;
    private int    jahr;

    private static final String MSG_FALSCHES_JAHR = "Das Jahr musss zwischen 1949 und 2017 sein \n";
    private static final int    MIN_JAHR          = 1949;
    private static final int    MAX_JAHR          = 2017;
    /**
     * Konstruktor der Klasse DVD mit allen Eigenschaften eines Artikels und zusaetzlich DVD-spezifischen
     *@param artikelNr Die artikelnummer dieser DVD
     *@param titel der Titel dieser DVD
     *@param dauer die Dauer des Films
     *@param jahr das ERscheinungsjahr des Films
     *@param bestand Die anzahl der DVDs die auf Lager sind
     *@param preis Der preis der DVD
     */
    public DVD(int artikelNr, String titel, int dauer, int jahr, int bestand, double preis)
    {
        super(artikelNr, titel, bestand, preis);
        checkDauer(dauer);
        checkJahr(jahr);
        this.dauer = dauer;
        this.jahr = jahr;
    }
    
    public void checkDauer(int dauer){
        if(dauer <= 0){
            throw new DauerNichtGueltigException(dauer);
        }
    }
    
    public void checkJahr(int jahr){
        if(jahr < MIN_JAHR || jahr > MAX_JAHR){
            throw new JahrNichtGueltigException(jahr);
        }
    }
    
    /**
     * Eine get-Methode um die Beschreibung einer DVD auszugeben
     * 
     * @return  die Bezeichnung der DVD
     */
    public String getBeschreibung()
    {
        return "DVD: " + super.artikelbzg;
    }
    
     /**
     * Eine get-Methode um die Beschreibung einer DVD auszugeben
     * 
     * @return  das Erscheinungsjahr dieser DVD
     */
    public int getJahr()
    {
        return jahr;
    }

    /**
     * Eine set-Methode um das Erscheinungsjahr zu veraendern
     * @param neues Erscheinungsjahhr, zwischen 1949 und 2017
     */
    public void setJahr(int jahr)
    {
        ueberpruefen(jahr > MIN_JAHR && jahr < MAX_JAHR, MSG_FALSCHES_JAHR);
        this.jahr = jahr;
    }
    
     /**
     * Eine get-Methode um die Dauer einer DVD auszugeben
     * 
     * @return  die Dauer dieser DVD
     */
    public int getDauer()
    {
        return dauer;
    }
    
    /**
     * Eine set-Methode um die Dauer des Filmes zu aendern
     * @param dauer neue Dauer des Filmes
     */
    public void setDauer(int dauer)
    {
        assert dauer > 0: "Die Dauer muss mindestens 1 Minute sein";
        this.dauer = dauer;
    }
    
    /**
     * Eine toString Methode um die DVD darzustellen
     * @return alle Eigenschaften der DVD
     */
    public String toString(){
        return super.toString() + "Dauer des Films: " + dauer + " Erscheinungsjahr: " + jahr;
    }

}
