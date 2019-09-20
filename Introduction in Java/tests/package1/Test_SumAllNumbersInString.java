package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.SumAllNumbersInString;

class Test_SumAllNumbersInString {

	SumAllNumbersInString obj = new SumAllNumbersInString();

	@Test
	void test1() {
		assertEquals(21, obj.sumOfNumbers("12this34is56string"));
	}

	@Test
	void test2() {
		assertEquals(10, obj.sumOfNumbers("1g0u5hh4"));
	}

	@Test
	void test3() {
		assertEquals(0, obj.sumOfNumbers("abcdefg"));
	}
}
