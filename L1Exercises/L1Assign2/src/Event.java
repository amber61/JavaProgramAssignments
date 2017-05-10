/* Event class
 * 
 * Assignment #4  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * 
 * Purpose:  this class models an event.
 * Data fields: date: OurDate - the day/month/year of the event
 *              time: OurTime - the hour/minute that event starts at
 *              description: String - a description of event
 * Methods: default constructor
 *          getDate: OurDate - returns date of event
 *          getTime: OurTime - returns time of event
 *          getDescription: String - returns description of event
 *          getDateFromUser () - sets date from keyboard (Scanner)
 *          getTimeFromUser() - sets time from keyboard (Scanner)
 *          getDescriptionFromUser() - sets description from keyboard (Scanner)
 *          display(): displays event to
 *          displayEvent(OurDate currentDate) - displays days from parameter and date in event
 *          isEqualDate(OurDate dateToDisplay):boolean - two dates whether are the same
 *          isEqualTime(OurTime timeToDisplay):boolean - two times whether are the same
 */

import java.util.Scanner;

public class Event {
	private OurDate date;
	private OurTime time;
	private String description;
	
	public Event() {
		date=new OurDate();
		time=new OurTime();
		description=new String();
	} //default constructor
	
	public OurDate getDate() {
		return date;
	} //return date value
	
	public OurTime getTime() {
		return time;
	} //return time value
	
	public String getDescription() {
		return description;
	} //return description value
		
	public void getDateFromUser() {
		date.getMonthFromUser();
		date.getDayFromUser();
		date.getYearFromUser();
	} //end of setDateFromUser
	
	public void getTimeFromUser() {
		time.getHoursFromUser();
		time.getMinutesFromUser();
	} //end of setTimeFromUser

	public void getDescriptionFromUser() {
		Scanner keyboard = new Scanner (System.in);
		System.out.print("Enter event description: ");
		description=keyboard.nextLine();
	} //end of setDescriptionFromUser
	
	public void display() {
//		System.out.print("\nThe event is:\n");
		date.displayDate();
		System.out.print(" ");
		time.displayTime();
		System.out.print(" ");
	} // end of display
	
	public void displayEvent(OurDate currentDate) {
		int numdays = date.calcDays()-currentDate.calcDays();
		if (numdays>=0) 
			System.out.print("\nThe number of days until event is :"+numdays);
		else
			System.out.println("\nThis event has already occurred");
	} // end of displayDays
	
	public boolean isEqualDate(OurDate dateToDisplay) {
		if (date.calcDays() == dateToDisplay.calcDays())
			return true;
		else
			return false;
	}
	
	public boolean isEqualTime(OurTime timeToDisplay) {
		if (time.calcSeconds() == timeToDisplay.calcSeconds())
			return true;
		else
			return false;
	}

} //end of class Event
