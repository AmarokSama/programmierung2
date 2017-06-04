
/**
 * Write a description of class InterpretNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InterpretNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Der Interpret darf nicht leer sein";
    public InterpretNichtGueltigException()
    {
        super(MESSAGE);
    }
}
