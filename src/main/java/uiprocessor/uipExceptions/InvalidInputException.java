package uiprocessor.uipExceptions;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 101L;
	private static final String DEFAULT_MESSAGE = "Invalid input: ";
	private String message;
	
	
	public InvalidInputException(String message) {
		super(message);
	};
	
	public InvalidInputException() {
		super();
	};
	
	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	};
	
	public InvalidInputException(Throwable cause) {
		super(cause);
	};
	
	public InvalidInputException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	};
}
