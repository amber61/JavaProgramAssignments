package network;

import javax.swing.JFrame;
import java.awt.GridLayout;

/**
 * Laucher to Shannon's Theorem.
 * 
 * @author Zhe Huang
 * @version 3.0.0 Date March 16, 2016
 * @see javax.swing.JFrame
 * @see java.awt.GridLayout
 * @since 1.8.0_73
 */
public class ShannonsTheoremLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShannonsTheorem controller = new ShannonsTheorem();
		ShannonsTextPanel textView = new ShannonsTextPanel(controller);
		ShannonsSliderPanel sliderView = new ShannonsSliderPanel(controller);
		ShannonsGraphicPanel graphicView = new ShannonsGraphicPanel(); // create
																		// three
																		// views
		controller.addObserver(textView);
		controller.addObserver(sliderView);
		controller.addObserver(graphicView); // add three views as observers

		JFrame frame = new JFrame("Shannons Theorem");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 1));
		frame.getContentPane().add(textView);
		frame.getContentPane().add(sliderView);
		frame.getContentPane().add(graphicView); // add three views to frame
		frame.setVisible(true);
	}

}
