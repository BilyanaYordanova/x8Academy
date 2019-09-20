package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.KthMinElementQuickSelect;

class Test_KthMinElementQuickSelect {

	KthMinElementQuickSelect obj = new KthMinElementQuickSelect();
	int[] array = { -6, 13, -1, 534, -23 }; // -23 -6 -1 13 534

	@Test
	public void test1() {
		assertEquals(-1, obj.kthMin(3, array, 0, array.length - 1));
	}

	@Test
	public void test2() {
		assertEquals(534, obj.kthMin(5, array, 0, array.length - 1));
	}
}
