package network;

import java.util.Observer;

/**
 * Implement Shannon's Controller. Date March 16, 2016
 * 
 * @author Zhe Huang
 * @version 1.0.0
 * @see java.util.Observer
 * @since 1.8.0_73
 */
public interface ShannonsController {

	/**
	 * Abstract class to add an observer
	 * 
	 * @param observer
	 *            views to be added
	 */
	public void addObserver(Observer observer);

	/**
	 * Abstract class to set bandwidth
	 * 
	 * @param bandwidth
	 *            value of bandwidth
	 */
	public void setBandwidth(double bandwidth);

	/**
	 * Abstract class to set signalToNoise
	 * 
	 * @param signalToNoise
	 *            value of signalToNoise
	 */
	public void setSignalToNoise(double signalToNoise);

}
