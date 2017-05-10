/* Assign2 class
 * 
 * Assignment #2  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * 
 * Purpose:  this class which contains main method prompts user to keep track of events
 *           --a basic electronic planner of sorts--using the class OurDate, OurTime and Event.
 * 
 * Method: main - to call the three class (OurDate, OurTime, Event) to achieve the purpose
 */

public class Assign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter an event\n");
		System.out.println("Enter event date: ");
		
		Event eve1=new Event();
		eve1.getDateFromUser();
//	    System.out.print(eve1.getDate().getMonth());
		System.out.println("\nEnter event time: ");
		eve1.getTimeFromUser();

		eve1.getDescriptionFromUser();

		eve1.display();
		System.out.println(eve1.getDescription());
		
		System.out.println("\nEnter today's date:");
		OurDate currentDate=new OurDate();
		currentDate.getYearFromUser();
		currentDate.getMonthFromUser();
		currentDate.getDayFromUser();
		
		eve1.displayEvent(currentDate);
		
		
			
	}//end of main

}
