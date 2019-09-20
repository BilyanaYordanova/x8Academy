package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.FindMinMissing1ToN;

class TestFindMinMissing1ToN {

	FindMinMissing1ToN obj = new FindMinMissing1ToN();

	@Test
	void test1_1ToN() {
		int[] array = new int[] { 3, 2, 5, 10 };
		assertEquals(1, obj.findMinMissing(array));
	}

	@Test
	void test2_1ToN() {
		int[] array = new int[] { 3, 2, 1, 5, 10 };
		assertEquals(4, obj.findMinMissing(array));
	}

	@Test
	void test3_1ToN() {
		int[] array = new int[] { 3, 2, 7, 6, 1, 5, 4, 8, 10 };
		assertEquals(9, obj.findMinMissing(array));
	}

	@Test
	void test4_1ToN() {
		int[] array = new int[] { 1, 6, 4, 2, 5, 3 };
		assertEquals(7, obj.findMinMissing(array));
	}

	@Test
	void test5_1ToN() {
		int[] array = new int[] { 1, 6, 4, 2, 5, 3, 7, 8, 10, 10, 11, 4, 4, 11 };
		assertEquals(9, obj.findMinMissing(array));
	}
}
