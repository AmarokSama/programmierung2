
/**
 * Diese Klasse stellt einen Artikel mit einigen eigenschaften wie seine Nummer, Bezeichnung und Bestand dar*
 * 
 * @author Luis & Pascal 
 * @version 2
 */
public class Artikel
{
    // die gebrauchten variabeln initialisieren (ohne wertangabe)
    private int    artikelnr;
    public String artikelbzg;
    public  int    bestand;
    public double         preis;
    /**
     * Der Konstruktor mit dem der Artikel erstellt wird
     * @param artikelnr  die artiekelnummer muss 4-stellig sein
     * @param artikelbzg  der Artikel muss eine Bezeichnung haben
     * @param bestand   muss groesser gleich null sein
     * @param preis  muss positiv sein
     */
    
    public Artikel(int artikelnr, String artikelbzg, int bestand, double preis) 
    {
        checkArtikelNummer(artikelnr); 
        checkArtikelBzg(artikelbzg);
        checkBestand(bestand);
        checkPreis(preis);
        this.artikelnr = artikelnr;
        this.artikelbzg = artikelbzg;
        this.bestand = bestand;
        this.preis = preis;
    }

      public void checkArtikelNummer(int artikelnr){
        if(artikelnr < 1000 || artikelnr > 9999){
            throw new ArtikelNummerNichtGueltigException(artikelnr);
        }
    }
    
    public void checkArtikelBzg(String artikelbzg){
        if(artikelbzg == null || artikelbzg.trim().length() == 0){
            throw new ArtikelBzgNichtGueltigException();
        }
    }
    
    public void checkBestand(int bestand){
        if(bestand < 0){
            throw new BestandNichtGueltigException(bestand);
        }
    }
    
    public void checkPreis(double preis){
        if(preis < 0){
            throw new PreisNichtGueltigException(preis);
        }
    }
    
    public Artikel(int artikelnr, String artikelbzg, double preis) //fur einen neuen Artikel
    {
        this(artikelnr, artikelbzg, 0, preis);
    }
    
    /**
     * Der Bestand wird durch Zugang erhöht
     * @param anzahl muss eine positive Zahl sein
     */
    public void zugang(int anzahl)
    {
        assert anzahl > 0 : "Keine negativen einzahlungen";
        bestand += anzahl;
    }
    
    /**
     * Der Bestand wird durch Abgang gemindert
     * @param anzahl muss kleiner als der Bestand sein
     */
    public void abgang(int anzahl)
    {
        assert anzahl > 0 : "die Summe die abgezogen wird muss positiv sein"; 
        assert bestand >= anzahl: "Es fehlen " + (anzahl - bestand) + " um diese Aktion zu vollführen";
        bestand -= anzahl;
    }
    
    /**
     * Den aktuellen Artikel in Worten wiedergeben
     * @return Artikel mit all seinen Eigenschaften
     */
    public String toString()
    {
        return "\nArtikelnummer : " + artikelnr + "\nBezeichnung: "
        + artikelbzg + "\nBestand: " + bestand + "\nPreis: " + preis + "€";
    }
    
    /**
     * Eine set-Methode um die Bezeichnung eines Artikels zu aendern
     * @param artikelbzg die Bezeichnng die veraendert wird
     */
    public void setArtikelbzg(String artikelbzg)
    {
        assert artikelbzg != null && artikelbzg.trim().length() > 0 
                : "Artikelbezeichnung darf nicht leer sein";
        this.artikelbzg = artikelbzg;
    }
    
    /**
     * Eine set-Methode um den Preis eines Artikels zu aendern
     * @param preis der Preis wird veraendert
     */
    public void setPreis(double preis)
    {
        assert preis > 0: "Negativer Preis unmoeglich";
        this.preis = preis;
    }
    
     /**
     * Eine get-Methode um die Artikel Nummer auszugeben
     * 
     * @return Artikelnummer
     */
    public int getArtikelnr()
    {
        return artikelnr;
    }
    
     /**
     * Eine get-Methode um die Beschreibung eines Artikels auszugeben
     * 
     * @return artikelbzg Bezeichung eines Artikels
     */
    public String getArtikelbzg()
    {
        return artikelbzg;
    }
    
     /**
     * Eine get-Methode um den Bestand eines Artikels auszugeben
     * 
     * @return bestand eines Artikels
     */
    public int getBestand()
    {
        return bestand;
    }
    
     /**
     * Eine get-Methode um den Preis eines Artikels auszugeben
     * 
     * @return preis eines Artikels
     */
    public double getPreis()
    {
       return preis;
    } 
    
    /**
     * Eine get-Methode um die Beschreibung eines Artikels auszugeben
     * 
     * @return Bezeichung eines Artikels
     */
    public String getBeschreibung()
    {
        return "Artikel: " + artikelbzg;
    }
    
    /**
     * Eine methode um die richtighkeit einer Kondition zu ueberprufen und im gegennteiligen Fall 
     * eine exception auswerfen
     */
    public static void ueberpruefen(boolean kondition, String nachricht)
    {
        if (!kondition)
        {
            throw new RuntimeException(nachricht);
        }
    }
}