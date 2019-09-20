package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.ScalarProductOfTwoVectors;

class Test_ScalarProductOfTwoVectors {

	ScalarProductOfTwoVectors obj = new ScalarProductOfTwoVectors();

	@Test
	void test1() {
		int[] firstArray = { 4, 3, 2 };
		int[] secondArray = { 1, 5, 6 };

		assertEquals(31, obj.scalarSum(firstArray, secondArray));
	}

}
