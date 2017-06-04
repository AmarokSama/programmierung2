
/**
 * Write a description of class ArtikelNummerNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PreisNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Der Preis muss groesser als 0 sein, ihre Eingabe war : %d";
    private double falscherPreis;
    public PreisNichtGueltigException(double falscherPreis)
    {
        String.format(MESSAGE, falscherPreis);
    }
}
