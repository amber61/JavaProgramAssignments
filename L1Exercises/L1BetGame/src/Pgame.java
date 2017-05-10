import java.util.Scanner;
import java.util.Random;

public class Pgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Random randomNumbers = new Random();
		Scanner in = new Scanner(System.in);
		int currentPot=50;
		int eachBet;
		
		System.out.println("Welcome to Solitaire Dice Game. Bet an amount - if you roll 12 or over, you keep your \nbet, if you roll doubles you win double your bet, if you roll triples you win triple \nyour bet, otherwise you lose your bet A bet of 0 ends the game.");
   
		while (currentPot>0)
		{
			System.out.println("\nYour current pot is "+currentPot);
			System.out.print("Enter your bet amount: ");
			eachBet=in.nextInt();
			
			while(eachBet<0 || eachBet>currentPot) {
				System.out.println("Error - cannot bet less than 0 or more than "+currentPot+"....Enter your bet amount: ");
				eachBet=in.nextInt();
			} // eachBet should be include in range from 0 to currentPot
			
			if(eachBet==0) {
				System.out.println("You end the game with pot of "+currentPot);
				break;
				} // That eachBet is 0 means quit the game
			
			else {
				// generate and display values of each dice
				int dieValue1=randomNumbers.nextInt(6);
				int dieValue2=randomNumbers.nextInt(6);
				int dieValue3=randomNumbers.nextInt(6);
				System.out.println("Your die are: "+dieValue1+" and "+dieValue2+" and "+dieValue3);
				
				// judge the result of game and get the value of currentPot after each game
				if(dieValue1==dieValue2 && dieValue2==dieValue3) {
					currentPot+=3*eachBet;
					System.out.println("You WIN....triple your bet\n");
				}
				else if(dieValue1==dieValue2 || dieValue2==dieValue3 || dieValue1==dieValue3) {
					currentPot+=2*eachBet;
					System.out.println("You WIN....double your bet\n");
				}
				else if((dieValue1+dieValue2+dieValue3)>12) {
					currentPot+=eachBet;
					System.out.println("You WIN....your bet back\n");
				}
				else {
					currentPot-=eachBet;
					System.out.println("You LOSE....your bet\n");
				}
				
			// That the value of currentPot is less or equal to 0 means quit the game
			if (currentPot<=0)
				break;
			}			
		} //end of while-loop
		
	} //end of main

}//end of class
