
/**
 * Write a description of class ArtikelNummerNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArtikelNummerNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Die Artikel-Nummer muss 4-stellig sein, ihre Eingabe war : %d";
    private int falscheNummer;
    public ArtikelNummerNichtGueltigException(int falscheNummmer)
    {
        System.out.printf(MESSAGE, falscheNummer);
    }
}
