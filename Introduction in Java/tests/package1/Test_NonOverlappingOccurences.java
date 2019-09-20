package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.NonOverlappingOccurences;

class Test_NonOverlappingOccurences {

	NonOverlappingOccurences obj = new NonOverlappingOccurences();

	@Test
	void test1() {
		assertEquals(6, obj.mentions("what", "whattfwhatahtfwhatawhathwatwhatwhat"));
	}

	@Test
	void test2() {
		assertEquals(1, obj.mentions("aa", "aaa"));
	}

	@Test
	void test3() {
		assertEquals(4, obj.mentions("what", "whattfwahtfwhatawhathwatwhat"));
	}

}
