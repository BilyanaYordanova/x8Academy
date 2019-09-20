package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.averageOfElements;

public class TestgetAverageRetunsAverageOfElementsInIntArray {

	averageOfElements obj = new averageOfElements();

	@Test
	public void test1() {
		int[] array = { 12, 8, 13, 7 }; // 10
		assertEquals(10, obj.getAverage(array));
	}

	@Test
	public void test2() {
		int[] secondArray = {};
		assertEquals(0, obj.getAverage(secondArray));
	}

	@Test
	public void test3() {
		int[] thirdArray = { -6, 8, -15, 5, -20 }; // -28/5 = -5
		assertEquals(-5, obj.getAverage(thirdArray));
	}
}
