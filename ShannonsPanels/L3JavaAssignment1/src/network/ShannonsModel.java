package network;

import java.util.Observable;

/**
 * Implement data of Shannon's Theorem.
 * 
 * @author Zhe Huang
 * @version 2.0.0 Date March 16, 2016
 * @see java.util.Observable
 * @since 1.8.0_73
 */
public class ShannonsModel extends Observable {

	/**
	 * bandwidth of the communication channel
	 */
	private double bandwidth;

	/**
	 * Signal-To-Noise ratio of the communication channel
	 */
	private double signalToNoise;

	/**
	 * Default constructor.
	 */
	public ShannonsModel() {
		super();
	}

	/**
	 * Getter for bandwidth field.
	 * 
	 * @return double
	 */
	public double getBandwidth() {
		return Double.parseDouble(String.format("%.2f", bandwidth));// format
																	// two
																	// decimals
	}

	/**
	 * Setter for bandwidth
	 * 
	 * @param bandwidth
	 *            value of bandwidth
	 */
	public void setBandwidth(double bandwidth) {
		this.bandwidth = bandwidth;
		this.setChanged();
		this.notifyObservers(); // notify all the observers
	}

	/**
	 * Getter for signal-to-noise ratio
	 * 
	 * @return double
	 */
	public double getSignalToNoise() {
		return Double.parseDouble(String.format("%.2f", signalToNoise)); // format
																			// two
																			// decimals
	}

	/**
	 * Setter for signal-to-noise
	 * 
	 * @param signalToNoise
	 *            the signal-to-noise ratio
	 */
	public void setSignalToNoise(double signalToNoise) {
		this.signalToNoise = signalToNoise;
		this.setChanged();
		this.notifyObservers(); // notify all the Observers
	}

	/**
	 * Getter for maximum communication rate
	 * 
	 * @return double
	 */
	public double getMaximumDataRate() {
		return Double.parseDouble(String.format("%.2f",
				getMaximumDataRate(bandwidth, signalToNoise)));// format the
																// result
	}

	/**
	 * Getter for bandwidth with two parameters.
	 * 
	 * @param bandwidth
	 *            bandwidth of communication channel
	 * @param signalToNoise
	 *            Signal-To-Noise ratio of communication channel
	 * @return double
	 */
	private static double getMaximumDataRate(double bandwidth,
			double signalToNoise) {
		return bandwidth * (Math.log(1 + Math.pow(10, signalToNoise / 10))
				/ Math.log(2));// ShannonsTheorem
	}

	/**
	 * Reveal the calculation result.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Bandwidth = " + getBandwidth() + " hz, signalToNoise = "
				+ getSignalToNoise() + " db, maximumRate = "
				+ String.format("%.2f bps", getMaximumDataRate());
	}

}
