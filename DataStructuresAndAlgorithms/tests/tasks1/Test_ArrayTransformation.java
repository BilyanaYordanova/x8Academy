package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.ArrayTransformation;

class Test_ArrayTransformation {

	ArrayTransformation obj = new ArrayTransformation();

	@Test
	void test1() {
		assertArrayEquals(new int[] { 5, 5, 10, -1, -1 }, obj.transformArray(new int[] { 3, 2, 5, 10, 4 }));
	}

	@Test
	void test2() {
		assertArrayEquals(new int[] { -1 }, obj.transformArray(new int[] { 3 }));
	}

	@Test
	void test3() {
		assertArrayEquals(new int[] { -1, -1 }, obj.transformArray(new int[] { 3, 2 }));
	}

	@Test
	void test4() {
		assertArrayEquals(new int[] {}, obj.transformArray(new int[] {}));
	}
}
