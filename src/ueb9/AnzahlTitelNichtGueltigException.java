
/**
 * Write a description of class AnzahlTitelNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnzahlTitelNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Die Anzahl muss groesser als null sein, ihre Eingabe war: &d";
    private int falscheAnzahlTitel;
    public AnzahlTitelNichtGueltigException(int falscheAnzahlTitel)
    {
        super(String.format(MESSAGE, falscheAnzahlTitel));
    }
}
