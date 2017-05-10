/* File: SavingAccount.java
 * Date: 2015
 * Author: Stanley Pieda
 * Description: Sample solution Assignment 2 CST8132 (15W)
 */

/*
 * Represents a bank savings account
 */
public class SavingAccount extends Account {

	/*
	 * Overrides applyInterest to use double the interest rate
	 */
	@Override
	public void applyInterest() {
		deposit(getBalance() * getInterestRate() * 2);
	}

	/*
	 * Overrides toString() to append "Saving " to the beginning of the
	 * generated String from superclass toString
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Saving ").append(super.toString());
		return builder.toString();
	}

}
