package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.TriangleRule;

class Test_TriangleRule {

	TriangleRule obj = new TriangleRule();

	@Test
	void test1() {
		assertArrayEquals(new int[] { 2, 3, 4 },
				obj.threeNumbersCorrespondingTriangleRule(new int[] { 7, 4, 6, 2, 3 }));
	}

	@Test
	void test2() {
		assertArrayEquals(new int[] { 4, 6, 7 },
				obj.threeNumbersCorrespondingTriangleRule(new int[] { 7, 4, 6, 2, 15, 19, 7 }));
	}

	// if no three numbers corresponding to the triangle rule are found
	@Test
	void test3() {
		assertArrayEquals(new int[] { 0, 0, 0 },
				obj.threeNumbersCorrespondingTriangleRule(new int[] { 4, 6, 2, 26, 16, 10 }));
	}
}
