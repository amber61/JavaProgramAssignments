import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Numbers {

	// private List<Integer> numbers = new ArrayList<>();
	private int size;
	private Integer[] numbers;

	Random random = new Random();

	public Numbers() {
		size = 2;
		numbers = new Integer[size];
	}

	public Numbers(int size) {
		this.size = size;
		numbers = new Integer[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = 0;
		}
	}

	public void generateNumbers() {
		for (int i = 0; i < size; i++) {
			numbers[i] = random.nextInt(100);
		}
	}

	public int count(int numSearch) {
		int count = 0;
		for (Integer n : numbers)
			if (n == numSearch) {
				count++;
			}
		return count;
	}

	public String toString() {
		String numString = "";
		for (Integer str : numbers) {
			numString += str + " ";
		}
		return numString;
	}

}
