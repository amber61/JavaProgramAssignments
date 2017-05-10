import java.util.Scanner;
public class ArrayLab7 {
	private int[] numUpper;
	private int[] numLower;
	private char[] upperLetter={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private char[] lowerLetter={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private String plain;
	private int numOther;
	private int sumLowerLetter;
	private int sumUpperLetter;
	
	public ArrayLab7() {
		numUpper=new int[26];
		numLower=new int[26];
		plain= new String();
		numOther=0;
		sumLowerLetter=0;
		sumUpperLetter=0;
	}
	
	public void inputPlainFromUser() {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the phrase : ");
		plain=input.nextLine();
	}
	
	public void countLowerNum() {
		for(int k=0; k<plain.length();k++){
			for(int i=0; i<lowerLetter.length;i++) {
				if(plain.charAt(k)==lowerLetter[i])
					numLower[i]++;
			}	
		}
	}
	
	public void countUpperNum() {
		for(int k=0; k<plain.length();k++){
			for(int i=0; i<upperLetter.length;i++) {
				if(plain.charAt(k)==upperLetter[i])
					numUpper[i]++;
			}	
		}
	}
	
	public void displayLowerLetter() {
		for (int j=0;j<numLower.length;j++) {
			if(numLower[j]!=0)
				System.out.println("Number of "+lowerLetter[j]+" :"+numLower[j]);
		}
	}
	
	public void displayUpperLetter() {
		for (int j=0;j<numUpper.length;j++) {
			if(numUpper[j]!=0)
				System.out.println("Number of "+upperLetter[j]+" :"+numUpper[j]);
		}
	}
		
	public void displayTotalNum() {
		System.out.println("The total number of letters is "+plain.length()+"\n");
	}

	public void displayLowerNum() {
		for(int n=0;n<26;n++)
			sumLowerLetter+=numLower[n];
		System.out.println("The number of lower case letters is "+sumLowerLetter);
	}
	
	public void displayUpperNum() {
		for(int m=0;m<numLower.length;m++)
			sumUpperLetter+=numUpper[m];
		System.out.println("\nThe number of Upper case letters is "+sumUpperLetter);
	}
	
	public void displayOtherNum() {
		System.out.println("The number of other letters is "+(plain.length()-sumUpperLetter-sumLowerLetter));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayLab7 lab = new ArrayLab7();
		
		lab.inputPlainFromUser();
		lab.countLowerNum();
		lab.countUpperNum();
		lab.displayTotalNum();
		lab.displayLowerLetter();
		lab.displayUpperLetter();
		lab.displayUpperNum();
		lab.displayLowerNum();
		lab.displayOtherNum();
	}

}
