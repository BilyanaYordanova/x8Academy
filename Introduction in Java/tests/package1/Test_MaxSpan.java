package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import package1.MaxSpan;

class Test_MaxSpan {

	MaxSpan obj = new MaxSpan();

	@Test
	void test1() {
		assertEquals(10, obj.maxSpan(new int[] { 3, 6, 6, 8, 4, 3, 6, 7, 8, 9, 6 }));
	}

	@Test
	void test2() {
		assertEquals(2, obj.maxSpan(new int[] { 31, 31, 6, 18, 23, 9, 51, 61 }));
	}

	@Test
	void test3() {
		assertEquals(1, obj.maxSpan(new int[] { 31, 6, 18, 23, 9, 51, 61 }));
	}
}
