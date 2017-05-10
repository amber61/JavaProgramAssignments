package network;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

/**
 * Implement Shannon's Graphic View.
 * 
 * @author Zhe Huang
 * @version 1.0.0 Date March 16, 2016
 * @see javax.swing.JPanel
 * @see java.awt.Color
 * @see java.awt.Font
 * @see java.awt.FontMetrics
 * @see java.awt.Graphics
 * @see java.util.Observable
 * @see java.util.Observer
 * @since 1.8.0_73
 */
public class ShannonsGraphicPanel extends JPanel implements Observer {

	/**
	 * Field to access ShannonsModel
	 */
	private ShannonsModel model;

	/**
	 * Default Constructor
	 */
	public ShannonsGraphicPanel() {
		this.model = null;
	}

	/**
	 * Update the graphic view
	 * 
	 * @param o
	 *            object of observable
	 * @param arg
	 *            object of Object
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ShannonsModel) {
			this.model = (ShannonsModel) o;
		}
		this.repaint(); // call paintComponent once any changes
	}

	/**
	 * paint the panel
	 */
	@Override
	public void paintComponent(Graphics g) {
		// JPanel graphicPanel = new JPanel();
		if (model != null) {
			final int maxBandWidth = 3000;
			final int maxSignalToNoise = 30;
			final double maxMaximumDataRate = maxBandWidth
					* (Math.log(1 + Math.pow(10, maxSignalToNoise / 10))
							/ Math.log(2));
			int barHeight = this.getHeight() / 3; // Each bar height
			int widthAvailable = this.getWidth();

			g.setColor(Color.WHITE);
			g.fillRect(0, 0, widthAvailable, this.getHeight());

			double bandwidth = model.getBandwidth();
			int bandwidthBarWidth = (int) (bandwidth / maxBandWidth
					* widthAvailable);

			double signalToNoise = model.getSignalToNoise();
			int signalToNoiseBarWidth = (int) (signalToNoise / maxSignalToNoise
					* widthAvailable);

			double maximumDataRate = model.getMaximumDataRate();
			int maximumDataRateBarWidth = (int) (maximumDataRate
					/ maxMaximumDataRate * widthAvailable);

			g.setColor(new Color(238, 230, 133));
			g.fillRect(0, 0, bandwidthBarWidth, barHeight);
			g.fillRect(0, barHeight, signalToNoiseBarWidth, barHeight);
			g.fillRect(0, 2 * barHeight, maximumDataRateBarWidth, barHeight); // Set
																				// color
																				// bar

			g.setColor(Color.BLACK);
			g.setFont(new Font("SansSerif", Font.PLAIN, 10));
			FontMetrics metrics = g.getFontMetrics();
			g.drawString("bw(herz):"
					+ String.format("%.2f", model.getBandwidth()).toString(), 0,
					barHeight - metrics.getDescent());
			g.drawString(
					"snr(db):" + String.format("%.2f", model.getSignalToNoise())
							.toString(),
					0, 2 * barHeight - metrics.getDescent());
			g.drawString(
					"mdr(bps):"
							+ String.format("%.2f", model.getMaximumDataRate())
									.toString(),
					0, 3 * barHeight - metrics.getDescent()); // Set word on
																// color bar
		}
	}
}
