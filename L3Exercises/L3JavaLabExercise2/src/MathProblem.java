//package practicemath;

/* File: MathProblem.java
 * Course: CST8288
 * Lab Section: All
 * Author: Stanley Pieda
 * Date: Sept 2015
 */
import java.util.Scanner;
import java.util.Random;

/**
 * Represents an addition math problem
 * 
 * @author Stan Pieda
 */
public class MathProblem {

	private AdditionMathProblem additionMathPro;

	public MathProblem() {
		additionMathPro = new AdditionMathProblem();
	}

	/**
	 * Simple getter for operand1
	 * 
	 * @return the int value stored inside operand1
	 */
	public int getOperand1() {
		return additionMathPro.getOperand1();
	}

	/**
	 * Simple setter for operand1, ignores values outside of range 1 to 100
	 * (inclusive)
	 * 
	 * @param operand1
	 *            an int value
	 */
	public void setOperand1(int operand1) {
		this.additionMathPro.setOperand1(operand1);
	}

	/**
	 * Simple getter for operand2
	 * 
	 * @return the int value stored inside operand2
	 */
	public int getOperand2() {
		return this.additionMathPro.getOperand2();
	}

	/**
	 * Simple setter for operand2, ignores values outside of range 1 to 100
	 * (inclusive)
	 * 
	 * @param operand2
	 *            an int value
	 */
	public void setOperand2(int operand2) {
		this.additionMathPro.setOperand1(operand2);
	}

	/**
	 * Returns an answer based on adding the two operand values
	 * 
	 * @return
	 */
	public int getAnswer() {
		return this.additionMathPro.getAnswer();
	}

	/**
	 * Simple getter for userAnswer
	 * 
	 * @return int value within userAnswer
	 */
	public int getUserAnswer() {
		return this.additionMathPro.getUserAnswer();
	}

	/**
	 * Simple setter for
	 * 
	 * @param userAnswer
	 */
	public void setUserAnswer(int userAnswer) {
		this.additionMathPro.setUserAnswer(userAnswer);
	}

	/**
	 * Generates and returns a user-readable math problem for addition.
	 * 
	 * @return MathProblem question
	 */
	public String getQuestionText() {
		return this.additionMathPro.getQuestionText();
	}

	/**
	 * Generates and returns a user-readable math problem for addition,
	 * including answer and feedback.
	 * 
	 * @return MathProblem question with answer and feedback
	 */
	public String getQuestionTextWithFeedback() {
		return this.additionMathPro.getQuestionTextWithFeedback();
	}
}
