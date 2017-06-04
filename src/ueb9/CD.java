
/**
 * Diese Klasse stellt eine CD
 * 
 * @author Pascal Fickert & Luis Willnat
 * @version 1.0
 */
public class CD extends Artikel
{
    private String interpret;
    private String titel;
    private int    anzahlTitel;
    private String bezeichnung;
    /**
     * Konstruktor fuer Objekte der Klasse CD, mit allen Eigenschaften eines Artikels und zusaetzlich CD-spezifischen
     * @param artikelNr     Die Artikelnummer dieser CD
     * @param interpret     Der Sänger dieser CD
     * @param titel         Der Titel dieser CD
     * @param anzahlTitel   Die Anzahl der Titel auf dieser CD
     * @param bestand       Der Bestand dieser CD im Lager
     * @param preis         Der Preis dieser CD
     */
    public CD(int artikelNr, String bezeichnung, String interpret, String titel, int anzahlTitel, int bestand, double preis)
    {
        super(artikelNr, bezeichnung,bestand, preis); //als Artikel anlegen 
        checkAnzahlTitel(anzahlTitel);
        checkInterpret(interpret);
        checkTitel(titel);
        this.anzahlTitel = anzahlTitel;
        this.interpret = interpret;
        this.titel = titel;
    }

    public void checkInterpret(String interpret){
        if(interpret == null || interpret.trim().length() == 0){
            throw new InterpretNichtGueltigException();
        }
    }
    
    public void checkTitel(String titel){
        if(titel == null || titel.trim().length() == 0){
            throw new TitelNichtGueltigException();
        }
    }
    
    public void checkAnzahlTitel(int anzahlTitel){
        if(anzahlTitel < 0){
            throw new AnzahlTitelNichtGueltigException(anzahlTitel);
        }
    }
    
    /**
     * Eine get-Methode um die Beschreibung einer CD auszugeben
     * 
     * @return Bezeichung einer CD
     */
    public String getBeschreibung()
    {
        return "CD: " + interpret + " : " + titel;
    }
    
    /**
     * Eine to-String Methode um die CD auszugeben
     * @return alle eigenschaften der CD
     */
    public String toString(){
        return " CD " + super.toString() + "\n anzahl an Titeln: " + anzahlTitel;
    }
    
    /**
     * Eine get-Methode um die Anzahl an titels auszugeben
     * 
     * @return annzahlTitel
     */
    public int getAnzahlTitel()
    {
        return anzahlTitel;
    }
    
    /**
     * Eine set-Methode um die Anzahl an Titeln auf einer CD zu aendern
     * @param anzahlTitel neue Anzahl an Titeln
     */
    public void setAnzahlTitel(int anzahlTitel)
    {
        assert anzahlTitel > 0: "Die Anzahl muss positiv sein";
        this.anzahlTitel = anzahlTitel;
    }
}
