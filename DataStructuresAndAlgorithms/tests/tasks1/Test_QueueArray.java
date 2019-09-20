package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.QueueArray;

class Test_QueueArray {

	QueueArray obj = new QueueArray();

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
	void test3_getSize() {
		for (int i = 1; i <= 15; i++) {
			obj.enqueue(i);
		}
		assertEquals(15, obj.getSize());
	}

	@Test
	void test4_Enqueue_Dequeue() {
		for (int i = 1; i <= 34; i++) {
			obj.enqueue(i);
		}

		for (int j = 1; j <= 14; j++) {
			obj.dequeue();
		}
		assertEquals(20, obj.getSize());
	}

	@Test
	void test5_Dequeue() {
		assertEquals(-1, obj.dequeue());
	}

	@Test
	void test6_Dequeue() {
		for (int i = 1; i <= 18; i++) {
			obj.enqueue(i);
		}
		assertEquals(1, obj.dequeue());
		assertEquals(2, obj.dequeue());
		assertEquals(3, obj.dequeue());
	}
}
