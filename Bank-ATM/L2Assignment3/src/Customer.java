/* File: Customer.java
 * Date: 2015
 * Author: Stanley Pieda
 * Description: Sample solution Assignment 2 CST8132 (15W)
 */

/*
 * Represents a Customer
 */
public class Customer {
	/*
	 * Array of references to Account objects
	 */
	private Account[] accounts;

	/*
	 * First name of customer
	 */
	private String firstName;

	/*
	 * Last name of customer
	 */
	private String lastName;

	/*
	 * Overloaded constructor, accepts references to Strings for first and last
	 * name fields, also creates an Array of references to Account objects with
	 * a size of 2. Note that the array elements themselves are left null.
	 */
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new Account[2];
	}

	/*
	 * No-parameter constructor, calls overloaded constructor.
	 */
	public Customer() {
		this("Unknown first name", "Unknown last name");
	}

	/*
	 * Accessor for firstName field
	 */
	public String getFirstName() {
		return firstName;
	}

	/*
	 * Mutator for firstName field
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * Accessor for lastName field
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * Mutator for lastName field
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * Attempts to create an account and store a reference to it in the array.
	 * The array only stores 2 accounts at most. Returns a TransactionResult
	 * that will indicate if the operation succeeded or failed with a message.
	 * Updated to support 2 account types (there may be a better way to do this)
	 */
	public TransactionResult createAccount(AccountType accountType) {
		String message;
		if (accounts[0] == null) {
			// to do: split this out into another method.
			if (accountType.equals(AccountType.CHEQUING_ACCOUNT)) {
				accounts[0] = new ChequingAccount();
				message = "Chequing";
			} else {
				accounts[0] = new SavingAccount();
				message = "Saving";
			}
			return new TransactionResult(true, message
					+ " Account at index 0 created");
		} else if (accounts[1] == null) {
			if (accountType.equals(AccountType.CHEQUING_ACCOUNT)) {
				accounts[1] = new ChequingAccount();
				message = "Chequing";
			} else {
				accounts[1] = new SavingAccount();
				message = "Saving";
			}
			return new TransactionResult(true, message
					+ " Account at index 1 created");
		} else {
			return new TransactionResult(false,
					"Account not created, account limit reached (2 accounts already exist)");
		}
	}

	/*
	 * Attempts to deposit an amount into an account at the specified index.
	 * Verifies that there is an Account object at the specified index. Returns
	 * a TransactionResult that will indicate if the operation succeeded or
	 * failed with a message.
	 */
	public TransactionResult deposit(int accountIndex, double amount) {
		if (hasNoAccounts()) {
			return new TransactionResult(false,
					"Customer has no accounts, deposit not completed");
		} else if (accountIndex < 0 || accountIndex > accounts.length - 1) {
			return new TransactionResult(false,
					"Invalid account index, deposit not completed");
		} else if (accounts[accountIndex] == null) {
			return new TransactionResult(false,
					"Invalid account index, deposit not completed");
		} else {
			return accounts[accountIndex].deposit(amount);
		}
	}

	/*
	 * Attempts to withdraw an amount from an account at the specified index.
	 * Verifies that there is an Account object at the specified index. Returns
	 * a TransactionResult that will indicate if the operation succeeded or
	 * failed with a message.
	 */
	public TransactionResult withdraw(int accountIndex, double amount) {
		if (hasNoAccounts()) {
			return new TransactionResult(false,
					"Customer has no accounts, withdrawal not completed");
		} else if (accountIndex < 0 || accountIndex > accounts.length - 1) {
			return new TransactionResult(false,
					"Invalid account index, withdrawal not completed");
		} else if (accounts[accountIndex] == null) {
			return new TransactionResult(false,
					"Invalid account index, withdrawal not completed");
		} else {
			return accounts[accountIndex].withdraw(amount);
		}
	}

	/*
	 * Generates a String representing this Customer object, including details
	 * on the Accounts (if there are any).
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer:").append(firstName).append(" ")
				.append(lastName).append(System.lineSeparator());
		if (hasNoAccounts()) {
			builder.append("Customer has no accounts");
		} else {
			for (int index = 0; index < accounts.length; index++) {
				if (accounts[index] != null) {
					builder.append(accounts[index].toString());
					if (index != accounts.length - 1) {
						builder.append(System.lineSeparator());
					}
				}
			}
		}
		return builder.toString();
	}

	/*
	 * Iterates over the accounts array and calls applyInterest() on each
	 * referenced Account object.
	 */
	public void applyInterest() {
		for (int index = 0; index < accounts.length; index++) {
			if (accounts[index] != null) {
				accounts[index].applyInterest();
			}
		}
	}

	/*
	 * Helper method used to determine if the customer has no accounts. Returns
	 * true if there are no accounts.
	 */
	private boolean hasNoAccounts() {
		return (accounts[0] == null && accounts[1] == null);
	}
}
