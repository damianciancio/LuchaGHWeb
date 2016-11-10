package util;

import org.apache.logging.log4j.Level;

@SuppressWarnings("serial")
public class DriverNoEncontradoException extends ApplicationException {
	
	public DriverNoEncontradoException () {
		super();
	}
	
	public DriverNoEncontradoException (String msj) {
		super(msj);
	}
	
	public DriverNoEncontradoException(String message, Throwable cause)
	{
		super(message, cause, Level.ERROR);
	}

}
