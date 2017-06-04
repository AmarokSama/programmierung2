
/**
 * Write a description of class ArtikelNummerNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BestandNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Der Bestand muss groesser gleich null sein, ihre Eingabe war : %d";
    private int falscherBestand;
    public BestandNichtGueltigException(int falscherBestand)
    {
        String.format(MESSAGE, falscherBestand);
    }
}
