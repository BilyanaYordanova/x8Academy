package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.QueueLinkedList;

class Test_QueueLinkedList {

	QueueLinkedList obj = new QueueLinkedList();

	@Test
	void test1_Empty() {
		assertTrue(obj.isEmpty());
	}

	@Test
	void test2_notEmpty() {
		obj.enqueue(1);
		assertFalse(obj.isEmpty());
	}

	@Test
	void test3_Dequeue() {
		assertEquals(-1, obj.dequeue());
	}

	@Test
	void test4_Dequeue() {
		for (int i = 1; i <= 55; i += 2) {
			obj.enqueue(i);
		}
		assertEquals(1, obj.dequeue());
		assertEquals(3, obj.dequeue());
		assertEquals(5, obj.dequeue());
	}

	@Test
	void test5_getSize() {
		for (int i = 1; i <= 33; i++) {
			obj.enqueue(i);
		}
		assertEquals(33, obj.getSize());
	}

}
