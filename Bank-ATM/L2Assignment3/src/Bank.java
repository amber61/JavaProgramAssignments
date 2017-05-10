/* File: Bank.java
 * Date: 2015
 * Author: Stanley Pieda
 * Description: Sample solution Assignment 2 CST8132 (15W)
 * Updated for Assignment 2 to support account type selection
 */

/*
 * Represents a Bank
 */
public class Bank {
	/*
	 * Array of references to customers
	 */
	private Customer[] customers;

	/*
	 * used to track the number of customers in the bank
	 */
	private int customerCount;

	/*
	 * No-parameter constructor, sets customerCount to zero, and creates an
	 * array of references to Customer objects that can hold a maximum of 5.
	 * Note that the elements in the array are left as null by this constructor.
	 */
	public Bank() {
		customerCount = 0;
		customers = new Customer[5];
	}

	/*
	 * Attempts to create a Customer using the specified first and last names
	 * and attempts to assign a reference to it into the customers array. A
	 * reference to a TransactionResult is returned that contains information on
	 * the success / failure and a message.
	 */
	public TransactionResult addCustomer(String firstName, String lastName) {
		if (customerCount >= customers.length) {
			return new TransactionResult(false,
					"Could not create customer, bank is full");
		} else {
			customerCount++;
			customers[customerCount - 1] = new Customer(firstName, lastName);
			return new TransactionResult(true, "Customer added to bank");
		}
	}

	/*
	 * Attempts to add an account to the specified customer based on specified
	 * index by calling createAccount() on the Customer object if there is one
	 * available. A reference to a TransactionResult is returned that contains
	 * information on the success / failure and a message. Updated to accept an
	 * argument for account type which is passed into
	 * customer.createAccount(AccountType)
	 */
	public TransactionResult addAccount(int customerIndex,
			AccountType accountType) {
		if (customerCount == 0) {
			return new TransactionResult(false,
					"No customers, cannot add account");
		} else if (customerIndex < 0 || customerIndex > customerCount - 1) {
			return new TransactionResult(false,
					"Invalid customer index, could not add account");
		} else {
			return customers[customerIndex].createAccount(accountType);
		}
	}

	/*
	 * Generates a String of customers with index, first name, last name and
	 * with each record on separate lines.
	 */
	public String customerList() {
		StringBuilder builder = new StringBuilder();
		if (customerCount == 0) {
			builder.append("No customers to list");
		}
		for (int index = 0; index < customerCount; index++) {
			builder.append("Index: ").append(index).append(" ");
			builder.append(" First name: ")
					.append(customers[index].getFirstName());
			builder.append(" Last name: ")
					.append(customers[index].getLastName());
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

	/*
	 * Generates a String representing the customer details of the Customer
	 * referenced at the specified index in the array, or a warning if there is
	 * no Customer avaiable.
	 */
	public String customerDetails(int index) {
		if (index < 0 || index > customers.length - 1
				|| customers[index] == null) {
			return "Invalid index, no customer available at that index for display";
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append("Customer at index: ").append(index)
					.append(System.lineSeparator());
			builder.append(customers[index].toString());
			return builder.toString();
		}
	}

	/*
	 * Attempts to make a deposit on the Customers account using customer index,
	 * account index, and the amount. Verifies that there is a customer at the
	 * specified index. A reference to a TransactionResult is returned that
	 * contains information on the success / failure and a message.
	 */
	public TransactionResult deposit(int customerIndex, int accountIndex,
			double amount) {
		if (customerIndex < 0 || customerIndex > customerCount - 1) {
			return new TransactionResult(false,
					"Invalid customer index, could not make deposit");
		} else {
			return customers[customerIndex].deposit(accountIndex, amount);
		}
	}

	/*
	 * Attempts to make a withdrawal on the Customers account using customer
	 * index, account index, and the amount. Verifies that there is a customer
	 * at the specified index. A reference to a TransactionResult is returned
	 * that contains information on the success / failure and a message.
	 */
	public TransactionResult withdraw(int customerIndex, int accountIndex,
			double amount) {
		if (customerIndex < 0 || customerIndex > customerCount - 1) {
			return new TransactionResult(false,
					"Invalid customer index, could not make withdrawal");
		} else {
			return customers[customerIndex].withdraw(accountIndex, amount);
		}
	}

	/*
	 * Iterates over the customers array and requests that each referenced
	 * Customer object applies it's interest rate.
	 */
	public void applyInterest() {
		for (int index = 0; index < customerCount; index++) {
			customers[index].applyInterest();
		}
	}
}
