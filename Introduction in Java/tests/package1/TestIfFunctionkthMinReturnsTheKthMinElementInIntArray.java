package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.KthMinElement;

public class TestIfFunctionkthMinReturnsTheKthMinElementInIntArray {

	KthMinElement obj = new KthMinElement();
	int[] array = { -6, 13, -1, 534, -23 }; // -23 -6 -1 13 534

	@Test
	public void test1() {
		assertEquals(-1, obj.kthMin(3, array));
	}

	@Test
	public void test2() {
		assertEquals(534, obj.kthMin(5, array));
	}
}
