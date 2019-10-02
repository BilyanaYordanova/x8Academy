package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MyException;
import mainpackage.Terminal;
import mainpackage.TreeNode;
import mockspackage.CreateFileMock;
import mockspackage.DisplayContentMock;

class WriteToFileTest {

	WriteToFile writeFileObj = new WriteToFile();
	Terminal terminalObject = new Terminal();
	TreeNode initialDirectory = terminalObject.getCurrentDirectory();
	CreateFileMock createFileMockObj = new CreateFileMock();
	DisplayContentMock displayContentMockObj = new DisplayContentMock();

	@Test
	void test1_WriteToFile() {
		createFileMockObj.execute(initialDirectory, "file");
		String errorMessage = "";
		String result = "result";

		try {
			result = writeFileObj.execute(terminalObject, "file", "2", "Hello World!");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("", result);
		assertEquals("\n" + "Hello World!\n", displayContentMockObj.execute(initialDirectory, "file"));
	}

	@Test
	void test2_WriteToFileMultipleTimes() {
		createFileMockObj.execute(initialDirectory, "file");
		String errorMessage = "";

		try {
			writeFileObj.execute(terminalObject, "file", "2", "Hello World!");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		try {
			writeFileObj.execute(terminalObject, "file", "4", "This is a file.");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("\n" + "Hello World!\n" + "\n" + "This is a file.\n",
				displayContentMockObj.execute(initialDirectory, "file"));
	}

	@Test
	void test3_WriteOverwriteToFile() {
		createFileMockObj.execute(initialDirectory, "file");
		String result = "result";
		String errorMessage = "";

		try {
			result = writeFileObj.execute(terminalObject, "file", "2", "Hello World!");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("", result);
		assertEquals("\n" + "Hello World!\n", displayContentMockObj.execute(initialDirectory, "file"));

		try {
			result = writeFileObj.execute(terminalObject, "--overwrite", "file", "2", "This is a file.");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		
		assertEquals("", errorMessage);
		assertEquals("", result);
		assertEquals("\n" + "This is a file.\n", displayContentMockObj.execute(initialDirectory, "file"));
	}

	@Test
	void test4_TryToWriteToFileWhenGivenNegativeLineNumber() {
		createFileMockObj.execute(initialDirectory, "file");
		String errorMessage = "";

		try {
			writeFileObj.execute(terminalObject, "file", "-2", "Hello World!");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("Incorrect line number: use positive number ", errorMessage);
	}

	@Test
	void test5_TryToWriteOverwriteToFileWhenGivenNegativeLineNumber() {
		createFileMockObj.execute(initialDirectory, "file");
		String errorMessage = "";

		try {
			writeFileObj.execute(terminalObject, "--overwrite", "file", "-5", "Hello World!");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("Incorrect line number: use positive number ", errorMessage);
	}

	@Test
	void test6_WriteToFileWhichDoesntExist() {
		String errorMessage = "";
		try {
			writeFileObj.execute(terminalObject, "file", "2", "hello");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		assertEquals("write: file: No such file", errorMessage);
	}

	@Test
	void test7_WriteOverwriteToFileWhichDoesntExist() {
		String errorMessage = "";
		try {
			writeFileObj.execute(terminalObject, "--overwrite", "file", "2", "hello");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		assertEquals("write: file: No such file", errorMessage);
	}

}
