package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.IsAnagram;

class Test_IsAnagram {

	IsAnagram obj = new IsAnagram();

	@Test
	void test1_False() {
		assertFalse(obj.anagram("anagram", "naga a ram"));
	}

	@Test
	void test2_True() {
		assertTrue(obj.anagram("anagram", "ana g ram"));
	}

	@Test
	void test3_True() {
		assertTrue(obj.anagram("adobe", "beado"));
	}
}
