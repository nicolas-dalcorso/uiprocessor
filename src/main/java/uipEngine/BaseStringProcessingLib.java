package uipEngine;

import java.util.HashMap;
import uiprocessor.uipExceptions.NotImplementedException;
import java.text.Normalizer;




/**
 * {@code BaseStringProcessingLib} is a library class that is used to process strings.
 *
 *	Its focus is on providing basic string processing functions for
 *		- 	removing excess whitespace (> MAX_WHITESPACE)
 *        	if MAX_WHITESPACE is set to 1, all whitespace will be reduced to a single space
 *		-	removing excess newlines (> MAX_NEWLINES)
 *      - 	removing leading and trailing whitespace
 *      -	converting accented characters to their non-accented counterparts
 *      	
 */
public class BaseStringProcessingLib {
	public HashMap<String, String> rules;

	/**
	 * Creates a new {@code BaseStringProcessing}.
	 */
	public BaseStringProcessingLib() {
		setRules(1, 1, true, true, true);
	};
	
	/**
	 * Creates a new {@code BaseStringProcessingLib} with the given rules.
	 */
	public BaseStringProcessingLib(	int max_whitespace, 
                                    int max_newlines,
                                    boolean remove_trailing_whitespace,
                                    boolean remove_leading_whitespace,
                                    boolean remove_accents) {
		setRules(max_whitespace, max_newlines, remove_trailing_whitespace, remove_leading_whitespace, remove_accents);
	};
	
	/**
     * Sets the rules for the {@code BaseStringProcessingLib}.
     * 
     * @param max_whitespace
     * @param max_newlines
     * @param remove_trailing_whitespace
     * @param remove_leading_whitespace
     * @param remove_accents
     */
	public void setRules(	int max_whitespace, 
							int max_newlines,
							boolean remove_trailing_whitespace,
							boolean remove_leading_whitespace,
							boolean remove_accents) {
        rules = new HashMap<String, String>();
        rules.put("max_whitespace", Integer.toString(max_whitespace));
        rules.put("max_newlines", Integer.toString(max_newlines));
        rules.put("remove_trailing_whitespace", Boolean.toString(remove_trailing_whitespace));
        rules.put("remove_leading_whitespace", Boolean.toString(remove_leading_whitespace));
        rules.put("remove_accents", Boolean.toString(remove_accents));
    };
		
    
    //	Library
    /**
     * Removes excess whitespace from the input string.
     * 
     * @param String input
     * @return String output
     */
    public String removeExcessWhitespace(String input) throws Exception {
    	String output = input;
        if (Integer.parseInt(rules.get("max_whitespace")) == 1) {
            output = output.replaceAll("\\s+", " ");
		} else {
			throw new NotImplementedException("'max_whitespace' must be 1");
		}
        return output;
    };
    
	/**
	 * Removes excess newlines from the input string.
	 * 
	 * @param String input
	 * @return String output
	 */
    public String removeExcessNewlines(String input) throws Exception {
    	String output = input;
        if (Integer.parseInt(rules.get("max_newlines")) == 1) {
            output = output.replaceAll("\\n+", "\n");
		} else {
			throw new NotImplementedException("'max_newlines' must be 1");
		}
        return output;
    };
    
	/**
	 * Removes leading and trailing whitespace from the input string.
	 * 
	 * @param String input
	 * @return String output
	 */
	public String trim(String input) {
		String output = input;
		if (Boolean.parseBoolean(rules.get("remove_leading_whitespace"))) {
			output = output.replaceAll("^\\s+", "");
		}
		if (Boolean.parseBoolean(rules.get("remove_trailing_whitespace"))) {
			output = output.replaceAll("\\s+$", "");
		}
		return output;
	};
	
	/**
	 * Removes accents from the input string.
	 * 
	 * @param String input
	 * @return String output
	 */
	public String removeAccents(String input) {
		String output = input;
		if (Boolean.parseBoolean(rules.get("remove_accents"))) {
			output = Normalizer.normalize(output, Normalizer.Form.NFD);
			output = output.replaceAll("[^\\p{ASCII}]", "");
			}
		return output;
    };
    
    //	Main program
	/**
	 * Runs each of the functions in the {@code BaseStringProcessingLib} over the input
	 */
	public String run(String input) {
		String output = input;
		try {
			output = removeExcessWhitespace(output);
			output = removeExcessNewlines(output);
			output = trim(output);
			output = removeAccents(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	};
}
