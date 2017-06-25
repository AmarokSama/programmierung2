import java.util.*;
import java.util.function.*;
/**
 * Ein Lager in dem die Artikel gelagert, geloescht und bearbeitet  werden
 * 
 * @author Pascal Fickert & LUis Willnat
 * @version 1.0
 */
public class Lager
{
    private String      lagerName;
    private Artikel[]   artikelTab;
    private int         anzahlArtikel;
    private double      wert;
    private double      gesamtWert;
    private double      preis;
    private int         bestand;
    private String      bzg;
    private int         nummer;
    

    private static final String MSG_ARTIKEL_NICHT_VORHANDEN =
        "Artikel nicht vorhanden!";
    private static final String MSG_ARTIKEL_ANLEGEN         =
        "Artikel konnte nicht angelegt werden. \n"+
        "Sie muessen ein Artikel loeschen !";
    private static final String MSG_ARTIKEL_VORHANDEN       =
        "dieser Artikel existiert bereits!";
    private static final String MSG_ARTIKEL_VERSCHIEDEN     =
        "Einen Artikel kann es nicht 2 mal geben!";
    private static final String MSG_MAX_ANZ_ARTIKEL         =
        "Die Zahl der Artikel muss > 0 sein!";
    private static final String MSG_NAME                    = 
        "Name darf nicht leer sein";

    private static final int MAX = 25;
    private static final String nameDefault= "lager";
    /**
     * Standardkonstruktor um ein Lager zu erstellen
     * @param lagerName    der Name des Lagers
     * @param maxAnzahlArtikel    Anzahl der Artikel die das Lager enthalten kann, muss groesser als null sein
     */
    public Lager(String lagerName,int maxAnzahlArtikel)
    {
        ueberpruefen(maxAnzahlArtikel > 0, MSG_MAX_ANZ_ARTIKEL);
        ueberpruefen(lagerName != null && lagerName.trim().length() > 0, MSG_NAME);
        this.lagerName = lagerName;
        artikelTab = new Artikel[maxAnzahlArtikel] ;
        anzahlArtikel = 0;
    }

    /**
     * Konstruktor mir vorgegebener Maximalgroesse und Namen
     */
    public Lager()
    {
        this.lagerName = nameDefault;
        artikelTab = new Artikel[MAX] ;
        anzahlArtikel = 0;
    }

    /**
     * Methode um einen Artikel aus dem lager zu loeschen
     * @param artikelNummer  es wird ueberpeuft ob der Artikel vorhanden ist
     */
    public void artikelEntfernen(int artikelNummer)
    {
        int i = findeArtikel(artikelNummer);
        ueberpruefen(i >= 0, MSG_ARTIKEL_NICHT_VORHANDEN );

        if (i >= 0) {
            artikelTab[i] = artikelTab[anzahlArtikel - 1];
            artikelTab[anzahlArtikel - 1] = null;
            anzahlArtikel--;            
        }
    }

    /**
     * Den Bestand eines Artikels im Lager erhohen
     * @param artikelNummer  ueberpruefen ob der Artikel vorhanden ist
     * @param menge  die Anzahl an Artikeln die dem Lager hinzugefuegt werden
       */
    public void lagerZugang(int artikelNummer, int menge){
        int i = findeArtikel(artikelNummer);
        ueberpruefen(i >= 0, MSG_ARTIKEL_NICHT_VORHANDEN );
        artikelTab[i].zugang(menge);
    }

    /**
     * Den Bestand eines Artikels im Lager senken
     * @param artikelNummer  ueberpruefen ob der Artikel vorhanden ist
     * @param menge  die Menge die abgezogen wird
     */
    public void lagerAbgang(int artikelNummer, int menge){
        int i = findeArtikel(artikelNummer);
        ueberpruefen(i >= 0, MSG_ARTIKEL_NICHT_VORHANDEN );
        artikelTab[i].abgang(menge);
    }

    /**
     * @param prozente   Alle preise um einen Prozentsatz erhoehen
     */
    public void preisVeraenderungPlus(double prozente)
    {
        for(int i = 0; i < anzahlArtikel; i++)
        {
            artikelTab[i].preis += artikelTab[i].preis * prozente / 100;
        }
    }
    
    public void applyToArticles(String element, String zeichen, double aenderung){
        for (int i = 0; i < anzahlArtikel; i++){
            artikelTab[i].toString();
            if (zeichen == ("+")){
                if(element == "preis"){
                    artikelTab[i].preis += aenderung;
                }
                else if (element == "bestand"){
                    artikelTab[i].bestand += aenderung;
                }
            }
            else if (zeichen == ("-")){
                if(element == "preis"){
                    artikelTab[i].preis -= aenderung; 
                }
                else if (element == "bestand"){
                    artikelTab[i].bestand -= aenderung;
                }
            } 
            else if (zeichen == ("*")){
                if(element == "preis"){
                    artikelTab[i].preis *= aenderung;
                }
                else if (element == "bestand"){
                    artikelTab[i].bestand *= aenderung;
                }
            }
            if (zeichen == ("/")){
                if(element == "preis"){
                    artikelTab[i].preis /= aenderung;
                }
                else if (element == "bestand"){
                    artikelTab[i].bestand /= aenderung;
                }
            }
        }
    }

    /**
     * @param prozente  Alle preise um einen Prozentsatz senken
     */
    public void preisVeraenderungMinus(double prozente)
    {
        for(int i = 0; i < anzahlArtikel; i++)
        {
            artikelTab[i].preis -= artikelTab[i].preis * prozente / 100;
        }
    }

    /**
     * Diese Funktion dient dazu festzustelllen, ob eine Artikelnummer vorhanden ist
     * @param artikelNummer
     * @return index des Artikels oder -1 falls nicht vorhanden
     */
    private int findeArtikel(int artikelNummer)
    {
        for(int i = 0; i < anzahlArtikel; i++)
        {
            if (artikelTab[i].getArtikelnr() == artikelNummer)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Eine toString Methode um das Lager schriflich wiederzugeben
     * @return Inhalt des Lagers
     */
    public String toString(){
        String s = "\nLager : " + lagerName + "\n\n";
        for (int i = 0; i< anzahlArtikel; i++){
            s += (i+1) + ": " + artikelTab[i] + '\n';
        }
        return s;
    }

    /**
     * Methode um einen Artikel anzulegen
     * @param beliebigArtikel    Artikelobjekt wurde bei ArtikelDialog erzeugt
     */
    public void artikelAnlegen(Artikel beliebigArtikel)
    {
        ueberpruefen(anzahlArtikel <  artikelTab.length, MSG_ARTIKEL_ANLEGEN);
        ueberpruefen(findeArtikel(beliebigArtikel.getArtikelnr()) == -1, MSG_ARTIKEL_VORHANDEN );
        
        artikelTab[anzahlArtikel] = beliebigArtikel;
        anzahlArtikel++;
    }

    /**
     * Lager als ganzes ausgeben, mit Bestand und Wert vom jeweiligen Artikel
     * Gesamtwert des Lagers ausgeben
     */
    public void ausgebenBestandsListe(){
        System.out.println("Lager: " + lagerName + "\n");
        System.out.printf("ArtNr  " + "%-35s" + "Preis " + "  Bestand   " + "Gesamt\n", "Beschreibung");
        String strichZeile = "";
        for (int i = 0; i < 35; i++){
            strichZeile += "- ";
        }
        System.out.println(strichZeile);
        for(int i = 0; i < anzahlArtikel; i++){
            wert = artikelTab[i].getPreis()*artikelTab[i].getBestand();
            System.out.printf(artikelTab[i].getArtikelnr() + "   " + "%-35s" + artikelTab[i].getPreis()  + "     " + artikelTab[i].getBestand() + "     " + wert + "\n", artikelTab[i].getArtikelbzg());
            gesamtWert += wert;
        }
        System.out.println(strichZeile);
        System.out.printf("%-50s" + gesamtWert + "\n", "Gesamtwert: ");
    }
    
    public void getAll(Artikel a){
        preis = a.getPreis();
        bestand = a.getBestand();
        bzg = a.getArtikelbzg();
        nummer = a.getArtikelnr();
    }
    
    public Artikel[] getSorted(Artikel[] stock, String kriterium){
        Artikel [] lagerKopie = new Artikel[anzahlArtikel];
        
        switch(kriterium){
            case ("bzg"):{
                for(int i = 0; i < anzahlArtikel; i++){
                    int indexKuerzeste = 0;
                    String kuerzeste = "Dies ist der laengsste String da das Lager leer ist";
                    for(int j = 0; j < anzahlArtikel - i; j++){
                        String aktuelleBzg = artikelTab[j].getArtikelbzg();
                        if (aktuelleBzg.length() < kuerzeste.length()){
                            kuerzeste = aktuelleBzg;
                            indexKuerzeste = j;
                        }
                    }
                    lagerKopie[i] = artikelTab[indexKuerzeste];
                    artikelEntfernen(artikelTab[indexKuerzeste].getArtikelnr());
                }
                break;
            }
            case ("nr"):{
                for(int i = 0; i < anzahlArtikel; i++){
                    int indexKleinste = 0;
                    int kleinste = 10000;
                    for(int j = 0; j < anzahlArtikel - i; j++){
                        int aktuelleNr = artikelTab[j].getArtikelnr();
                        if (aktuelleNr < kleinste){
                            kleinste = aktuelleNr;
                            indexKleinste = j;
                        }
                    }
                    lagerKopie[i] = artikelTab[indexKleinste];
                    artikelEntfernen(artikelTab[indexKleinste].getArtikelnr());
                }
                break;
            }
            case ("preis"):{
                for(int i = 0; i < anzahlArtikel; i++){
                    int indexKleinster = 0;
                    double kleinster = Double.MAX_VALUE;
                    for(int j = 0; j < anzahlArtikel - i; j++){
                        double aktuellerPreis = artikelTab[j].getPreis();
                        if (aktuellerPreis < kleinster){
                            kleinster = aktuellerPreis;
                            indexKleinster = j;
                        }
                    }
                    lagerKopie[i] = artikelTab[indexKleinster];
                    artikelEntfernen(artikelTab[indexKleinster].getArtikelnr());
                }
                break;
            }
            case ("bestand"):{
                for(int i = 0; i < anzahlArtikel; i++){
                    int indexKleinster = 0;
                    int kleinster = Integer.MAX_VALUE;
                    for(int j = 0; j < anzahlArtikel - i; j++){
                        int aktuellerBestand = artikelTab[j].getBestand();
                        if (aktuellerBestand < kleinster){
                            kleinster = aktuellerBestand;
                            indexKleinster = j;
                        }
                    }
                    lagerKopie[i] = artikelTab[indexKleinster];
                    artikelEntfernen(artikelTab[indexKleinster].getArtikelnr());
                }
                break;
            }
        }
        artikelTab = lagerKopie;
        return lagerKopie;
    }
    
    public void filter(boolean tester){        
        UnaryOperator <Artikel> teste = a -> (tester) ? a : null;
        for(Artikel a : artikelTab){
             getAll(a);
             teste.apply(a);
        }
    }
    
    public void applyToArticles(UnaryOperator<Artikel> function){
        for(Artikel a: this.artikelTab){
            getAll(a);
            function.apply(a);
        }
    }
    
    public void applyToSomeArticles(boolean test, UnaryOperator<Artikel> function){
        UnaryOperator <Artikel> teste = a -> (test) ? a : null;
        for(Artikel a : artikelTab){
             getAll(a);
             if(teste.apply(a) != null){
                 function.apply(a);
             };
        }
    }
    
    public Artikel[] getArticles(boolean tester, String kriter){
        Artikel[] ausgabe = new Artikel[anzahlArtikel];
        int anzahlAusgabe = 0;
        UnaryOperator <Artikel> teste = a -> (tester) ? a : null;
        for(Artikel a : artikelTab){
            getAll(a);
            if(teste.apply(a) != null){
                ausgabe[anzahlAusgabe] = a;
                anzahlAusgabe++;
            }
        }
        return getSorted(ausgabe, kriter);
    }
    
        
    /**
     * Eine Methode zur Ueberpruefung einer gegebenen bedingung und falls diese nichr erfuelllt ist, werfen einer fehlermeldung 
     *@param bedinngung  Eine Bedingung wird auf Richtigkeit ueberprueft
     *@param meldung  Eine Fehlermeldung falls die bedingung nicht erfuellt ist
     */
    private static void ueberpruefen(boolean bedingung, String meldung){
        if (!bedingung){
            throw new RuntimeException(meldung);
        }
    }
}