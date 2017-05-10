package networktest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import network.ShannonsTheorem;

/**
 * Test some methods in class ShannonsTheorem
 * 
 * @author Zhe Huang
 * @version 2.0.0 Date February 12, 2016
 * @see org.junit.Assert
 * @see org.junit.After
 * @see org.junit.Before
 * @see org.junit.Test
 * @since 1.8.0_73
 */
public class ShannonsTheoremTest {

	/**
	 * Reference to the ShannonsTheorem
	 */
	private ShannonsTheorem problem;

	/**
	 * @throws java.lang.Exception
	 *             Give messages if errors occur
	 */
	@Before
	public void setUp() throws Exception {
		problem = new ShannonsTheorem();
	}

	/**
	 * @throws java.lang.Exception
	 *             Give messages if errors occur
	 */
	@After
	public void tearDown() throws Exception {
		problem = null;
	}

	/**
	 * Test constructor
	 */
	@Test
	public void testShannonsTheorem() {
		assertNotNull("constructor has been tested.", problem);
	}

	/**
	 * Test method getBandwidth()
	 */
	@Test
	public void testGetBandwidth() {
		problem.setBandwidth(10.0);
		assertEquals(10.0, problem.getBandwidth(), 0.001);
	}

	/**
	 * Test method getMaximumRate()
	 */
	@Test
	public void testGetMaximumRate() {
		problem.setBandwidth(10);
		problem.setSignalToNoise(0);
		assertEquals(10.00, problem.getMaximumDataRate(), 0.001);
	}

	/**
	 * Test method getSignalToNoise()
	 */
	@Test
	public void testGetSignalToNoise() {
		problem.setSignalToNoise(10.0);
		assertEquals(10.0, problem.getSignalToNoise(), 0.001);
	}

	/**
	 * Test method setBandwidth(double h)
	 */
	@Test
	public void testSetBandwidth() {
		problem.setBandwidth(20.0);
		assertEquals(20.0, problem.getBandwidth(), 0.001);
	}

	/**
	 * Test method setSignalToNoise(double snr)
	 */
	@Test
	public void testSetSignalToNoise() {
		problem.setSignalToNoise(20.0);
		assertEquals(20.0, problem.getSignalToNoise(), 0.001);
	}

}
