package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.minElementArray;

public class TestIfFunctionminReturnsTheMinElementInIntArray {

	minElementArray obj = new minElementArray();

	@Test
	public void test1() {
		int[] array = { -4, 8, 9, 12, 567 };
		int result = obj.min(array);
		assertEquals(-4, result);
	}

}
