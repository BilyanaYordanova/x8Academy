package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.SmallestMultiple;

public class TestSmallestMultiple_getSmallestMultiple {

	SmallestMultiple obj = new SmallestMultiple();

	@Test
	public void test1() {
		assertEquals(420, obj.getSmallestMultiple(7));
	}

	@Test
	public void test2() {
		assertEquals(1, obj.getSmallestMultiple(1));
	}
}
