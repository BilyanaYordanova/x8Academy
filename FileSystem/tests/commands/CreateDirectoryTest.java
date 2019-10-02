package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MyException;
import mainpackage.Terminal;
import mainpackage.TreeNode;
import mockspackage.CreateFileMock;

class CreateDirectoryTest {

	CreateDirectory createDirObj = new CreateDirectory();
	Terminal terminalObject = new Terminal();
	TreeNode initialDirectory = terminalObject.getCurrentDirectory();

	@Test
	void test1_CreateNewDirectory() {
		String errorMessage = "";
		try {
			createDirObj.execute(terminalObject, "newDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("", errorMessage);
		assertTrue(!initialDirectory.getChildByName("newDirectory").equals(null));
	}

	@Test
	void test2_CreateNewDirectories1() {
		String errorMessage = "";
		String result = " ";
		try {
			result = createDirObj.execute(terminalObject, "firstDirectory", "secondDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		
		assertEquals("", errorMessage);
		assertEquals("", result);
	}

	@Test
	void test3_CreateNewDirectories2() {
		String errorMessage = "";
		try {
			createDirObj.execute(terminalObject, "firstDirectory", "secondDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		
		assertEquals("", errorMessage);
		assertTrue(!initialDirectory.getChildByName("firstDirectory").equals(null));
		assertTrue(!initialDirectory.getChildByName("secondDirectory").equals(null));
	}

	@Test
	void test4_CreateNewDirectories3() {
		String errorMessage = "";
		try {
			createDirObj.execute(terminalObject, "../home/./firstDirectory", ".././home/secondDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		
		assertEquals("", errorMessage);
		assertTrue(!initialDirectory.getChildByName("firstDirectory").equals(null));
		assertTrue(!initialDirectory.getChildByName("secondDirectory").equals(null));
	}

	@Test
	void test5_TryToCreateDirectoryWhichExists() {
		String errorMessage = "";
		try {
			createDirObj.execute(terminalObject, "newDirectory");
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		try {
			createDirObj.execute(terminalObject, ".././home/./newDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		assertEquals("mkdir: cannot create directory ‘newDirectory’: Directory exists", errorMessage);
	}

	@Test
	void test6_TryToCreateDirectoryWithTheNameOfFileWhichExists() {
		String errorMessage = "";
		CreateFileMock createFileMockObject = new CreateFileMock();
		createFileMockObject.execute(initialDirectory, "file");

		try {
			createDirObj.execute(terminalObject, "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		assertEquals("mkdir: cannot create directory ‘file’: File with this name exists", errorMessage);
	}

}
