package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MyException;
import mainpackage.Terminal;
import mainpackage.TreeNode;
import mockspackage.CreateFileMock;
import mockspackage.WriteToFileMock;

class WordCountCombinedTest {

	WordCountCombined wordCountObj = new WordCountCombined();
	Terminal terminalObject = new Terminal();
	TreeNode initialDirectory = terminalObject.getCurrentDirectory();
	CreateFileMock createFileMockObj = new CreateFileMock();
	WriteToFileMock writeToFileMockObj = new WriteToFileMock();

	@Test
	void test1_WordsCountEmptyFile() {
		createFileMockObj.execute(initialDirectory, "file");
		String errorMessage = "";
		String result = "";
		try {
			result = wordCountObj.execute(terminalObject, "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals(Integer.toString(0), result);
	}

	@Test
	void test2_WordsCountNonEmptyFile() {
		createFileMockObj.execute(initialDirectory, "file");
		writeToFileMockObj.execute(initialDirectory, "file", 2, "This is a file.");

		String errorMessage = "";
		String result = "";
		try {
			result = wordCountObj.execute(terminalObject, "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals(Integer.toString(4), result);
	}

	@Test
	void test3_LinesCountEmptyFile() {
		createFileMockObj.execute(initialDirectory, "file");
		String errorMessage = "";
		String result = "";
		try {
			result = wordCountObj.execute(terminalObject, "-l", "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals(Integer.toString(0), result);
	}

	@Test
	void test4_LinesCountNonEmptyFile() {
		createFileMockObj.execute(initialDirectory, "file");
		writeToFileMockObj.execute(initialDirectory, "file", 12, "This is a file.");

		String errorMessage = "";
		String result = "";
		try {
			result = wordCountObj.execute(terminalObject, "-l", "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals(Integer.toString(12), result);
	}

	@Test
	void test5_WordsCountText() {
		String errorMessage = "";
		String result = "";
		try {
			result = wordCountObj.execute(terminalObject, "f2 f3", "f3", "f4");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals(Integer.toString(4), result);
	}

	@Test
	void test6_LinesCountText() {
		String errorMessage = "";
		String result = "";
		try {
			result = wordCountObj.execute(terminalObject, "-l",
					"Testing function\n to count number of lines\n in text");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals(Integer.toString(3), result);
	}

	@Test
	void test7_TryToCountWordsInMoreThanOneFile() {
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		String errorMessage = "";
		try {
			wordCountObj.execute(terminalObject, "firstFile", "secondFile");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		assertEquals("wc: too many arguments: type only one file name ", errorMessage);
	}

	@Test
	void test8_TryToCountLinesInMoreThanOneFile() {
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		String errorMessage = "";
		try {
			wordCountObj.execute(terminalObject, "-l", "firstFile", "secondFile");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		assertEquals("wc -l: too many arguments: type only one file name ", errorMessage);
	}
}
