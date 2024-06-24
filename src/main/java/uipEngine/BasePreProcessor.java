package uipEngine;

import java.text.Normalizer;
/**
 * Removes trailing whitespaces, converts multiple newlines to single newline, and removes accents from the input string.
 */
public class BasePreProcessor extends PreProcessor{
	/**
	 * Creates a new {@code BasePreProcessor}
	 * @param input
	 */
	public BasePreProcessor(String input) {
		super(input);
    };
    
	/**
	 * Preprocesses the input and returns the output.
	 * 
	 * @return String output
	 */
    @Override
    public String process() {
    	//	Remove excess whitespace
    	String output = input.stripTrailing();
    	
    	//	Remove excess newlines
    	output = output.replaceAll("\\n{2,}", "\n");
    	
    	//	Remove accents
    	output = Normalizer.normalize(output, Normalizer.Form.NFD);
    	output = output.replaceAll("[^\\p{ASCII}]", "");
    	
    	return output;
    };
    
	public static void main(String[] args) {
    	BasePreProcessor preProcessor = new BasePreProcessor("This is a test string with trailing whitespaces. \n   ");
    	System.out.println(preProcessor.process());
    	
    	preProcessor = new BasePreProcessor("This is a test string with multiple newlines. \n\n\n \n");
    	System.out.println(preProcessor.process());
    	
    	preProcessor = new BasePreProcessor("This is a test string with accents. áéíóú");
    	System.out.println(preProcessor.process());
    	
    	preProcessor = new BasePreProcessor("This is a test string with all the above. áéíóú \n\n\n   ");
    	System.out.println(preProcessor.process());
    };
};
