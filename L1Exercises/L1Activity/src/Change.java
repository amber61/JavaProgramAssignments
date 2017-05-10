/* Change class
 *   
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Purpose:  Challenge class for exercise bonus
 * 
 * Data fields: dimeNum: int - the number of dimes
 *              nickleNum: int - the number of nickles
 *              pennyNum: int - the number of pennies
 *              purchaseAmount: int - the value of input
 *              refund: int - the value of change
 *              
 * Methods: default constructor
 *          getPurchaseAmount() - get a numeric number of purchase amount
 *          getRefund() - get the value of change
 *          getDimeNum() - calculate the number of dimes
 *          getNickleNum() - calculate the number of nickles
 *          getPennyNum() - calculate the number of pennies
 *          displayChange() - display the number of kinds of coins
 */

import java.util.Scanner;
public class Change {
	private int dimeNum;
	private int nickleNum;
	private int pennyNum;
	private int purchaseAmount;
	private int refund;
	
	public Change() {
		dimeNum=0;
		nickleNum=0;
		pennyNum=0;
		purchaseAmount=0;
		refund=0;
	}
	
	public void getPurchaseAmount() {
		boolean isOK=false;
		String purchase;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter purchase amount: ");
//		a loop to get a valid input
		do{
			int number=0;
			purchase=input.nextLine();
			
//			judge the input String whether is a number, exclude characters or other symbols
			for(int i=0;i<purchase.length();i++){
				if(purchase.charAt(i)<'0'||purchase.charAt(i)>'9') {
					System.out.print("Invalid amount....please reenter purchase amount: ");	
					isOK=false;
					break;
				}	
				isOK=true;
			}
			
//			if the input is number, convert it to the number format
			if(isOK==true){
				for(int j=0;j<purchase.length();j++){
					number=(int)(purchase.charAt(j)-'0');
					purchaseAmount=purchaseAmount*10+number;
				}
				
//				judge the input whether is in the range from 0 to 25	
				if(purchaseAmount<=0 || purchaseAmount>25){
					System.out.print("Invalid amount....please reenter purchase amount: ");
					purchaseAmount=0;
					isOK=false;
				}
				
			}
		}while (isOK==false);
	}//end of method getPurchaseAmount
	
	public void getRefund() {
		refund=25-purchaseAmount;
	}// calculate the value of refund
	
	public void getDimeNum() {
		while(refund>=10) {
			dimeNum++;
			refund-=10;
		}		
	}// calculate the numbers of Dime 
	
	public void getNickleNum() {
		while(refund>=5) {
			nickleNum++;
			refund-=5;
		}		
	}// calculate the numbers of Nickle
	
	public void getPennyNum() {
		while(refund>=1) {
			pennyNum++;
			refund-=1;
		}		
	}// calculate the numbers of Penny
	
	public void displayChange() {
		System.out.print("Change is: "+dimeNum+" dimes "+nickleNum+" nickles "+pennyNum+" pennies.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Change pay = new Change();
		
		pay.getPurchaseAmount();
		pay.getRefund();
		pay.getDimeNum();
		pay.getNickleNum();
		pay.getPennyNum();
		pay.displayChange();

	}

}
