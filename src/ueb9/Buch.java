
/**
 * Diese Klasse stellt ein Buch dar
 * 
 * @author Pascal Fickert & Luis Willnat 
 * @version 1.0
 */
public class Buch extends Artikel
{
    private String autor;
    private String titel;
    private String verlag;
    private String bezeichnung;
    /**
     * Konstruktor der Klasse Buch mit allen Eigenschaften eines Artikels und zusaetzlich Buch-spezifischen
     * @param artikelNr ist die Nummer des Buches
     * @param autor     ist der Autor des Buches
     * @param titel     ist der Titel des Buches
     * @param verlag    ist der Verlag des Buches
     * @param bestand   ist die Anzahl der Bücher
     * @param preis     ist der Preis von ein Buch
     */
    public Buch(int artikelNr, String bezeichnung, String autor, String titel, String verlag, int bestand, double preis)
    {
        super(artikelNr, bezeichnung, bestand, preis);
        checkAutor(autor);
        checkTitel(titel);
        checkVerlag(verlag);
        this.autor = autor;
        this.titel = titel;
        this.verlag = verlag;
    }

    public void checkAutor(String autor){
        if(autor == null || autor.trim().length() == 0){
            throw new AutorNichtGueltigException();
        }
    }
    
    public void checkTitel(String titel){
        if(titel == null || titel.trim().length() == 0){
            throw new TitelNichtGueltigException();
        }
    }
    
    public void checkVerlag(String verlag){
        if(verlag == null || verlag.trim().length() == 0){
            throw new VerlagNichtGueltigException();
        }
    }
    
    /**
     * Eine get-Methode um die Beschreibung eines Buches auszugeben
     * 
     * @return Beschreibung des Buches 
     */
    public String getBeschreibung()
    {
        return "Buch: " + autor + " : " + titel;
    }
    
    /**
     * Eine getMethode um den Verlag auszugeben
     * @return verlag
     */
    public String getVerlag()
    {
        return verlag;
    }
    
    /**
     * Eine set Methode um den Nmane des Verlags zu aendern
     * @param verlag Neuer Name des Verlags
     */
    public void setVerlag(String verlag)
    {
        assert !verlag.isEmpty() : "Verlag darf nicht leer sein";
        this.verlag = verlag;
    }
    
    /**
     * Eine toString methode um ein Buch auszugeben
     * @return alle eigenschaften eines Buches
     */
    public String toString(){
        return super.toString() + "Verlag: " + verlag;
    }
}
