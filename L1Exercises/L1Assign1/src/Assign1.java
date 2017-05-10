/**  This program prompts user to enter 3 numbers which is the height, length and width of one room,
 *   then displays the amount of cans and the number of cans which are used to paint the room.
  *  Author:   Zhe Huang
  *  Lab teacher: Kumari Gurusamiy
  *  Section: CST8110_300 
  *  Assignment #1
  */
import java.util.Scanner;
import java.text.*;


public class Assign1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the height, length and width in metres of this room:");
		
		Scanner input = new Scanner (System.in);
	    float height=input.nextFloat();
	    float length=input.nextFloat();
	    float width=input.nextFloat();
	    
	    float area;
        float amountCans=0.0f;
        int cans=0;
        int window=2*4;
        int door=2*1;
	    
	    if (height<=0 || length<=0 || width<=0)
	    {
	    	System.out.println("Invalid message");
	    }
	    else
	    {
	    // Calculate the area of the room
	        area=2*length*height+2*width*height-window-door;
	        
	    // Calculate the amount of cans
	        amountCans=area/50;
	       
	        DecimalFormat form=new DecimalFormat();
	        form.applyPattern("#0.00");
	        
	        System.out.print("You need "+form.format(amountCans)+" cans of paint "); 
	        
	    // Calculate the number of cans
	        if ((amountCans-(int)amountCans)==0)
	        	cans= (int)amountCans;
	        else
	        	cans=(int)amountCans+1;
	        System.out.println("so you should buy "+cans+" cans");  
	    }
	    input.close();
	    
	} //end of main
	
} //end of class