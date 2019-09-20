package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.IsNumberPalindrome;

class Test_IsNumberPalindrome {

	IsNumberPalindrome obj = new IsNumberPalindrome();

	@Test
	void test1_True() {
		assertTrue(obj.isPalindrome(81018));
	}

	@Test
	void test2_True() {
		assertTrue(obj.isPalindrome(8118));
	}

	@Test
	void test3_False() {
		assertFalse(obj.isPalindrome(8150418));
	}

	@Test
	void test4_True() {
		assertTrue(obj.isPalindrome(1));
	}

}
