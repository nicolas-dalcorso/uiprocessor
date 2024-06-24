package uipEngine;

/**
 * The {@code PreProcessor} class is an abstract class that is used to preprocess a given input.
 */
public abstract class PreProcessor {
	protected String input;
	protected String output;

	/**
	 * Creates a new {@code PreProcessor}.
	 * @param input
	 */
	public PreProcessor(String input) {
		this.input = input;
		this.output = null;
	};
	
	/**
	 * Preprocesses the input and returns the output.
	 * 
	 * @return String output
	 */
	public abstract String process();
}
