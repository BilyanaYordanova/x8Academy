package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.KthFactorial;

class Test_KthFactorial {

	KthFactorial obj = new KthFactorial();

	@Test
	void test1() {
		assertEquals(1, obj.kthFac(12, 1));
	}

	@Test
	void test2() {
		assertEquals(2, obj.kthFac(20, 2));
	}

	@Test
	void test3() {
		assertEquals(720, obj.kthFac(2, 3));
	}
}
