package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MyException;
import mainpackage.Terminal;
import mainpackage.TreeNode;
import mockspackage.CreateFileMock;
import mockspackage.WriteToFileMock;

class PipeTest {

	Pipe pipeObject = new Pipe();
	Terminal terminalObject = new Terminal();
	TreeNode initialDirectory = terminalObject.getCurrentDirectory();
	CreateFileMock createFileMockObj = new CreateFileMock();
	WriteToFileMock writeToFileMockObj = new WriteToFileMock();

	@Test
	void test1() {
		String errorMessage = "";
		String result = "";
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		writeToFileMockObj.execute(initialDirectory, "firstFile", 2, "hello");
		writeToFileMockObj.execute(initialDirectory, "secondFile", 2, "world");

		try {
			result = pipeObject.execute(terminalObject, "ls", "|", "cat");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("\n" + "hello\n" + "\n" + "world\n", result);
	}

	@Test
	void test2() {
		String errorMessage = "";
		String result = "";
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		writeToFileMockObj.execute(initialDirectory, "firstFile", 2, "hello");
		writeToFileMockObj.execute(initialDirectory, "secondFile", 2, "new world");

		try {
			result = pipeObject.execute(terminalObject, "ls", "--sorted", "desc", "|", "cat");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("\n" + "new world\n" + "\n" + "hello\n", result);
	}

	@Test
	void test3() {
		String errorMessage = "";
		String result = "";
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		writeToFileMockObj.execute(initialDirectory, "firstFile", 2, "hello");
		writeToFileMockObj.execute(initialDirectory, "secondFile", 2, "new world");

		try {
			result = pipeObject.execute(terminalObject, "ls", "--sorted", "desc", "|", "cat", "|", "wc");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals(Integer.toString(3), result);
	}

	@Test
	void test4() {
		String errorMessage = "";
		String result = "";
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		writeToFileMockObj.execute(initialDirectory, "firstFile", 2, "hello");
		writeToFileMockObj.execute(initialDirectory, "secondFile", 2, "new world");

		try {
			result = pipeObject.execute(terminalObject, "ls", "|", "cat", "|", "wc", "-l");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals(Integer.toString(4), result);
	}

	@Test
	void test5_TestingWrongCommandArguments() {
		String errorMessage = "";
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		writeToFileMockObj.execute(initialDirectory, "firstFile", 2, "hello");
		writeToFileMockObj.execute(initialDirectory, "secondFile", 2, "new world");

		try {
			pipeObject.execute(terminalObject, "ls", "-sorted", "desc", "|", "cat", "|", "wc", "-l");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("ls : incorrect arguments ", errorMessage);
	}

	@Test
	void test6_TestingWrongCommands() {
		String errorMessage = "";
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		writeToFileMockObj.execute(initialDirectory, "firstFile", 2, "hello");
		writeToFileMockObj.execute(initialDirectory, "secondFile", 2, "new world");

		try {
			pipeObject.execute(terminalObject, "lss", "|", "cat", "|", "wc", "-l");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("lss: command not found", errorMessage);
	}
}
