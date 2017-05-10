package networktest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import network.ShannonsModel;

/**
 * Test some methods in class ShannonsModel
 * 
 * @author Zhe Huang
 * @version 1.0.0 Date February 12, 2016
 * @see org.junit.Assert
 * @see org.junit.After
 * @see org.junit.Before
 * @see org.junit.Test
 * @since 1.8.0_73
 */
public class ShannonsModelTest {

	/**
	 * Reference to the ShannonsModel
	 */
	private ShannonsModel model;

	/**
	 * @throws java.lang.Exception
	 *             Give messages if errors occur
	 */
	@Before
	public void setUp() throws Exception {
		model = new ShannonsModel();
	}

	/**
	 * @throws java.lang.Exception
	 *             Give messages if errors occur
	 */
	@After
	public void tearDown() throws Exception {
		model = null;
	}

	/**
	 * Test constructor
	 */
	@Test
	public void testShannonsModel() {
		assertNotNull("constructor has been tested.", model);
	}

	/**
	 * Test method getBandwidth()
	 */
	@Test
	public void testGetBandwidth() {
		model.setBandwidth(10.0);
		assertEquals(10.0, model.getBandwidth(), 0.001);
	}

	/**
	 * Test method getSignalToNoise()
	 */
	@Test
	public void testGetSignalToNoise() {
		model.setSignalToNoise(10.0);
		assertEquals(10.0, model.getSignalToNoise(), 0.001);
	}

	/**
	 * Test method getMaximumRate()
	 */
	@Test
	public void testGetMaximumRate() {
		model.setBandwidth(10);
		model.setSignalToNoise(0);
		assertEquals(10.00, model.getMaximumDataRate(), 0.001);
	}

	/**
	 * Test method setBandwidth(double h)
	 */
	@Test
	public void testSetBandwidth() {
		model.setBandwidth(20.0);
		assertEquals(20.0, model.getBandwidth(), 0.001);
	}

	/**
	 * Test method setSignalToNoise(double snr)
	 */
	@Test
	public void testSetSignalToNoise() {
		model.setSignalToNoise(20.0);
		assertEquals(20.0, model.getSignalToNoise(), 0.001);
	}

	/**
	 * Test method toString()
	 */
	@Test
	public void testToString() {
		model.setBandwidth(10);
		model.setSignalToNoise(0);
		assertEquals(
				"Bandwidth = 10.0 hz, signalToNoise = 0.0 db, maximumRate = 10.00 bps",
				model.toString());
	}

}
