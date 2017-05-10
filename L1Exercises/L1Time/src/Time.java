import java.util.*;
/*    Time class
      Author:   Linda Crane
	Purpose:  this class models a time in hours/minutes/seconds
*/

public class Time {
	private int hours;
	private int minutes;
	private int seconds;

	public Time() {
		hours = 0;
		minutes = 0;
		seconds = 0;
	}

	public Time (int h, int m, int s) {
		hours = h;
		minutes = m;
		seconds = s;
	}

	public void inputHours( ) {
	   Scanner keyboard = new Scanner (System.in);
	   System.out.println("Enter the hours(0-23): ");
        hours = keyboard.nextInt();
	 }// end inputHours

	public void inputMinutes( ) {
	   Scanner keyboard = new Scanner (System.in);
	   System.out.println("Enter the minutes (0-59): ");
	   minutes = keyboard.nextInt();
	}// end inputMinutes

	public void inputSeconds( ) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter the seconds (0-59): ");
		seconds = keyboard.nextInt();
	}// end inputSeconds


	public void display() {
		System.out.println (hours + ":" + minutes + ":" + seconds);
	}// end of display

	public int calcTotalSeconds() {
                return ((hours*60+minutes)*60+seconds);
	}// end calcTotalSeconds


	public static void main (String [] args) {
		Time time1 = new Time();

		time1.inputHours();
		time1.inputMinutes();
		time1.inputSeconds();


		System.out.print ("\nThe time entered is  ");
		time1.display();
		System.out.print ("\nThe total time is seconds is " + time1.calcTotalSeconds());
	} // end of main

}// end of class Time
