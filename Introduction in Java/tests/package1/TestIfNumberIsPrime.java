package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.CheckIfPrime;

public class TestIfNumberIsPrime {

	CheckIfPrime obj = new CheckIfPrime();

	@Test
	public void test1() {
		boolean resTrue = obj.isPrime(17);
		assertTrue(resTrue);
	}

	@Test
	public void test2() {
		boolean resFalse = obj.isPrime(8);
		assertFalse(resFalse);
	}

}
