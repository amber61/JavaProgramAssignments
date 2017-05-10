/* Die class
 * 
 * Assignment #3  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * 
 * Purpose:  this class will represent one die.
 * Data fields: dieValue: int - the value of a dice
 * Methods: constructor
 *          rollDie: int - generate the value of a dice using Random class
 *          getValue: int - get the value generated from the method rollDie
 *          displayDie() - display the value of a dice
 */

import java.util.Random;

public class Die {
	private int dieValue;
	
	public Die() {
		dieValue=0;
	} //constructor
	
	public int rollDie() {
		Random randomNumbers = new Random();
		dieValue=randomNumbers.nextInt(6)+1;
		return dieValue;
	} //end of rollDie
	
	public int getValue(){
		return dieValue;	
	} //end of getValue
	
	public void displayDie() {
		System.out.print(dieValue);
	} //end of displayDie

} //end of class Die
