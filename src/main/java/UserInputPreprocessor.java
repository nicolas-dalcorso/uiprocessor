import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

import uiprocessor.uipExceptions.InvalidInputException;
import uipEngine.BasePreProcessor;

public class UserInputPreprocessor {
	public String 				input;
	public String 				output;
	private BasePreProcessor 	preprocessor;

	/**
	 * Creates a new {@code UserInputPreprocessor}.
	 * @param String input
	 * @throws InvalidInputException
	 */
	public UserInputPreprocessor(String input) throws InvalidInputException {
        //    Validate input
		if (input == null || input.isEmpty()) {
			throw new InvalidInputException("Input cannot be null or empty");
		};
		
		this.input = input;
        this.output = null;
        this.preprocessor = new BasePreProcessor(input);
    };
    
    /**
     * Creates a new {@code UserInputPreprocessor}, taking in the input from a file
     * 
     * @param File file
     * @throws InvalidInputException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws Exception
     */
    public UserInputPreprocessor(File file) throws InvalidInputException, IOException, FileNotFoundException, Exception {
    	//    Validate input
		if (file == null) {
			throw new InvalidInputException("File cannot be null");
		}	else if (!file.exists()) {
					throw new FileNotFoundException("File does not exist");
        		};
        		
        //    Read file
        String input = "";
        try {
        	input = Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
        	throw new IOException("Error reading file");
        };
        
        //    Validate input
        if (input == null || input.isEmpty()) {
        	throw new InvalidInputException("Input cannot be null or empty");
        };
        
        this.input = input;
        this.output = null;
        this.preprocessor = new BasePreProcessor(input);
    };
		
	/**
	 * Creates a new {@code UserInputPreprocessor}	
	 */
    public UserInputPreprocessor() {
    	this.input = null;
    	this.output = null;
    	this.preprocessor = null;
    };
  
	/**
	 * Tries to preprocess the input and returns the output.
	 * 
	 * @return String output
	 */
	public String process() {
		try {
			output = preprocessor.process();
        } catch (Exception e) {
            e.printStackTrace();
        };
        return output;
	};
    
	
	
	//	Main program
	public static void main(String[] args) {
		//	Test with string input
		try {
			UserInputPreprocessor preprocessor = new UserInputPreprocessor(
					"This is a test string with trailing whitespaces. \n   ");
			System.out.println(preprocessor.process());
	
			preprocessor = new UserInputPreprocessor("This is a test string with multiple newlines. \n\n\n \n");
			System.out.println(preprocessor.process());
	
			preprocessor = new UserInputPreprocessor("This is a test string with accents. áéíóú");
			System.out.println(preprocessor.process());
	
			preprocessor = new UserInputPreprocessor("This is a test string with all the above. áéíóú \n\n\n   ");
			System.out.println(preprocessor.process());
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	//	Test with file
	try {
		UserInputPreprocessor preprocessor = new UserInputPreprocessor(new File("teste.txt"));
		System.out.println(preprocessor.process());
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	};
	
	
};