package mathview;

/* File: MathViewer.java
 * Course: CST8288
 * Lab Section: 301
 * Author: Zhe Huang
 * Date: Feb 2016
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import mathmodel.MathProblem;

public class MathViewer extends JFrame {

	private MathProblem problem = new MathProblem();
	private JTextField questionJTextField = new JTextField();
	private JTextField userAnswerJTextField = new JTextField();
	private JTextField feedbackJTextField = new JTextField();

	public MathViewer() {
		super("Math Practice"); // set title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		questionJTextField.setEditable(false);
		feedbackJTextField.setEditable(false);

		GridLayout grid = new GridLayout(7, 1);
		this.setLayout(grid);
		this.add(new JLabel("Question")); // row 1
		this.add(questionJTextField); // row 2
		this.add(new JLabel("Your Answer")); // row 3
		this.add(userAnswerJTextField); // row 4
		this.add(new JLabel("Feedback")); // row 5
		this.add(feedbackJTextField); // row 6

		JButton button1 = new JButton("Check Answer");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
			}
		});

		JButton button2 = new JButton("Another Question");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				anotherQuestion();
			}
		});

		JPanel buttonpanel = new JPanel(new GridLayout(1, 2));
		buttonpanel.add(button1);
		buttonpanel.add(button2);
		this.add(buttonpanel); // row 7

		this.pack();
		this.setVisible(true);
		setLocationRelativeTo(null);
		questionJTextField.setText(problem.getQuestionText());
	}

	private void checkAnswer() {
		try {
			if (problem != null) {
				problem.setUserAnswer(
						Integer.parseInt(userAnswerJTextField.getText()));
				feedbackJTextField
						.setText(problem.getQuestionTextWithFeedback());
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
					"Please enter an integer number",
					"incorrect format for entry", JOptionPane.WARNING_MESSAGE);
			userAnswerJTextField.requestFocusInWindow();
			userAnswerJTextField.selectAll();
		}
	}

	private void anotherQuestion() {
		feedbackJTextField.setText("");
		problem = new MathProblem();
		questionJTextField.setText(problem.getQuestionText());
		userAnswerJTextField.setText("");
	}

}
