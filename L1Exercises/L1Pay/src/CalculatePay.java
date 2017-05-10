import java.text.DecimalFormat;
import java.util.Scanner;


public class CalculatePay {
	private double workHours;
	private double rateOfPay;
	
	public CalculatePay() {
		workHours=0.0;
		rateOfPay=0.0;
	}
	
	public void setWorkHours() {
		Scanner in=new Scanner(System.in);
		do {
			System.out.print("Enter the number of hours worked : ");
		    workHours=in.nextFloat();
		    if (workHours<0 || workHours>60)
		    	System.out.println("The number of hours is out of range. Please re-enter(0-60): ");
		}while (workHours<0 || workHours>60);	
	}
	
	public void setRateOfPay() {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the rate of pay: ");
		rateOfPay=in.nextFloat();
		while (rateOfPay<0 || rateOfPay>1500) {
			System.out.println("The number of rateOfPay is out of range. Please re-enter(0-1500): ");
			System.out.print("Enter the rate of pay: ");
			rateOfPay=in.nextFloat();
		}		
	}
	
	public double baseOfPay() {
		if(workHours<=37.5)
			return rateOfPay*workHours;
		else 
			return rateOfPay*37.5;
	}
	
	public double overTimePay() {
		if(workHours<=37.5)
			return 0;
		else
			return 1.5*rateOfPay*(workHours-37.5);
	}
	
	public double incomeTax(double wage) {
		if (wage<1000)
			return wage*0;
		else if (wage>=1000 && wage<=2000)
			return wage*0.2;
		else return wage*0.3;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CalculatePay calPay=new CalculatePay();
		
		calPay.setWorkHours();
		calPay.setRateOfPay();
		
		DecimalFormat form=new DecimalFormat();
		form.applyPattern("#0.00");

		System.out.println("\nBase pay is $ "+form.format(calPay.baseOfPay()));
		System.out.println("Overtime pay is $ "+form.format(calPay.overTimePay()));
		
		double wage=calPay.baseOfPay()+calPay.overTimePay();
		System.out.println("Total pay is $ "+form.format(wage));
		System.out.println("Tax deducted is $ "+form.format(calPay.incomeTax(wage)));
		System.out.println("Net pay is $ "+form.format(calPay.baseOfPay()+calPay.overTimePay()-calPay.incomeTax(wage)));
	}

}