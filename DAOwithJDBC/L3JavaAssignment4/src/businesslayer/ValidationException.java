package businesslayer;

/* File: ValidationException.java
 * Author: Zhe Huang
 * Date: 2016
 * Description: Implementation validation exception
 */

/**
 * Implementation validation exception. Code in this file was based on lecture
 * materials provided by Stanley Pieda(2015) personal communication
 * 
 * @author ZHE Huang
 * @version 1.0.0
 * @since 1.8.0_73
 */
public class ValidationException extends Exception {

	/**
	 * Default constructor
	 */
	public ValidationException() {
		super("Data not in valid format");
	}

	/**
	 * Constructor with parameter message
	 * 
	 * @param message
	 *            value of String
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * Constructor with parameter message and throwable
	 * 
	 * @param message
	 *            value of String
	 * @param throwable
	 *            value of Throwable
	 */
	public ValidationException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Constructor with parameter throwable
	 * 
	 * @param throwable
	 *            value of Throwable
	 */
	public ValidationException(Throwable throwable) {
		super(throwable);
	}
}
