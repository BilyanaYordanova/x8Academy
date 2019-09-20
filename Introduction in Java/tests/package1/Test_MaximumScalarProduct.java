package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.MaximumScalarProduct;

class Test_MaximumScalarProduct {

	MaximumScalarProduct obj = new MaximumScalarProduct();

	@Test
	void test1() {
		assertEquals(41, obj.maximalScalarSum(new int[] { 4, 3, 2 }, new int[] { 1, 5, 6 }));
	}

	@Test
	void test2() {
		assertEquals(69, obj.maximalScalarSum(new int[] { 11, 4, 2 }, new int[] { 1, 3, 5 }));
	}

}
