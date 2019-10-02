package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MyException;
import mainpackage.Terminal;
import mainpackage.TreeNode;
import mockspackage.CreateDirectoryMock;
import mockspackage.CreateFileMock;
import mockspackage.WriteToFileMock;

class DisplayContentTest {

	DisplayContent displayContentObj = new DisplayContent();
	Terminal terminalObject = new Terminal();
	TreeNode initialDirectory = terminalObject.getCurrentDirectory();

	@Test
	void test1_DisplayContentOfEmptyFile() {
		String errorMessage = "";
		String result = "result";
		CreateFileMock createFileMockObj = new CreateFileMock();
		createFileMockObj.execute(initialDirectory, "file");

		try {
			result = displayContentObj.execute(terminalObject, "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("", result);
	}

	@Test
	void test2_DisplayContentOfNonEmptyFile() {
		String errorMessage = "";
		String result = "";
		CreateFileMock createFileMockObj = new CreateFileMock();
		createFileMockObj.execute(initialDirectory, "file");

		WriteToFileMock writeToFileMockObj = new WriteToFileMock();
		writeToFileMockObj.execute(initialDirectory, "file", 3, "Hello World!");

		try {
			result = displayContentObj.execute(terminalObject, "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("\n" + "\n" + "Hello World!\n", result);
	}

	@Test
	void test3_DisplayContentOfTwoNonEmptyFiles() {
		String errorMessage = "";
		String result = "";
		CreateFileMock createFileMockObj = new CreateFileMock();
		createFileMockObj.execute(initialDirectory, "firstFile");
		createFileMockObj.execute(initialDirectory, "secondFile");

		WriteToFileMock writeToFileMockObj = new WriteToFileMock();
		writeToFileMockObj.execute(initialDirectory, "firstFile", 2, "Hello World!");
		writeToFileMockObj.execute(initialDirectory, "secondFile", 3, "Testing Display Content Function.");

		try {
			result = displayContentObj.execute(terminalObject, ".././home/firstFile", "../home/./secondFile");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("\n" + "Hello World!\n" + "\n" + "\n" + "Testing Display Content Function.\n", result);
	}

	@Test
	void test4_TryToDisplayContentOfDirectory() {
		CreateDirectoryMock createDirMockObj = new CreateDirectoryMock();
		createDirMockObj.execute(initialDirectory, "directory");
		String errorMessage = "";
		try {
			displayContentObj.execute(terminalObject, "directory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("cat: directory: Is a directory", errorMessage);
	}

	@Test
	void test5_TryToDisplayContentOfFileWhichDoesntExist() {
		String errorMessage = "";
		try {
			displayContentObj.execute(terminalObject, "nonExisitngFile");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("cat: nonExisitngFile: No such file", errorMessage);
	}
}
