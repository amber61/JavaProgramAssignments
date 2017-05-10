/* Assign4 class
 * 
 * Assignment #4  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * 
 * Purpose:  this class which contains the menu for the program
 * 
 * Method: main - to call the four methods in Planner class to achieve the purpose
 */

import java.util.Scanner;
public class Assign4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choice;
		boolean isOK=false;
		
		Scanner input=new Scanner(System.in);
		Planner plan=new Planner();

		do {
			System.out.print("Enter 1 to add an activity to planner; 2 to display activities for a day; 3 to display\nactivities for a week; 4 to delete an activity; 0 to quit: ");
			
//			if input other numbers or symbols,reveals the errors and asks for re-enter choice
			do{
				choice=input.nextLine();
				if(choice.length()!=1) {
					System.out.println("Our of range of choice.re-enter:\n");
				    System.out.print("Enter 1 to add an activity to planner; 2 to display activities for a day; 3 to display\nactivities for a week; 4 to delete an activity; 0 to quit: ");
				    isOK=false;
				}
				else {
					if(choice.charAt(0)<'0' || choice.charAt(0)>'4') {
						System.out.println("Our of range of choice.re-enter:\n");
						System.out.print("Enter 1 to add an activity to planner; 2 to display activities for a day; 3 to display\nactivities for a week; 4 to delete an activity; 0 to quit: ");
						isOK=false;
					}
					else
						isOK=true;
				}
			}while(isOK==false);//end of check errors in choice
					
			if (isOK==true) {
				while (choice.charAt(0)!='0') {
					if(choice.charAt(0)=='1') {
						plan.addEvent();
					    isOK=false;
					    System.out.print("\n");
					    break;
					}
					else if (choice.charAt(0)=='2') {
						OurDate dateOne=new OurDate();
						plan.displayOneDate(dateOne);
						System.out.print("\n");
						isOK=false;
						break;
					}
					else if (choice.charAt(0)=='3') {
						OurDate dateWeek=new OurDate();
						plan.displayOneWeek(dateWeek);
						System.out.print("\n");
						isOK=false;
						break;
					}
					else if (choice.charAt(0)=='4') {
						OurDate delDate=new OurDate();
						OurTime delTime=new OurTime();
						plan.delete(delDate,delTime);
						System.out.println("\n");
						isOK=false;
						break;
					}
				}
				if(choice.charAt(0)=='0')
					System.out.println("Quit the activities.");  
			}
		}while(isOK==false);	
		
	}//end of main
}//end of class
