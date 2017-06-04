
/**
 * Write a description of class AutorNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AutorNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Autor darf nicht leer sein";
    public AutorNichtGueltigException()
    {
        super(MESSAGE);
    }
}
