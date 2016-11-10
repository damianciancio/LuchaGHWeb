package util;

import org.apache.logging.log4j.Level;

@SuppressWarnings("serial")
public class ErrorConexionException extends ApplicationException {

	public ErrorConexionException () {
		super();
	}
	
	public ErrorConexionException (String msj) {
		super(msj);
	}
	
	public ErrorConexionException(String message, Throwable cause)
	{
		super(message, cause, Level.ERROR);
	}
}
