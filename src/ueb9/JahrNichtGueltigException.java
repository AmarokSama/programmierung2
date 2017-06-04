
/**
 * Write a description of class JahrNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JahrNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Das Jahr muss zwischen 1949 und 2017 sein, ihre Eingabe war: %d";
    private int falschesJahr;
    public JahrNichtGueltigException(int falschesJahr)
    {
        super(String.format(MESSAGE, falschesJahr));
    }
}
