package tasks1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks1.BracketsCorrectedness;

class Test_BracketsCorrectedness {

	BracketsCorrectedness obj = new BracketsCorrectedness();

	@Test
	void test1() {
		assertFalse(obj.bracketCorrectedness("{[([)]()]}"));
	}

	@Test
	void test2() {
		assertFalse(obj.bracketCorrectedness("{[()()]"));
	}

	@Test
	void test3() {
		assertFalse(obj.bracketCorrectedness("[(])"));
	}

	@Test
	void test4() {
		assertTrue(obj.bracketCorrectedness("{[()()]}"));
	}

	@Test
	void test5() {
		assertTrue(obj.bracketCorrectedness("{}[]()"));
	}

	@Test
	void test6() {
		assertTrue(obj.bracketCorrectedness(""));
	}
}
