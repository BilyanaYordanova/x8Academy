package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import package1.EqualSumSides;

class Test_EqualSumSides {

	EqualSumSides obj = new EqualSumSides();

	@Test
	void test1() {
		assertTrue(obj.equalSumSides(new int[] { 3, 0, -1, 2, 1 }));
	}

	@Test
	void test2() {
		assertTrue(obj.equalSumSides(new int[] { 2, 1, 2, 3, 1, 4 }));
	}

	@Test
	void test3() {
		assertFalse(obj.equalSumSides(new int[] { 8, 8 }));
	}
}
