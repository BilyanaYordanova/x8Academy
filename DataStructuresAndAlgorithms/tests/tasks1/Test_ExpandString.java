package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.ExpandString;

class Test_ExpandString {

	ExpandString obj = new ExpandString();
	
	@Test
	void test1() {
		String str = "AB3(DC)2(F)";
		assertEquals("ABDCDCDCFF", obj.expandString(str));
	}

	@Test
	void test2() {
		String str = "FD1(GY)GG";
		assertEquals("FDGYGG", obj.expandString(str));
	}

	@Test
	void test3() {
		String str = "5(OK)";
		assertEquals("OKOKOKOKOK", obj.expandString(str));
	}

}
