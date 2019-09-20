package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.DoubleFactorial;

class TestDoubleFactorial {

	DoubleFactorial obj = new DoubleFactorial();

	@Test
	void test1() {
		assertEquals(1, obj.doubleFac(1));
	}

	@Test
	void test2() {
		assertEquals(2, obj.doubleFac(2));
	}

	@Test
	void test3() {
		assertEquals(720, obj.doubleFac(3));
	}
}
