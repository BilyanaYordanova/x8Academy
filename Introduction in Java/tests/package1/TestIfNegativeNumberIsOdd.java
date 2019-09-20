package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.checkIfOdd;

public class TestIfNegativeNumberIsOdd {

	checkIfOdd obj = new checkIfOdd();

	@Test
	public void test1_IfNegativeNumIsOdd() {
		boolean resTrue = obj.isOdd(-5);
		assertTrue(resTrue);
	}

	@Test
	public void test2_IfNegativeNumIsOdd() {
		boolean resFalse = obj.isOdd(-6);
		assertFalse(resFalse);
	}

}
