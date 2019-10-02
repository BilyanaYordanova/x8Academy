package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MyException;
import mainpackage.Terminal;
import mainpackage.TreeNode;
import mockspackage.CreateDirectoryMock;

class CreateFileTest {

	CreateFile createFileObj = new CreateFile();
	Terminal terminalObject = new Terminal();
	TreeNode initialDirectory = terminalObject.getCurrentDirectory();

	@Test
	void test1_CreateNewFile() {
		String errorMessage = "";
		try {
			createFileObj.execute(terminalObject, "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertTrue(!initialDirectory.getFileByName("file").equals(null));
	}

	@Test
	void test2_CreateNewFiles1() {
		String errorMessage = "";
		String result = "result";
		try {
			result = createFileObj.execute(terminalObject, "firstFile", "secondFile");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertEquals("", result);
	}

	@Test
	void test3_CreateNewFiles2() {
		String errorMessage = "";
		try {
			createFileObj.execute(terminalObject, "firstFile", "secondFile");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertTrue(!initialDirectory.getFileByName("firstFile").equals(null));
		assertTrue(!initialDirectory.getFileByName("secondFile").equals(null));
	}

	@Test
	void test4_CreateNewFiles3() {
		String errorMessage = "";
		try {
			createFileObj.execute(terminalObject, "../home/./firstFile", ".././home/secondFile");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertTrue(!initialDirectory.getFileByName("firstFile").equals(null));
		assertTrue(!initialDirectory.getFileByName("secondFile").equals(null));
	}

	@Test
	void test5_TryToCreateFileWhichExists() {
		String errorMessage = "";
		try {
			createFileObj.execute(terminalObject, "file");
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		try {
			createFileObj.execute(terminalObject, ".././home/./file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		assertEquals("create_file: cannot create file ‘file’: File exists", errorMessage);
	}

	@Test
	void test6_TryToCreateFileWithNameOfExistingDirectory() {
		String errorMessage = "";
		CreateDirectoryMock createDirMockObj = new CreateDirectoryMock();
		createDirMockObj.execute(initialDirectory, "directory");

		try {
			createFileObj.execute(terminalObject, "directory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		assertEquals("create_file: cannot create file ‘directory’: Directory with this name exists", errorMessage);
	}

}
