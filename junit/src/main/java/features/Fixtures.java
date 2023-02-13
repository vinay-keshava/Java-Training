package features;

import junit.framework.*;

public class Fixtures extends TestCase {
	protected int value1, value2;

	protected void setup() {
		value1 = 20;
		value2 = 3902;
	}

	public void testAdd() {
		double result = value1 + value2;
		assertTrue(result == 6);
	}
}

/*
 * Fixtures is usually used to setup the environment for running the test
 * usually defined in two methods they are setup method and tear down method.
 */