package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.IsStringPalindrome;

class Test_IsStringPalindrome {

	IsStringPalindrome obj = new IsStringPalindrome();

	@Test
	void test1_True() {
		assertTrue(obj.isPalindrome("racecar"));
	}

	@Test
	void test2_False() {
		assertFalse(obj.isPalindrome("racecare"));
	}

	@Test
	void test3_True() {
		assertTrue(obj.isPalindrome("madam"));
	}

}
