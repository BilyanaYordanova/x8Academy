package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.StringReverse;

class Test_StringReverse {

	StringReverse obj = new StringReverse();

	@Test
	void test1() {
		assertEquals("siht si tahW", obj.reverse("What is this"));
	}

	@Test
	void test2() {
		assertEquals("ab cd", obj.reverse("dc ba"));
	}
}
