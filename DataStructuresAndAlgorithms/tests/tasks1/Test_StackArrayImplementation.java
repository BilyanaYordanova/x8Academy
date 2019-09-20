package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.StackArrayImplementation;

class Test_StackArrayImplementation {

	StackArrayImplementation obj = new StackArrayImplementation();

	@Test
	void test1_Empty() {
		assertTrue(obj.isEmpty());
	}

	@Test
	void test2_NotEmpty() {
		for (int i = 1; i <= 15; i++) {
			obj.push(i);
		}
		assertFalse(obj.isEmpty());
	}

	@Test
	void test3_getSize() {
		for (int i = 1; i <= 15; i++) {
			obj.push(i);
		}
		assertEquals(15, obj.getSize());
	}

	@Test
	void test4_Pop() {
		for (int i = 1; i <= 15; i++) {
			obj.push(i);
		}
		assertEquals(15, obj.pop());
	}

	@Test
	void test5_Peek() {
		for (int i = 1; i <= 14; i++) {
			obj.push(i);
		}
		assertEquals(14, obj.peek());
	}

	@Test
	void test6_getSize() {
		for (int i = 1; i <= 14; i++) {
			obj.push(i);
		}
		assertEquals(14, obj.getSize());
	}

	@Test
	void test7_Peek_Pop() {
		assertEquals(-1, obj.peek());
		assertEquals(-1, obj.pop());
	}
}
