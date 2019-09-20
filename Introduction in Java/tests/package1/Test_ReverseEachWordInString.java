package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.ReverseEachWordInString;

class Test_ReverseEachWordInString {

	ReverseEachWordInString obj = new ReverseEachWordInString();

	@Test
	void test1() {
		char[] charArray = ("ab ba").toCharArray();
		assertArrayEquals(charArray, obj.reverseEveryWord("ba ab").toCharArray());
	}

	@Test
	void test2() {
		assertEquals("tahW si siht", obj.reverseEveryWord("What is this"));
	}
}
