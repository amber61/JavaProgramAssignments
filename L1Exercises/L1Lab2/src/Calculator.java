import java.util.Scanner;


public class Calculator {
		private int num1;
		private int num2;
		
		public Calculator() {
			num1=0;
			num2=0;
		} //default constructor
		
		
		public void inputNumsFromUser() {
			Scanner in=new Scanner(System.in);
			System.out.println("Enter two integer numbers:");
			num1=in.nextInt();
			num2=in.nextInt();
		} //input two fields
		
		
		public void subtracted() {
			System.out.println(num1+"-"+num2+" = "+(num1-num2));
		} //end of subtracted
		
		
		public void division() {
			if(num2==0)
				System.out.println("Invalid division....num2 is zero");
			else
				System.out.println(num1+"/"+num2+" = "+(num1/num2));
		} //end of division

}
