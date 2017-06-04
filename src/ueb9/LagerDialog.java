import java.util.*;
/**
 * Die Dialog-Klasse zu unserem Lager
 * 
 * @author Pascal Fickert & Luis Willnat
 * @version 1
 */
public class LagerDialog
{

    private Lager lager;
    private Scanner input = new Scanner(System.in);

    private static final int ANLEGEN        = 1;
    private static final int LOESCHEN       = 2;
    private static final int ABGANG         = 3;
    private static final int ZUGANG         = 4;
    private static final int LAGERAUFRUFEN = 5;
    private static final int BESTANDSLISTE = 6;
    private static final int PREISE_ERHOEHEN= 7;
    private static final int PREISE_SENKEN  = 8;
    
    private static final int ENDE           = 0;
    private static final int INIT           = -1;

    private static final char ARTIKEL = 'a';
    private static final char BUCH = 'b';
    private static final char CD = 'c';
    private static final char DVD = 'd';

    /**
     * Standardkonstruktor deer Klasse LagerDialog
     */
    public LagerDialog()
    {
    }

    /**
     * Hauptschleife des Programms, inbegriffen das Fangen von Ausnahmen
     */
    public void start(){

        int funktion = INIT;
        System.out.print("name des Lagers? ");
        String name = input.nextLine();
        System.out.print("Wie viele Artikel passen maximal in das Lager? ");
        int groesse = input.nextInt();
        lager = new Lager(name, groesse);

        while (funktion != ENDE){
            try{
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch(AssertionError e) {
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println("Folgende Ausnahme wurde gefangen: " + e);
                e.printStackTrace(System.out);
            } catch (Exception e){
                System.out.println("Eine ausnahme wurde gefunden" + e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Menü anzeigen und Funktion einlesen
     * @return eingelesene Funktion als Ganzer wert (int)
     */
    private int einlesenFunktion(){
        System.out.print(ANLEGEN         + ": Artikel anlegen; \n"          +
            LOESCHEN        + ": Artikel loeschen; \n"         +
            ABGANG          + ": abgang; \n"           +
            ZUGANG          + ": zugang; \n"           +
            LAGERAUFRUFEN  + ": Lager aufrufen \n"   +
            BESTANDSLISTE + ": Bestandsliste ausgeben \n" +
            PREISE_ERHOEHEN + ": alle preise Um x % erhoehen; \n" +
            PREISE_SENKEN   + ": alle preise Um x % senken; \n" +
            ENDE            + ": beenden--> ");
        return input.nextInt();
    }

    /**
     * Ausführung der ausgewählten Funtion
     * @param funktion   muss eine ganze Zahl sein
     */
    private void ausfuehrenFunktion(int funktion){
        int artikelNummer;
        String bezeichnung;
        double preis;
        int menge;
        switch(funktion){
            case ANLEGEN: 
            lagerArtikelAnlegen();
            break; 
            case LOESCHEN:
            lager.artikelEntfernen(einlesenArtikelNr());
            break;
            case ABGANG:
            lager.lagerAbgang(einlesenArtikelNr(), einlesenMenge());
            break;
            case ZUGANG:
            lager.lagerZugang(einlesenArtikelNr(), einlesenMenge());
            break;
            case LAGERAUFRUFEN:
            System.out.println(lager);
            break;
            case BESTANDSLISTE:
            lager.ausgebenBestandsListe();
            break;
            case PREISE_ERHOEHEN:
            lager.preisVeraenderungPlus(einlesenProzente());
            break;
            case PREISE_SENKEN:
            lager.preisVeraenderungMinus(einlesenProzente());
            break;
            case ENDE:
            System.out.println("Programmende");
            break;
        }
    }

    /**
     * Einen Artikel anlegen, abhaengig vom Typ des Artikels
     * 
     */
    public void lagerArtikelAnlegen(){
        String artikelTyp = einlesenString(" \nArtikeltyp : ");
        
        //generelle Attribute abfragen
        int nummer = einlesenArtikelNr();        
        int menge = einlesenInt(" \n Geben sie die Menge ein :   ");
        double preis = einlesenDouble(" \n Geben sie den Preis ein :   ");
        
        switch(artikelTyp.toLowerCase().charAt(0)){
            case ARTIKEL:
            String bezeichnung = einlesenString("\nGeben sie die Bezeichnung ein  : ");
            lager.artikelAnlegen( new Artikel(nummer, bezeichnung, menge, preis));
            break;

            case BUCH:
            //spezifiische Attribute für Buch
            String titel = einlesenString("\nGeben sie den Titel ein :   ");
            String autor = einlesenString("\nGeben sie den Autor ein :   ");
            String verlag = einlesenString("\nGeben sie den Verlag ein :   ");
            String buchBezeichnung = einlesenString("\nGeben sie die Bezeichnung ein  : ");
            lager.artikelAnlegen(new Buch(nummer, buchBezeichnung,autor, titel, verlag, menge, preis));
            break;

            case CD:
            //speziifische Attribute für CD
            String interpret = einlesenString("\nGeben sie den Interpret ein :   ");
            String titelCD = einlesenString("\nGeben sie den Titel ein :   ");
            int anzahlTitel = einlesenInt("\nGeben sie die Anzahl der Lieder ein :   ");
            String cdBezeichnung = einlesenString("\nGeben sie die Bezeichnung ein  : ");
            lager.artikelAnlegen(new CD(nummer, cdBezeichnung, interpret, titelCD, anzahlTitel, menge, preis));
            break;

            case DVD:
            //spezifische Attribute für DVD
            String titelDVD = einlesenString(" \n Geben sie den Titel ein :   ");
            int dauer = einlesenInt("\nGeben sie die Dauer der DVD ein :   ");
            int jahr = einlesenInt("\nGeben sie den Jahr ein :   ");
            lager.artikelAnlegen(new DVD(nummer, titelDVD, dauer, jahr, menge, preis));
            break;

            default:
            System.out.println("Falsche Eingabe");
        }
    }

    /**
     * @param msg  die Nachricht die dem Benutzer anzeigt was er eingeben soll
     * @return die Eingabe des Benutzers
     */
    private String einlesenString(String msg){
        System.out.print(msg);
        input.nextLine();
        return input.nextLine();
    }

    /**
     * @param msg  die Nachricht die dem Benutzer anzeigt was er eingeben soll
     * @return die Eingabe des Benutzers
     */
    private int einlesenInt(String msg){
        System.out.print(msg);
        return input.nextInt();
    }

    /**
     * @param msg  die Nachricht die dem Benutzer anzeigt was er eingeben soll
     * @return die Eingabe des Benutzers
     */
    private double einlesenDouble(String msg){
        System.out.print(msg);
        return input.nextDouble();
    }

    /**
     * Den Benutzer die Nummer des Artikels fragen und diesen einlesen
     * @return die Artikelnummer
     */
    private int einlesenArtikelNr(){
        System.out.print("\n Artikelnummer: ");
        int artikelnr = input.nextInt();
        return artikelnr;
    }

    /**
     * Den Benutzer die Bezeichnung des Artikels fragen und diesen einlesen
     * @return Eingabe des Benutzers
     */
    private String einlesenBezeichnung(){
        System.out.print("Artikel Bezeichnung: ");
        return input.nextLine();
    }

    /**
     * Den Benutzer den Preis des Artikels fragen und diesen einlesen
     * @return Eingabe des Benutzers
     */
    private double einlesenPreis(){
        System.out.print("Artikel Preis: ");
        return input.nextDouble();
    }

    /**
     * Den Benutzer die Menge fragen die dem Lager hinzugefuegt oder entfernt wird und diesen einlesen
     * * @return Eingabe des Benutzers
     */
    private int einlesenMenge(){
        System.out.print("Menge: ");
        return input.nextInt();
    }

    /**
     * Den Benutzer den Prozentsatz fuer das Aendern des Preises fragen und diesen einlesen
     * * @return Eingabe des Benutzers
     */
    private double einlesenProzente(){
        System.out.print("Prozentuale Veraennderung: ");
        return input.nextDouble();
    }

    /**
     * Main-Methode zum starten des Dialog-objektes und dadurch auslösung der Testschleife
     */
    public static void main(String[] args) {
        new LagerDialog().start();
    }
}