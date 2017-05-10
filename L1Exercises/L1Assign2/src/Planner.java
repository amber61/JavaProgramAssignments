/* Planner class
 * 
 * Assignment #4  
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Lab teacher: Kumari Gurusamiy
 * 
 * Purpose:  this class handle an array of Events.
 * Data fields: activities: Event - the date,time and description of the event
 *              numEvents: int - the number of array activities
 *              maxEvents: int - length of the array activities
 * Methods: default constructor
 *          addEvent(): add activities into array
 *          displayOneDate(): display activities of one specific day
 *          displayOneWeek(): display activities of one week from a specific day
 *          delete(OurDate,OurTime) - delete the activities for specific date and time
 */
public class Planner {

	private Event[] activities;
	private int numEvents;
	private int maxEvents;
	
	public Planner() {
		numEvents=0;
		maxEvents=1000;
		activities=new Event[maxEvents];
		for (int i=0;i<1000;i++) {
			activities[i]=new Event();
		}
	}
	
	public void addEvent() {
	    if(numEvents==maxEvents) {
			System.out.println("Error...no more room to add events.");	
        }
		else {
			activities[numEvents].getDateFromUser();
			System.out.print("\n");
			activities[numEvents].getTimeFromUser();
			activities[numEvents].getDescriptionFromUser();
		}
        
        boolean isFound=false;
        int count=0;
        
        while (count<numEvents) {
        	if(activities[numEvents].isEqualDate(activities[count].getDate()) && 
        			activities[numEvents].isEqualTime(activities[count].getTime())) {
        		isFound=true;
        	    break;
        	}
        	count++;
        }
        if (isFound==true) {
            	System.out.println("You already have an activity for that date and time...cannot be entered.");
                activities[numEvents]=null;//remove just added event
        }
        else {
        	numEvents++;	
		}
	}//end of method addEvent
	
	public void displayOneDate(OurDate dateOne) {
		System.out.println("Enter date to display");
		dateOne.getMonthFromUser();
		dateOne.getDayFromUser();
		dateOne.getYearFromUser();
		dateOne.checkDMY();
		
		boolean isFound=false;
		for(int count=0;count<=numEvents;count++) {
			if(activities[count].isEqualDate(dateOne)) {
				System.out.print("Your activities for ");
				dateOne.displayDate();
				System.out.println(" are:");
				System.out.print("     ");
				activities[count].display();
		        System.out.print(" "+activities[count].getDescription()+"\n");
		        isFound=true;
			}
		}

		if(isFound==false){
			System.out.println("No activities for this date.");	
		}

	}//end of method displayOne Date
	
	public void displayOneWeek(OurDate dateWeek) {
		System.out.println("Enter date to start display from: ");
		dateWeek.getMonthFromUser();
		dateWeek.getDayFromUser();
		dateWeek.getYearFromUser();
		dateWeek.checkDMY();
		
		System.out.print("Your activities for the week starting ");
		dateWeek.displayDate();
		System.out.println(" are:");
		
		for(int count=0;count<=numEvents;count++) {
			if(activities[count].isEqualDate(dateWeek)) {
				System.out.print("Your activities for ");
				dateWeek.displayDate();
				System.out.println(" are:");
				System.out.print("     ");
				dateWeek.displayDate();
				System.out.print(" ");
				activities[count].getTime().displayTime();
		        System.out.print(" "+activities[count].getDescription()+"\n");
			}
		}
		
		for(int i=1;i<7;i++) {
			dateWeek.addOne();
			boolean isFound=false;	
			for(int count=0;count<=numEvents;count++) {
				if(activities[count].isEqualDate(dateWeek)) {
					System.out.print("Your activities for ");
					dateWeek.displayDate();
					System.out.println(" are:");
					System.out.print("     ");
					dateWeek.displayDate();
					System.out.print(" ");
					activities[count].getTime().displayTime();
			        System.out.print(" "+activities[count].getDescription()+"\n");
			        isFound=true;
			        break;
				}
		    }
			if(isFound==false) {
				System.out.print("Your activities for ");
				dateWeek.displayDate();
				System.out.println(" are:\n");
			}			
		}
	}//end of method display one week activities
	
	public void delete(OurDate delDate,OurTime delTime) {
		System.out.println("Enter date and time to delete:");
		delDate.getMonthFromUser();
		delDate.getDayFromUser();
		delDate.getYearFromUser();
		delDate.checkDMY();
		
		System.out.print("\n");
		delTime.getHoursFromUser();
		delTime.getMinutesFromUser();
		
		for(int count=0;count<=numEvents;count++) {
			if(activities[count].isEqualDate(delDate) && 
					activities[count].isEqualTime(delTime)) {
				activities[count]=activities[numEvents];
				System.out.print("The activity for ");
				delDate.displayDate();
				System.out.print(" ");
				delTime.displayTime();
				System.out.println(" has been deleted.");
			}
		}	
	}//end of method delete activities
	
}//end of planner class