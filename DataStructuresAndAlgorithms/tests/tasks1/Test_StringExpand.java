package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.StringExpand;

class Test_StringExpand {

	StringExpand obj = new StringExpand();

	@Test
	void test1() {
		assertEquals("ABDCFFDCFFDCFF", obj.expand("AB3(DC2(F))"));
	}

	@Test
	void test2() {
		assertEquals("CG", obj.expand("3()CG"));
	}

	@Test
	void test3() {
		assertEquals("HHTYIBUBUBUBUIBUBUBUBUIBUBUBUBUTYIBUBUBUBUIBUBUBUBUIBUBUBUBU", obj.expand("HH2(TY3(I4(BU)))"));
	}

	@Test
	void test4() {
		assertEquals("", obj.expand("()"));
	}
}
