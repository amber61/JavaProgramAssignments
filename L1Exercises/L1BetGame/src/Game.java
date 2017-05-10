/* Game class
 * 
 * Assignment #3  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * 
 * Purpose:  this class will represent the game.
 * Data fields: potAmount: int - the current pot
 *              betAmount: int - the bet amount in each game
 *              description: String - a description of event
 * Methods: constructor
 *          getBetAmountFromUser() - get the bet amount before each game
 *          playGame() - the procedure of the game
 */

import java.util.Scanner;

public class Game {
	Scanner in = new Scanner(System.in);
	private int potAmount;
	private int betAmount;
	
	public Game() {
		potAmount=50;
		betAmount=0;
	} //constructor
	
	public void getBetAmountFromUser() {
		System.out.print("Enter your bet amount: ");
		betAmount=in.nextInt();
	} //end of getBetAmountFromUser
	
	public void playGame() {
		
		Die dice1 = new Die();
		Die dice2 = new Die();
		Die dice3 = new Die();
		
		while(potAmount>=0) {
			System.out.println("\nYour current pot is "+potAmount);
			
			getBetAmountFromUser();// get betAmount
			while(betAmount<0 || betAmount>potAmount) {
				System.out.print("Error - cannot bet less than 0 or more than "+potAmount+"....Enter your bet amount: ");
				betAmount=in.nextInt();
				} // betAmount should be include in range from 0 to potAmount
			if(betAmount==0) {
				System.out.println("You end the game with pot of "+potAmount);
				break;
		} // That betAmount is 0 means quit the game
			
			potAmount-=betAmount;
		
		dice1.rollDie();
		dice2.rollDie();
		dice3.rollDie();	
			
		dice1.getValue();
		dice2.getValue();
		dice3.getValue();
		
		System.out.print("Your die are: ");
		dice1.displayDie();
		System.out.print(" and ");
		dice2.displayDie();
		System.out.print(" and ");
		dice3.displayDie();
		
		if(dice1.getValue()==dice2.getValue() && dice2.getValue()==dice3.getValue()) {
			potAmount+=3*betAmount;
			System.out.println("\nYou WIN....triple your bet\n");
		}
		else if(dice1.getValue()==dice2.getValue()||dice2.getValue()==dice3.getValue()||dice1.getValue()==dice3.getValue()) {
			potAmount+=2*betAmount;
			System.out.println("\nYou WIN....double your bet\n");
		}
		else if((dice1.getValue()+dice2.getValue()+dice3.getValue())>12) {
			potAmount+=betAmount;
			System.out.println("\nYou WIN....your bet back\n");
		}
		else {
			System.out.println("\nYou LOSE....your bet\n");
		}	
		
		if(potAmount==0) {
			System.out.println("You end the game with pot of "+potAmount);
			break;
		}
			
	   }//end of loop while
	}//end of playGame
}//end of class Game


