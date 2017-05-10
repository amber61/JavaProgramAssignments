/* File: TransactionResult.java
 * Date: 2015
 * Author: Stanley Pieda
 * Description: Sample solution Assignment 2 CST8132 (15W)
 */

/*
 * Represents a result from a variety of operations (method calls)
 * within the Assignment 2 program. Used by classes
 * Account, Customer, Bank, BankManager
 */
public class TransactionResult {
	/*
	 * Field that holds success or failure of attempted operation
	 */
	private boolean wasSuccessful;

	/*
	 * Text message with more information about the operation's success or
	 * failure
	 */
	private String message;
	/*
	 * Field that holds type of transaction
	 */
	private TransactionType transactionType;

	/*
	 * Constructor, accepts boolean for operation success/failure (true/false
	 * respectively) as well as a text message with more information.
	 */
	public TransactionResult(boolean wasSuccessful, String message) {
		this.wasSuccessful = wasSuccessful;
		this.message = message;
	}

	/*
	 * Constructor, accepts boolean for operation success/failure (true/false
	 * respectively), a text message with more information, as well as a enum
	 * indicates transaction type
	 */
	public TransactionResult(boolean wasSuccessful, String message,
			TransactionType transactionType) {
		this(wasSuccessful, message);
		this.transactionType = transactionType;
	}

	/*
	 * Accessor for wasSuccessful field.
	 */
	public boolean getWasSuccessful() {
		return wasSuccessful;
	}

	/*
	 * Accessor for message field.
	 */
	public String getMessage() {
		return message;
	}

	/*
	 * Accessor for transactionType field.
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/*
	 * Retrieve transaction type to NONE
	 */
	public void finish() {
		transactionType = TransactionType.NONE;
	}
}
