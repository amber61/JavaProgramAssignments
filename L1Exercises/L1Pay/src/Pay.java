import java.text.DecimalFormat;
import java.util.Scanner;


public class Pay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
//		define the variables
		float workHours;
		float rateOfPay;
		float basePay=0.0f;
		float overTimePay=0.0f;
		float totalPay=0.0f;
		float taxDeducted=0.0f;
		float netPay=0.0f;
		
//		input workHours
		do {
			System.out.print("Enter the number of hours worked : ");
		    workHours=in.nextFloat();
		    if (workHours<0 || workHours>60)
		    	System.out.println("The number of hours is out of range. Please re-enter(0-60): ");
		}while (workHours<0 || workHours>60);
		
//		input rateOfPay
		System.out.print("Enter the rate of pay : ");
		rateOfPay=in.nextFloat();
		while (rateOfPay<0 || rateOfPay>1500) {
			System.out.println("The number of rateOfPay is out of range. Please re-enter(0-1500): ");
			System.out.print("Enter the rate of pay: ");
			rateOfPay=in.nextFloat();
		}
		
//		calculate the basePay
		if(workHours<=37.5)
			basePay=rateOfPay*workHours;
		else basePay=rateOfPay*37.5f;
		
//		calculate the overTimePay
		if(workHours>37.5)
			overTimePay=rateOfPay*(workHours-37.5f)*1.5f;
		else overTimePay=0;
		
//		calculate the totalPay
		totalPay=basePay+overTimePay;
		
//		calculate the taxDeducted
		if (totalPay<1000)
			taxDeducted=0;
		else if (totalPay>=1000 && totalPay<=2000)
			taxDeducted=totalPay*0.2f;
		else taxDeducted=totalPay*0.3f;
		
//		calculate the netPay
		netPay=totalPay-taxDeducted;
		
//	    format the result
		DecimalFormat form=new DecimalFormat();
		form.applyPattern("#0.00");
		
//		display the results
		System.out.println("\nBase pay is $ "+form.format(basePay));
		System.out.println("Overtime pay is $ "+form.format(overTimePay));
		System.out.println("Total pay is $ "+form.format(totalPay));
		System.out.println("Tax deducted is $ "+form.format(taxDeducted));
		System.out.println("Net pay is $ "+form.format(netPay));
		
		
	}

}
