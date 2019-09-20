package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.checkIfOdd;

public class TestIfPositiveNumberIsOdd {

	checkIfOdd obj = new checkIfOdd();

	@Test
	public void test1_ifPositiveNumIsOdd() {
		boolean resultTrue = obj.isOdd(5);
		assertTrue(resultTrue);
	}

	@Test
	public void test2_ifPositiveNumIsOdd() {
		boolean resultFalse = obj.isOdd(6);
		assertFalse(resultFalse);
	}

}
