package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.AhasSubstringAnagramOfB;

class Test_AhasSubstringAnagramOfB {

	AhasSubstringAnagramOfB obj = new AhasSubstringAnagramOfB();

	@Test
	void test1_True() {
		assertTrue(obj.hasAnagramOf("aab odedrg", "adobe"));
	}

	@Test
	void test2_True() {
		assertTrue(obj.hasAnagramOf("ftrunsacet", "scate"));
	}

	@Test
	void test3_False() {
		assertFalse(obj.hasAnagramOf("analyzer", "cook"));
	}

	@Test
	void test4_True() {
		assertTrue(obj.hasAnagramOf("a", "a"));
	}
}
