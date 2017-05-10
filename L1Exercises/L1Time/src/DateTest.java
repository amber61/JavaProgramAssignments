
public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Initial date is ");
		Date date1 = new Date();

		date1.inputMonthFromUser();
		date1.inputDayFromUser();
		date1.inputYearFromUser();
	
		date1.displayDate();
	}

}
