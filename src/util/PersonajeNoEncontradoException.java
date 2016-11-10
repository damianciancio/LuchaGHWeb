package util;

import org.apache.logging.log4j.Level;

@SuppressWarnings("serial")
public class PersonajeNoEncontradoException extends ApplicationException {
	
	public PersonajeNoEncontradoException () {
		super();
	}
	
	public PersonajeNoEncontradoException (String msj) {
		super(msj);
	}
	
	public PersonajeNoEncontradoException(String message, Throwable cause)
	{
		super(message, cause, Level.DEBUG);
	}
}
