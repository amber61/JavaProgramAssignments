import java.util.*;
public class HA8LargestErr {
	private int num1;
	private int num2;
	private int num3;
	
	public HA8LargestErr() {
		num1 = 0;
		num2 = 0;
		num3 = 0;
	}
	
	public void  getNumsFromUser() {
		Scanner input = new Scanner (System.in);
		System.out.println("Enter three numbers: ");
		num1 = input.nextInt();
		num2 = input.nextInt();
		num3 = input.nextInt();
	}
	
	public int returnLargest() {
		if (num1 >= num2 && num1 >= num3)
			return num1;
		if (num2 >= num3 && num2 >= num1)
			return num2;
		return num3;
	}

	
	public static void main(String[] args) {
		
		HA8LargestErr data = new HA8LargestErr();
		
		data.getNumsFromUser();
		System.out.println ("The largest is : " + data.returnLargest());

	}

}
