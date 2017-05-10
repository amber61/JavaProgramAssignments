/* OurDate class
 * 
 * Assignment #4  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * 
 * Purpose:  this class models a date.
 * Data fields: day: int - values of 1-31
 *              month: int - values 1-12 for January - December
 *              year: int - value for year
 * Methods: default constructor
 *          initial constructors
 *          getDay: int - return day value
 *          getMonth: int - returns month value
 *          getYear: int - returns year value
 *          getDayFromUser () - sets day from user input (Scanner)
 *          getMonthFromUser () - sets month from user input (Scanner)
 *          getYearFromUser () - sets year from user input (Scanner)
 *          checkDMY()-check whether year,month and day is valid for commonsense
 *          displayDate() - displays a date in yy/mm/dd format
 *          calcDays (): int - returns calculated number of days
 *          addOne()-add one day on a given day
 */

import java.util.Scanner;

public class OurDate {
	Scanner keyboard = new Scanner (System.in);
	private int month;
	private int day;
	private int year;

	public OurDate() {
		month = 1;
		day = 1;
		year = 1901;
	} //default constructor

	public OurDate (int m, int d,int y) {
		month = m;
		day = d;
		year = y;	
	} //initial constructors

	public int getDay() {
		return day;
	} //return day value
	
	public int getMonth() {
		return month;
	} //return month value
	
	public int getYear() {
		return year;
	} //return year value
	
	public void getDayFromUser() {
		System.out.print("Enter day: ");
        day = keyboard.nextInt();
        if(month==2) {
			while(day<0 || day>29) {
				System.out.println("Error in input day. re-enter");
				System.out.print("Enter day: ");
				day=keyboard.nextInt();
			}
	    }
		else if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
			while(day<0 || day>31) {
				System.out.println("Error in input day. re-enter");
				System.out.print("Enter day: ");
				day=keyboard.nextInt();
			}
		}
		else{
			while(day<0 || day>30) {
				System.out.println("Error in input day. re-enter");
				System.out.print("Enter day: ");
				day=keyboard.nextInt();
			}
		}
	}// end setDayFromUser: because the program requires invoke month input first,
//	limit input numbers of day according to the month
	
	public void getMonthFromUser() {
	   do{
		   System.out.print("\nEnter month: ");
		   month = keyboard.nextInt();
		   if(month<1 || month>12)
			   System.out.println("Error in input month. re-enter");
	   }while(month<1 || month>12);
	}// end setMonthFromUser

	public void getYearFromUser() {
		   do{
			   System.out.print("Enter year: ");
			   year = keyboard.nextInt();
			   if(year<0)
				   System.out.println("Error in input year. re-enter");
		   }while(year<=0);
	}// end setYearFromUser
	
	public void checkDMY() {
		if(!(year%4==0 && year%100!=0 || year%400==0) && month==2 && day==29) {
				do {
					System.out.println("Error in input day. re-enter");
					System.out.print("Enter day: ");
					day=keyboard.nextInt();
				} while(day<0 && day>28);	
		}
	}// because the program requires invoke input year last, and we did not know whether is leap year,
//	we cannot limit days of February. this method is used to check this error after get the year
		
	public void displayDate() {
		System.out.print(year+"/"+month+"/"+day);
	}// end of display
	
	public int calcDays() {
		int leapDays=0;
		int nonLeapDays=0;
		int monthDays=0;
		for(int n=1;n<year;n++){
			if(n%4==0 && n%100!=0 || n%400==0) {
				leapDays+=366;
			}
			else nonLeapDays+=365;
		}
		int yearDays=leapDays+nonLeapDays;
		
		if(month==1) monthDays=0;
		else if(month==2) monthDays=31;
		else {
			if(year%4==0 && year%100!=0 || year%400==0) {
				if(month==3) monthDays=31+29;
				else if(month==4) monthDays=31+29+31;
				else if(month==5) monthDays=31+29+31+30;
				else if(month==6) monthDays=31+29+31+30+31;
				else if(month==7) monthDays=31+29+31+30+31+30;
				else if(month==8) monthDays=31+29+31+30+31+30+31;
				else if(month==9) monthDays=31+29+31+30+31+30+31+31;
				else if(month==10) monthDays=31+29+31+30+31+30+31+31+30;
				else if(month==11) monthDays=31+29+31+30+31+30+31+31+30+31;
				else if(month==12) monthDays=31+29+31+30+31+30+31+31+30+31+30;
				}
			else {
				if(month==3) monthDays=31+28;
				else if(month==4) monthDays=31+28+31;
				else if(month==5) monthDays=31+28+31+30;
				else if(month==6) monthDays=31+28+31+30+31;
				else if(month==7) monthDays=31+28+31+30+31+30;
				else if(month==8) monthDays=31+28+31+30+31+30+31;
				else if(month==9) monthDays=31+28+31+30+31+30+31+31;
				else if(month==10) monthDays=31+28+31+30+31+30+31+31+30;
				else if(month==11) monthDays=31+28+31+30+31+30+31+31+30+31;
				else if(month==12) monthDays=31+28+31+30+31+30+31+31+30+31+30;
				}
			}
		return yearDays+monthDays+day;
		
	} //end of calcDays
	
	public void addOne() {
	    if(month==2) {
			if(year%4==0 && year%100!=0 || year%400==0) {
				if(day>=1 && day<=28)
					day+=1;
				else {month+=1; day=1;}
			}
			else{
				if(day>=1 && day<=27)
					day+=1;
				else {month+=1; day=1;}
			}
		}
		else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10) {
			if(day>=1 && day<=30) 
				day=day+1;
	        else {month+=1;day=1;}
		}
		else if(month==4 || month==6 || month==9 || month==11){
			if(day>=1 && day<=29) 
				day+=1;
			else {month=1; day=1;}
		}
		else {
			if(day>=1 && day<=30)
				day+=1;
			else {year+=1;month=1;day=1;}
		}
	}//end of addOne

}// end of class OurDate
