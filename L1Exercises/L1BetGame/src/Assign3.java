/* Assign3 class
 * 
 * Assignment #3  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * Purpose:  this class will be the "driver" class, and execute the playGame() method.
 * Methods: main - to call the playGame() method to execute the game.
 */

public class Assign3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Solitaire Dice Game. Bet an amount - if you roll 12 or over, you keep your \nbet, if you roll doubles you win double your bet, if you roll triples you win triple \nyour bet, otherwise you lose your bet A bet of 0 ends the game.");
		
		Game play=new Game();	
		play.playGame();

	}
}
