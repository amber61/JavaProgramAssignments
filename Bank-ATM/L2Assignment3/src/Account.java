/* File: Account.java
 * Date: 2015
 * Author: Stanley Pieda
 * Description: Sample solution Assignment 2 CST8132 (15W)
 */

/*
 * Represents a bank account, updated to be abstract
 */
public abstract class Account {
	/*
	 * account balance
	 */
	private double balance;

	/*
	 * interest rate for the account
	 */
	private double interestRate;

	/*
	 * No-parameter constructor, it sets balance to 0d, and interestRate to
	 * 0.0025 as defaults
	 */
	public Account() {
		balance = 0d;
		interestRate = 0.0025;
	}

	/*
	 * Access for balance field
	 */
	public double getBalance() {
		return balance;
	}

	/*
	 * Accessor for interest rate, added in Assignment 2
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/*
	 * Attempts to add the provided amount to the balance field, ensures that
	 * negative amount values are blocked. Returns a reference to a
	 * TransactionResult to indicate if the operation succeeded or failed and to
	 * return a message suitable for the view logic
	 */
	public TransactionResult deposit(double amount) {
		if (amount <= 0) {
			return new TransactionResult(false,
					"Cannot deposit zero or negative amount");
		} else {
			this.balance += amount;
			return new TransactionResult(true,
					String.format("Deposit of %.2f made", amount));
		}
	}

	/*
	 * Attempts to add the provided amount to the balance field, ensures that
	 * negative amount values are blocked. Returns a reference to a
	 * TransactionResult to indicate if the operation succeeded or failed and to
	 * return a message suitable for the view logic
	 */
	public TransactionResult withdraw(double amount) {
		if (amount <= 0) {
			return new TransactionResult(false,
					"Cannot withdraw zero or negative amount");
		} else if (amount > balance) {
			return new TransactionResult(false,
					String.format(
							"Withrawal of %.2f too large, balance is %.2f",
							amount, balance));
		} else {
			this.balance -= amount;
			return new TransactionResult(true,
					String.format("Withdrawal of %.2f made", amount));
		}
	}

	/*
	 * Multiplies interest rate against balance and adds the result to the
	 * balance, marked abstract in Assignment 2
	 */
	public abstract void applyInterest();

	/*
	 * Returns a String representing the account.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account balance: $")
				.append(String.format("%.2f", balance));
		return builder.toString();
	}
}