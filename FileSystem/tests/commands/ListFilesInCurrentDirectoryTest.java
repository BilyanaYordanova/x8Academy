package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MyException;
import mainpackage.Terminal;
import mainpackage.TreeNode;
import mockspackage.CreateFileMock;
import mockspackage.WriteToFileMock;

class ListFilesInCurrentDirectoryTest {
	ListFilesInCurrentDirectory listFilesObj = new ListFilesInCurrentDirectory();
	Terminal terminalObject = new Terminal();
	TreeNode initialDirectory = terminalObject.getCurrentDirectory();

	@Test
	void test1_ListFilesInEmptyDirectory() {
		String errorMessage = "";
		String result = "result";
		try {
			result = listFilesObj.execute(terminalObject);
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("", result);
	}

	@Test
	void test2_ListFilesInNonEmptyDirectory() {
		String errorMessage = "";
		String result = "";
		CreateFileMock createFileMockObj = new CreateFileMock();
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		try {
			result = listFilesObj.execute(terminalObject);
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("firstFile secondFile", result);
	}

	@Test
	void test3_ListFilesDescendingInEmptyDirectory() {
		String errorMessage = "";
		String result = "result";
		try {
			result = listFilesObj.execute(terminalObject, "--sorted", "desc");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("", result);
	}

	@Test
	void test4_ListFilesDescendingInNonEmptyDirectory() {
		String errorMessage = "";
		String result = "";
		CreateFileMock createFileMockObj = new CreateFileMock();
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		WriteToFileMock writeToFileMockObj = new WriteToFileMock();
		writeToFileMockObj.execute(initialDirectory, "firstFile", 2, "Hello");
		writeToFileMockObj.execute(initialDirectory, "secondFile", 2, "Hello World!");

		try {
			result = listFilesObj.execute(terminalObject, "--sorted", "desc");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("secondFile firstFile", result);
	}

	@Test
	void test5_TryToListFilesWithWrongArguments() {
		String errorMessage = "";
		try {
			listFilesObj.execute(terminalObject, "-sorted", "desc");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		assertEquals("ls : incorrect arguments ", errorMessage);
	}
}
