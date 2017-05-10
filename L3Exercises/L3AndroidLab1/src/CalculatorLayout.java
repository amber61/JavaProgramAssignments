
/* 
 * File Name: Lab1CalculatorLayout.java
 * Course Name: CST2335_010 Graphical Interface Programming
 * Lab	Section: 012
 * Student Name: Zhe Huang
 * Date: Monday, January 18, 2016
 */
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;

/**
 * Represents a layout of calculator
 * 
 * @author ZHE
 * @version 1.0
 * @since 1.8.0_65
 */
public class CalculatorLayout {
	/**
	 * The main container that provides title bar
	 */
	JFrame frame;

	/**
	 * Constructor. Set up JFrame with two layout managers for the calculator
	 * layout
	 */
	public CalculatorLayout() {
		// create main window with title
		frame = new JFrame("Calculator");

		JPanel myPanel = new JPanel();
		// set BorderLayout manager
		myPanel.setLayout(new BorderLayout());
		myPanel.add(new JTextField(), BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		// set GridLayout manager
		buttonPanel.setLayout(new GridLayout(4, 4));
		// add the button to the JFrame container
		buttonPanel.add(new JButton("7"));
		buttonPanel.add(new JButton("8"));
		buttonPanel.add(new JButton("9"));
		buttonPanel.add(new JButton("/"));
		buttonPanel.add(new JButton("4"));
		buttonPanel.add(new JButton("5"));
		buttonPanel.add(new JButton("6"));
		buttonPanel.add(new JButton("*"));
		buttonPanel.add(new JButton("1"));
		buttonPanel.add(new JButton("2"));
		buttonPanel.add(new JButton("3"));
		buttonPanel.add(new JButton("-"));
		buttonPanel.add(new JButton("."));
		buttonPanel.add(new JButton("0"));
		buttonPanel.add(new JButton("="));
		buttonPanel.add(new JButton("+"));
		myPanel.add(buttonPanel, BorderLayout.CENTER);

		frame.setContentPane(myPanel);
		// size the JFrame according to its contents
		frame.pack();
		// System.exit() when JFrame is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// display frame
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// create a SwingFrame, which has a JFrame
		new CalculatorLayout();
	}
}