/* File: ChequingAccount.java
 * Date: 2015
 * Author: Stanley Pieda
 * Description: Sample solution Assignment 2 CST8132 (15W)
 */

/*
 * Represents a bank chequing account
 */
public class ChequingAccount extends Account {

	/*
	 * Overrides applyInterest to provide concrete implementation
	 */
	@Override
	public void applyInterest() {
		deposit(getBalance() * getInterestRate());
	}

	/*
	 * Overrides toString() to append "Chequing " to the beginning of the
	 * generated String from superclass toString
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chequing ").append(super.toString());
		return builder.toString();
	}
}
