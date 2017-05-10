package network;

/*
 *  @(#)ShannonsTheorem.java   1.0 YY/MM/DD

 *
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 */

import javax.swing.JOptionPane;
import java.util.Observer;

/**
 * Implement Shannon's Theorem.
 * 
 * @author Zhe Huang
 * @version 3.0.0 Date March 16, 2016
 * @see java.util.Observer
 * @see javax.swing.JOptionPane
 * @since 1.8.0_73
 */
public class ShannonsTheorem implements ShannonsController {

	/**
	 * Field to access the data model
	 */
	private ShannonsModel model;

	/**
	 * Default constructor.
	 */
	public ShannonsTheorem() {
		super();
		model = new ShannonsModel();
	}

	/**
	 * Add a observer
	 * 
	 * @param observer
	 *            object to access Observer
	 */
	@Override
	public void addObserver(Observer observer) {
		model.addObserver(observer); // add observers
	}

	/**
	 * Getter for bandwidth field.
	 * 
	 * @return double
	 */
	public double getBandwidth() {
		return model.getBandwidth();
	}

	/**
	 * Setter for bandwidth
	 * 
	 * @param bandwidth
	 *            value of bandwidth
	 */
	@Override
	public void setBandwidth(double bandwidth) {
		model.setBandwidth(bandwidth);
	}

	/**
	 * Getter for signal-to-noise ratio
	 * 
	 * @return double
	 */
	public double getSignalToNoise() {
		return model.getSignalToNoise();
	}

	/**
	 * Setter for signal-to-noise
	 * 
	 * @param signalToNoise
	 *            the signal-to-noise ratio
	 */
	@Override
	public void setSignalToNoise(double signalToNoise) {
		model.setSignalToNoise(signalToNoise);
		;
	}

	/**
	 * Getter for maximum communication rate
	 * 
	 * @return double
	 */
	public double getMaximumDataRate() {
		return model.getMaximumDataRate();
	}

	/**
	 * Reveal the message.
	 * 
	 * @return String
	 */
	public String toString() {
		return model.toString();
	}

	/**
	 * Display the dialog. Entry point "main()" as required by the JVM.
	 * 
	 * @param args
	 *            Standard command line parameters (arguments) as a string
	 *            array.
	 */
	public static void main(String args[]) {
		ShannonsTheorem shannonsTheorem = new ShannonsTheorem();
		String message = new String("");
		do {
			try {
				shannonsTheorem.setBandwidth(
						Double.parseDouble(JOptionPane.showInputDialog(
								"Please enter the bandwidth (hertz) : ")));
				shannonsTheorem.setSignalToNoise(
						Double.parseDouble(JOptionPane.showInputDialog(
								"Please enter the signalToNoise (decibal) : ")));
				JOptionPane.showMessageDialog(null, "The max data rate is "
						+ shannonsTheorem.getMaximumDataRate() + " bps");
				do {
					message = JOptionPane.showInputDialog(
							"Do you want to continue (Y or N)?");
				} while ((message.compareTo("Y") != 0)
						&& (message.compareTo("y") != 0)
						&& (message.compareTo("N") != 0)
						&& (message.compareTo("n") != 0));// repeat when input
															// other elements
			} catch (NumberFormatException ex) {
				message = "Y";
				JOptionPane.showMessageDialog(null,
						"You did not enter a number");
			} catch (NullPointerException ex) {
				message = "Y";
				JOptionPane.showMessageDialog(null,
						"This calculation is cancelled.");
			}
		} while (message.compareTo("Y") == 0 || message.compareTo("y") == 0);
	}

} /* End of CLASS: ShannonsTheorem.java */