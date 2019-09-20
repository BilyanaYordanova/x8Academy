package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.PowerFunction;

public class PowerFunctionTest {

	PowerFunction obj = new PowerFunction();

	@Test
	public void test1() {
		assertEquals(-8, obj.pow(-2, 3));
	}

	@Test
	public void test2() {
		assertEquals(15625, obj.pow(5, 6));
	}

	@Test
	public void test3() {
		assertEquals(1, obj.pow(1245, 0));
	}

	@Test
	public void test4() {
		assertEquals(1, obj.pow(2, -16));
	}

	@Test
	public void test5() {
		assertEquals(0, obj.pow(0, 16));
	}
}
