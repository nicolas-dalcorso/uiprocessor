package uiprocessor.uipExceptions;

public class NotImplementedException extends Exception{
	private static final long serialVersionUID = 102L;
	private static final String DEFAULT_MESSAGE = "Not implemented: ";
	private String message;

	public NotImplementedException(String message) {
		super(message);
	};

	public NotImplementedException() {
		super();
	};

	public NotImplementedException(String message, Throwable cause) {
		super(message, cause);
	};

	public NotImplementedException(Throwable cause) {
		super(cause);
	};

	public NotImplementedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	};
}
