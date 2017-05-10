import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {

		Numbers numbers = new Numbers();
		Scanner input = new Scanner(System.in);
		int menu;
		do {
			System.out.print(
					"Enter 1 to create array of new size, \n2 to generate random numbers into array, \n3 to count a value, \n4 to display array, \n0 to quite: ");
			menu = input.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Enter new size:");
				int numSize = input.nextInt();
				numbers = new Numbers(numSize);
				System.out.println("Array has been generated\n");
				break;
			case 2:
				numbers.generateNumbers();
				System.out.println("Numbers has been generated\n");
				break;
			case 3:
				System.out.println("Enter number to search for:");
				int numSearch = input.nextInt();
				System.out.println("There are " + numbers.count(numSearch)
						+ " of the number " + numSearch + "\n");
				break;
			case 4:
				System.out.println(
						"The numbers are: " + numbers.toString() + "\n");
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Please enter a valid menu.");
			}
		} while (true);
	}

}
