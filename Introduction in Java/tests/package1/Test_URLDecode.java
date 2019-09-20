package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import package1.URLDecode;

class Test_URLDecode {

	URLDecode obj = new URLDecode();

	@Test
	void test1() {
		assertEquals("frrg gjjd:jgdlsnd?mgldkgdl/", obj.decodeUrl("frrg%20gjjd%3Ajgdlsnd%3Dmgldkgdl%2F"));
	}

	@Test
	void test2() {
		assertEquals("hfsfhaskhks:hfkfks/ ", obj.decodeUrl("hfsfhaskhks%3Ahfkfks%2F%20"));
	}

}
