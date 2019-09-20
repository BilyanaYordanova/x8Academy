package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.StackLinkedListImplementation;

class Test_StackLinkedListImplementation {

	StackLinkedListImplementation obj = new StackLinkedListImplementation();

	@Test
	void test1_Empty() {
		assertTrue(obj.isEmpty());
	}

	@Test
	void test2_notEmpty() {
		obj.push(1);
		assertFalse(obj.isEmpty());
	}

	@Test
	void test3_Pop() {
		assertEquals(-1, obj.pop());
	}

	@Test
	void test4_Dequeue() {
		for (int i = 1; i <= 55; i += 2) {
			obj.push(i);
		}
		assertEquals(55, obj.pop());
		assertEquals(53, obj.pop());
		assertEquals(51, obj.pop());
	}

	@Test
	void test5_getSize() {
		for (int i = 1; i <= 33; i++) {
			obj.push(i);
		}
		assertEquals(33, obj.getSize());
	}

}
