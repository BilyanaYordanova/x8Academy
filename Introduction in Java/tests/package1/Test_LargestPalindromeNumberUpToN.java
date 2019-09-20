package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.LargestPalindromeNumberUpToN;

class Test_LargestPalindromeNumberUpToN {

	LargestPalindromeNumberUpToN obj = new LargestPalindromeNumberUpToN();
	
	@Test
	void test1() {
		assertEquals(10701, obj.getLargestPalindrome(10800));
	}

	@Test
	void test2() {
		assertEquals(3281823, obj.getLargestPalindrome(3281826));
	}

	@Test
	void test3() {
		assertEquals(1, obj.getLargestPalindrome(2));
	}
}
