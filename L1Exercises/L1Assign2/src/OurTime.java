/* OurTime class
 * 
 * Assignment #4  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * 
 * Purpose:  this class models a time.
 * Data fields: hours: int - values of 0-23 for 24 hour clock
 *              minutes: int - values 0-59
 *              seconds: int - values 0-59
 * Methods: default constructor
 *          initial constructors
 *          getHours: int - return hour value
 *          getMinutes: int - returns minutes value
 *          getSeconds: int - returns seconds value
 *          getHourFromUser () - sets hour from user input (Scanner)
 *          getMinutesFromUser () - sets minutes from user input (Scanner)
 *          getSecondsFromUser () - sets seconds from user input (Scanner)
 *          displayTime () - displays the time using : : format
 *          calcTotalSeconds() - returns calculated number of seconds
 */

import java.util.Scanner;

public class OurTime {
	Scanner keyboard = new Scanner (System.in);
	private int hours;
	private int minutes;
	private int seconds;

	public OurTime() {
		hours = 0;
		minutes = 0;
		seconds = 0;
	} //default constructor

	public OurTime (int h, int m, int s) {
		hours = h;
		minutes = m;
		seconds = s;
	} //initial constructors

	public int getHours() {
		return hours;
	} //return hour value
	
	public int getMinutes() {
		return minutes;
	} //return minute value
	
	public int getSeconds() {
		return seconds;
	} //return second value
	
	public void getHoursFromUser() {
	   do {
		   System.out.print("Enter hour (0-23): ");
	       hours = keyboard.nextInt();
	       if(hours<0 || hours>23)
	    	   System.out.println("Error in input hours. re-enter");
	   }while(hours<0 ||  hours>23);
	 }// end setHoursFromUser

	public void getMinutesFromUser() {
		do {
			System.out.print("Enter minutes (0-59): ");
			minutes = keyboard.nextInt();
			if(minutes<0 || minutes>59)
		    	   System.out.println("Error in input minutes. re-enter");
		   }while(minutes<0 || minutes>59);
	}// end setMinutesFromUser

	public void getSecondsFromUser() {
		do {
			System.out.print("Enter seconds (0-59): ");
			seconds = keyboard.nextInt();
			if(seconds<0 || seconds>59)
		    	   System.out.println("Error in input seconds. re-enter");
		   }while(seconds<0 || seconds>59);	
	}// end setSecondsFromUser

	public void displayTime() {
		System.out.print (hours + ":" + minutes);
	}
	
	public int calcSeconds() {
        return ((hours*60+minutes)*60+seconds);
	}// end of display

}// end of class Time
