package europass.core;

import java.io.Serial;

/**
 * Library exception wrapper. 
 */
public class EuropassException extends Exception {

	//----------------------------------------------------
	// Exception constants
	
	@Serial
	private static final long serialVersionUID = 8357694685622444764L;
	
	//----------------------------------------------------
	// Exception methods		
	
	/**
	 * Creates an empty exception.
	 */
	public EuropassException() {
		super();
	}

	/**
	 * Creates an exception wrapping a cause, with a customized message.
	 * @param msg Message
	 * @param ex Wrapped cause
	 */
	public EuropassException(String msg, Throwable ex) {
		super(msg, ex);
	}

	/**
	 * Creates an exception with a customized message.
	 * @param msg Message
	 */
	public EuropassException(String msg) {
		super(msg);
	}

	/**
	 * Creates an exception wrapping its cause
	 * @param ex Wrapped cause
	 */
	public EuropassException(Throwable ex) {
		super(ex);
	}
}
