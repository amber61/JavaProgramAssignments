package network;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Implement Shannon's Text View.
 * 
 * @author Zhe Huang
 * @version 1.0.0 Date March 16, 2016
 * @see java.awt.BorderLayout
 * @see java.awt.GridLayout
 * @see java.awt.event.ActionEvent
 * @see java.awt.event.ActionListener
 * @see java.util.Observer
 * @see java.util.Observable
 * @see javax.swing.JLabel
 * @see javax.swing.JOptionPane
 * @see javax.swing.JPanel
 * @see javax.swing.JTextField
 * @since 1.8.0_73
 */
public class ShannonsTextPanel extends JPanel implements Observer {

	/**
	 * Field to access ShannonsController
	 */
	private ShannonsController controller;

	/**
	 * Field to access a JTextField
	 */
	private JTextField maxDataRateJTextField;

	/**
	 * Field to access a JTextField
	 */
	private JTextField bandwidthJTextField;

	/**
	 * Field to access a JTextField
	 */
	private JTextField signalToNoiseJTextField;

	/**
	 * Constructor.
	 * 
	 * @param controller
	 *            object to access ShannonsController
	 */
	public ShannonsTextPanel(ShannonsController controller) {
		this.controller = controller;
		maxDataRateJTextField = new JTextField();
		bandwidthJTextField = new JTextField();
		signalToNoiseJTextField = new JTextField();
		maxDataRateJTextField.setEditable(false);

		configureEvents(); // handle the event after Enter
		assembleUserInterface(); // draw the user interface
	}

	/**
	 * Update the text view
	 * 
	 * @param o
	 *            object to access Observable
	 * @param arg
	 *            object to access Object
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ShannonsModel) {
			ShannonsModel model = (ShannonsModel) o;
			bandwidthJTextField.setText(Double.toString(model.getBandwidth()));
			signalToNoiseJTextField
					.setText(Double.toString(model.getSignalToNoise()));
			maxDataRateJTextField
					.setText(Double.toString(model.getMaximumDataRate()));
		}
	}

	/**
	 * Draw the user interface
	 */
	private void assembleUserInterface() {
		JPanel labelsJPanel = new JPanel(new GridLayout(3, 1));
		labelsJPanel.add(new JLabel("Bandwidth(herz)"));
		labelsJPanel.add(new JLabel("Signal to Noise(db)"));
		labelsJPanel.add(new JLabel("Maximum Data Rate(bps)")); // Label Panel

		JPanel fieldsJPanel = new JPanel(new GridLayout(3, 1));
		fieldsJPanel.add(bandwidthJTextField);
		fieldsJPanel.add(signalToNoiseJTextField);
		fieldsJPanel.add(maxDataRateJTextField); // Fields Panel

		this.setLayout(new BorderLayout());
		this.add(labelsJPanel, BorderLayout.WEST);
		this.add(fieldsJPanel, BorderLayout.CENTER);

	}

	/**
	 * Configure events after click or Enter
	 */
	private void configureEvents() {
		bandwidthJTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.setBandwidth(
							Double.parseDouble(bandwidthJTextField.getText()));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(ShannonsTextPanel.this,
							"Enter only numbers for bandwidth", "input error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		signalToNoiseJTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.setSignalToNoise(Double
							.parseDouble(signalToNoiseJTextField.getText()));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(ShannonsTextPanel.this,
							"Enter only numbers for signal to noise",
							"input error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
