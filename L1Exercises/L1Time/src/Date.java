import java.util.*;
/*    OurDate class
      Author:   ZHE HUANG
	  Purpose:  this class models a Date in month/day/year
*/

public class Date {
	private int month;
	private int day;
	private int year;

	public Date() {
		month = 1;
		day = 1;
		year = 1901;
		System.out.println(month+"/"+day+"/"+year);
	}

	public Date (int m, int d,int y) {
		month = m;
		day = d;
		year = y;	
	}

	public void inputMonthFromUser( ) {
	   Scanner keyboard = new Scanner (System.in);
	   System.out.print("Enter a month: ");
	   month = keyboard.nextInt();
	}// end inputMonth

	public void inputDayFromUser( ) {
		Scanner keyboard = new Scanner (System.in);
		System.out.print("Enter a day: ");
		day = keyboard.nextInt();
	}// end inputDay

	public void inputYearFromUser( ) {
		   Scanner keyboard = new Scanner (System.in);
		   System.out.print("Enter a year: ");
		   year = keyboard.nextInt();
		 }// end inputYear
	
	public void displayDate() {
		System.out.print("Date is "+month+"/"+day+"/"+year);
	}// end of display

}// end of class Time
