package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.SmallestMultiple;

public class TestSmallestMultiple_gcd {

	SmallestMultiple obj = new SmallestMultiple();

	@Test
	public void test1() {
		assertEquals(4, obj.gcd(4, 12));
	}

	@Test
	public void test2() {
		assertEquals(8, obj.gcd(24, 32));
	}
}
