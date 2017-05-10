import java.util.Scanner;
public class Lab7 {
	private char[][] numUpper;
	private char[][] numLower;
	private String plain;
	private int numOther;
	private int numLowerLetter;
	private int numUpperLetter;
	
	public Lab7() {
		numUpper=new char[26][2];
		numLower=new char[26][2];
     	plain= new String();
		numOther=0;
		numLowerLetter=0;
		numUpperLetter=0;
	}
	
	public void inputPlainFromUser() {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the phrase : ");
		plain=input.nextLine();
	}
	
	public void countNum() {
		for(int k=0; k<plain.length();k++){
			char s=plain.charAt(k);
			switch(s) {
			case 'a': numLower[0][0]='a';numLower[0][1]++;break;
			case 'b': numLower[1][0]='b';numLower[1][1]++;break;
			case 'c': numLower[2][0]='c';numLower[2][1]++;break;
			case 'd': numLower[3][0]='d';numLower[3][1]++;break;
			case 'e': numLower[4][0]='e';numLower[4][1]++;break;
			case 'f': numLower[5][0]='f';numLower[5][1]++;break;
			case 'g': numLower[6][0]='g';numLower[6][1]++;break;
			case 'h': numLower[7][0]='h';numLower[7][1]++;break;
			case 'i': numLower[8][0]='i';numLower[8][1]++;break;
			case 'j': numLower[9][0]='j';numLower[9][1]++;break;
			case 'k': numLower[10][0]='k';numLower[10][1]++;break;
			case 'l': numLower[11][0]='l';numLower[11][1]++;break;
			case 'm': numLower[12][0]='m';numLower[12][1]++;break;
			case 'n': numLower[13][0]='n';numLower[13][1]++;break;
			case 'o': numLower[14][0]='o';numLower[14][1]++;break;
			case 'p': numLower[15][0]='p';numLower[15][1]++;break;
			case 'q': numLower[16][0]='q';numLower[16][1]++;break;
			case 'r': numLower[17][0]='r';numLower[17][1]++;break;
			case 's': numLower[18][0]='s';numLower[18][1]++;break;
			case 't': numLower[19][0]='t';numLower[19][1]++;break;
			case 'u': numLower[20][0]='u';numLower[20][1]++;break;
			case 'v': numLower[21][0]='v';numLower[21][1]++;break;
			case 'w': numLower[22][0]='w';numLower[22][1]++;break;
			case 'x': numLower[23][0]='x';numLower[23][1]++;break;
			case 'y': numLower[24][0]='y';numLower[24][1]++;break;
			case 'z': numLower[25][0]='z';numLower[25][1]++;break;
			case 'A': numUpper[0][0]='A';numUpper[0][1]++;break;
			case 'B': numUpper[1][0]='B';numUpper[1][1]++;break;
			case 'C': numUpper[2][0]='C';numUpper[2][1]++;break;
			case 'D': numUpper[3][0]='D';numUpper[3][1]++;break;
			case 'E': numUpper[4][0]='E';numUpper[4][1]++;break;
			case 'F': numUpper[5][0]='F';numUpper[5][1]++;break;
			case 'G': numUpper[6][0]='G';numUpper[6][1]++;break;
			case 'H': numUpper[7][0]='H';numUpper[7][1]++;break;
			case 'I': numUpper[8][0]='I';numUpper[8][1]++;break;
			case 'J': numUpper[9][0]='J';numUpper[9][1]++;break;
			case 'K': numUpper[10][0]='K';numUpper[10][1]++;break;
			case 'L': numUpper[11][0]='L';numUpper[11][1]++;break;
			case 'M': numUpper[12][0]='M';numUpper[12][1]++;break;
			case 'N': numUpper[13][0]='N';numUpper[13][1]++;break;
			case 'O': numUpper[14][0]='O';numUpper[14][1]++;break;
			case 'P': numUpper[15][0]='P';numUpper[15][1]++;break;
			case 'Q': numUpper[16][0]='Q';numUpper[16][1]++;break;
			case 'R': numUpper[17][0]='R';numUpper[17][1]++;break;
			case 'S': numUpper[18][0]='S';numUpper[18][1]++;break;
			case 'T': numUpper[19][0]='T';numUpper[19][1]++;break;
			case 'U': numUpper[20][0]='U';numUpper[20][1]++;break;
			case 'V': numUpper[21][0]='V';numUpper[21][1]++;break;
			case 'W': numUpper[22][0]='W';numUpper[22][1]++;break;
			case 'X': numUpper[23][0]='X';numUpper[23][1]++;break;
			case 'Y': numUpper[24][0]='Y';numUpper[24][1]++;break;
			case 'Z': numUpper[25][0]='Z';numUpper[25][1]++;break;
			default:break;
			}
		}
	}
		
	public void displayTotalNum() {
		System.out.println("The total number of letters is "+plain.length()+"\n");
	}
	
	public void displayDetailLower() {
		for(int i=0;i<26;i++) {
			if(numLower[i][1]!=0)
			System.out.println("Number of "+numLower[i][0]+": "+(int)numLower[i][1]);
		}
	}
	
	public void displayDetailUpper() {
		for(int j=0;j<26;j++) {
			if(numUpper[j][1]!=0)
			System.out.println("Number of "+numUpper[j][0]+": "+(int)numUpper[j][1]);
		}
	}
	
	public void displayLowerNum() {
		for(int n=0;n<26;n++)
			numLowerLetter+=numLower[n][1];
		System.out.println("The number of lower case letters is "+numLowerLetter);
	}
	
	public void displayUpperNum() {
		for(int m=0;m<numLower.length;m++)
			numUpperLetter+=numUpper[m][1];
		System.out.println("\nThe number of Upper case letters is "+numUpperLetter);
	}
	
	public void displayOtherNum() {
		System.out.println("The number of other letters is "+(plain.length()-numUpperLetter-numLowerLetter));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lab7 lab = new Lab7();
		
		lab.inputPlainFromUser();
		lab.countNum();
		lab.displayTotalNum();
		lab.displayDetailLower();
		lab.displayDetailUpper();
		lab.displayUpperNum();
		lab.displayLowerNum();
		lab.displayOtherNum();
	}

}
