package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.DecimalToBinary;

class Test_DecimalToBinary {

	DecimalToBinary obj = new DecimalToBinary();

	@Test
	void test1() {
		assertArrayEquals(new int[] { 1, 0, 0, 0, 0, 0 }, obj.decimalToBinary(32));
	}

	@Test
	void test2() {
		assertArrayEquals(new int[] { 1, 0, 1, 0, 1, 0, 0, 1, 1, 0 }, obj.decimalToBinary(678));
	}

	@Test
	void test3() {
		assertArrayEquals(new int[] { 0 }, obj.decimalToBinary(0));
	}
}
