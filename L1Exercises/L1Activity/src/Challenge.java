/* Challenge class
 *   
 * Author:   ZHE HUANG
 * Section: 15W_CST8110_300
 * Purpose:  using a key to encrypt a plain text, then decrypt the original text
 */


import java.util.Scanner;
public class Challenge {
	private int key;
	private String plain;
	private char[] cipher;
	private char[] original;
	
	public Challenge() {
		key=0;
		plain=new String();
	}//constructor
	
	public void getPlainTextFromUsers() {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the plain text: ");
		plain=input.nextLine();
		cipher=new char[plain.length()];
	}//input plain text
	
	public void getKeyValueFromUsers() {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the value of key: ");
		key=input.nextInt();
	}//input the value of key
	
	public void encryption() {
		int i=0;
		int j=0;
		int k=0;
		
		for(k=1;k<=key;k++) {
			for(i=k-1;i<plain.length();i=i+key) {
				cipher[j]=plain.charAt(i);
				j++;
			}
		}
	}//encryption the plain text
	
	public void decryption() {
		int i=0;
		int j=0;
		int k=0;
		original=new char[cipher.length];
		
		for(k=1;k<=key;k++) {
			for(j=k-1;j<cipher.length;j=j+key) {
				original[j]=cipher[i];
				i++;
			}
		}
	}//decryption the cipher text
	
	public void displayEncryption() {
		System.out.print("The cipher text is: ");
		for(int n=0; n<plain.length();n++)
			System.out.print(cipher[n]);
		System.out.print("\n");
	}//display the cipher text
	
	public void displayDecryption() {
		System.out.print("The original text is: ");
		for(int n=0; n<original.length;n++)
			System.out.print(original[n]);
	}//display the decryption 	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Challenge encry = new Challenge();
		
		encry.getPlainTextFromUsers();
		encry.getKeyValueFromUsers();
		encry.encryption();
		encry.displayEncryption();
		encry.decryption();
		encry.displayDecryption();
	}

}
