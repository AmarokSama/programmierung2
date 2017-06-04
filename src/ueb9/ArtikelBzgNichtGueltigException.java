
/**
 * Write a description of class InterpretNichtGueltigException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArtikelBzgNichtGueltigException extends RuntimeException
{
    private static final String MESSAGE = "Die Bezeichnung darf nicht leer sein";
    public ArtikelBzgNichtGueltigException()
    {
        super(MESSAGE);
    }
}
