/*   solution to class exercise #5    */
import java.util.*;
public class Employee {
		private String firstName;
		private String lastName;
		private double salary;
		
		public Employee() {
			firstName = new String();
			lastName = new String();
			salary = 0.0;
		}
		
		public Employee(String first, String last, double sal) {
			firstName = first;
			lastName = last;
			salary = sal;
		}
		
		public String getFirstName() {   return firstName;   }
		public String getLastName() {   return lastName;   }
		public double getSalary() {   return salary;   }
		
		public void setFirstName(String first) {
			firstName = first;
		}
		public void setLastName(String last) {
			lastName = last;
		}
		public void setSalary(double sal) {
			salary = sal;
		}
		
		public void display() {
			System.out.println ("Name: " + firstName + " " + lastName + " Salary: " + salary);
		}
		
		
		

	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
		System.out.println ("emp1:");
		emp1.display();
		
		Employee emp2 = new Employee ("Linda", "Crane", 5000.0);
		System.out.println ("emp2:");
		emp2.display();
		
		
		emp1.setFirstName ("Sue");
		emp1.setLastName ("Smith");
		emp1.setSalary (100.0);
		System.out.println ("emp1 updated:");
		emp1.display();
		
		

	}

}
