package network;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * Implement Shannon's Slider View.
 * 
 * @author Zhe Huang
 * @version 1.0.0 Date March 16, 2016
 * @see java.awt.BorderLayout
 * @see java.awt.GridLayout
 * @see java.util.Observable
 * @see java.util.Observer
 * @see javax.swing.event.ChangeListener
 * @see javax.swing.event.ChangeEvent
 * @see javax.swing.JLabel
 * @see javax.swing.JPanel
 * @see javax.swing.JSlider
 * @since 1.8.0_73
 */
public class ShannonsSliderPanel extends JPanel implements Observer {

	/**
	 * Field to access ShannonsController
	 */
	private ShannonsController controller;

	/**
	 * Field to access JSlider
	 */
	private JSlider maxDataRateJSlider;

	/**
	 * Field to access JSlider
	 */
	private JSlider bandwidthJSlider;

	/**
	 * Field to access JSlider
	 */
	private JSlider signalToNoiseJSlider;

	/**
	 * {@value} Description the constant of BANDWIDTH_MAX
	 */
	private final static int BANDWIDTH_MAX = 3000;

	/**
	 * {@value} Description the constant of BANDWIDTH_MIN
	 */
	private final static int BANDWIDTH_MIN = 0;

	/**
	 * {@value} Description the constant of SIGNAL_TO_NOISE_MAX
	 */
	private final static int SIGNAL_TO_NOISE_MAX = 30;

	/**
	 * {@value} Description the constant of SIGNAL_TO_NOISE_MIN
	 */
	private final static int SIGNAL_TO_NOISE_MIN = 0;

	/**
	 * {@value} Description the constant of MAXIMUM_DATA_RATE_MAX
	 */
	private final static int MAXIMUM_DATA_RATE_MAX = 29901;

	/**
	 * {@value} Description the constant of MAXIMUM_DATA_RATE_MIN
	 */
	private final static int MAXIMUM_DATA_RATE_MIN = 0;

	/**
	 * Constructor
	 * 
	 * @param controller
	 *            value to access ShannonsController
	 */
	public ShannonsSliderPanel(ShannonsController controller) {
		this.controller = controller;
		maxDataRateJSlider = new JSlider(JSlider.HORIZONTAL,
				MAXIMUM_DATA_RATE_MIN, MAXIMUM_DATA_RATE_MAX,
				MAXIMUM_DATA_RATE_MIN);
		bandwidthJSlider = new JSlider(JSlider.HORIZONTAL, BANDWIDTH_MIN,
				BANDWIDTH_MAX, BANDWIDTH_MIN);
		signalToNoiseJSlider = new JSlider(JSlider.HORIZONTAL,
				SIGNAL_TO_NOISE_MIN, SIGNAL_TO_NOISE_MAX, SIGNAL_TO_NOISE_MIN);
		maxDataRateJSlider.setEnabled(false);

		configureEvents(); // handle the event after Enter
		assembleUserInterface(); // draw the user interface
	}

	/**
	 * Update the slider view
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
			bandwidthJSlider.setValue((int) model.getBandwidth());
			signalToNoiseJSlider.setValue((int) model.getSignalToNoise());
			maxDataRateJSlider.setValue((int) model.getMaximumDataRate());
		}

	}

	/**
	 * Draw the user interface
	 */
	private void assembleUserInterface() {
		JPanel labelsJPanel = new JPanel(new GridLayout(3, 1));
		labelsJPanel.add(new JLabel("Bandwidth(herz)"));
		labelsJPanel.add(new JLabel("Signal to Noise(db)"));
		labelsJPanel.add(new JLabel("Maximum Data Rate(bps)"));// Label Panel

		JPanel sliderJPanel = new JPanel(new GridLayout(3, 1));
		sliderJPanel.add(bandwidthJSlider);
		sliderJPanel.add(signalToNoiseJSlider);
		sliderJPanel.add(maxDataRateJSlider);// Slider Panel

		this.setLayout(new BorderLayout());
		this.add(labelsJPanel, BorderLayout.WEST);
		this.add(sliderJPanel, BorderLayout.CENTER);

	}

	/**
	 * Configure events after click or Enter
	 */
	private void configureEvents() {
		bandwidthJSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				controller.setBandwidth(bandwidthJSlider.getValue());
			}
		});

		signalToNoiseJSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				controller.setSignalToNoise(signalToNoiseJSlider.getValue());
			}
		});

	}

}
