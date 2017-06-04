
/**
 * Write a description of class TitelNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerlagNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Der Verlag darf nicht leer sein";
    public VerlagNichtGueltigException()
    {
        super(MESSAGE);
    }
}
