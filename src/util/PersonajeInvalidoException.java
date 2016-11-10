package util;

import org.apache.logging.log4j.Level;

@SuppressWarnings("serial")
public class PersonajeInvalidoException extends ApplicationException {
	
	public PersonajeInvalidoException () {
		super();
	}
	
	public PersonajeInvalidoException (String msj) {
		super(msj);
	}
	
	public PersonajeInvalidoException(String message, Throwable cause)
	{
		super(message, cause, Level.DEBUG);
	}
}
