
/**
 * Write a description of class DauerNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DauerNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Die Dauer muss groesser als 0 sein, ihre Eingabe war: %d";
    private int falscheDauer;
    public DauerNichtGueltigException(int falscheDauer)
    {
        super(String.format(MESSAGE, falscheDauer));
    }
}
