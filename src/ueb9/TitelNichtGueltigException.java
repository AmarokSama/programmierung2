
/**
 * Write a description of class TitelNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitelNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Der Titel darf nicht leer sein";
    public TitelNichtGueltigException()
    {
        super(MESSAGE);
    }
}
