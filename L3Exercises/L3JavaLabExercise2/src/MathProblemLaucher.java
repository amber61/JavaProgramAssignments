import java.util.Scanner;

public class MathProblemLaucher {

	public static void main(String[] args) {
		MathProblem problem = new MathProblem();
		Scanner input = new Scanner(System.in);

		System.out.println(problem.getQuestionText());
		problem.setUserAnswer(input.nextInt());

		System.out.println(problem.getQuestionTextWithFeedback());
	}
}
