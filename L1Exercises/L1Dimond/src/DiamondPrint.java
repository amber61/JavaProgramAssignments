import java.util.Scanner;

public class DiamondPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//input the number of rows
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an odd number in the range 1 to 19 that represents the number of row: ");
		int numberOfRow=in.nextInt();
		//judge the number whether is an odd number which is in the range of 1 to 19
		while(numberOfRow<1 || numberOfRow>19 || numberOfRow%2==0){
			System.out.println("the number is out of range.");
			System.out.print("Enter an odd number in the range 1 to 19 that represents the number of row: ");
			numberOfRow=in.nextInt();
		}		
	    //draw the upper part of diamond
		for(int i=1;i<=(numberOfRow+1)/2;i++) {
			for(int j=(numberOfRow-1)/2;j>i-1;j--)
				System.out.print(" ");
			for(int k=1;k<2*i;k++)
			    System.out.print("*");
			System.out.print("\n");
		}
		//draw the bottom part
		for(int l=1;l<=(numberOfRow-1)/2;l++){
			for(int m=1;m<=l;m++)
				System.out.print(" ");
			for(int n=numberOfRow-2;n>2*l-2;n--)
				System.out.print("*");
			System.out.print("\n");		
		}
		
	}

}
