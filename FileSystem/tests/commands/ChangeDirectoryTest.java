package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MyException;
import mainpackage.Terminal;
import mainpackage.TreeNode;
import mockspackage.CreateDirectoryMock;
import mockspackage.CreateFileMock;

class ChangeDirectoryTest {

	ChangeDirectory changeDirectoryObject = new ChangeDirectory();
	Terminal terminalObject = new Terminal();
	TreeNode initialDirectory = terminalObject.getCurrentDirectory();
	CreateDirectoryMock createDirMockObject = new CreateDirectoryMock();
	CreateFileMock createFileMockObject = new CreateFileMock();

	@Test
	void test1_StayingInCurrentDirectory() {
		String errorMessage = "";
		try {
			changeDirectoryObject.execute(terminalObject, ".");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertEquals("",errorMessage);
		assertTrue(initialDirectory.equals(changedDirectory));
	}

	@Test
	void test2_StayingInCurrentDirectory() {
		String errorMessage = "";
		try {
			changeDirectoryObject.execute(terminalObject, "./././.");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertEquals("",errorMessage);
		assertTrue(initialDirectory.equals(changedDirectory));
	}

	@Test
	void test3_GoingBackwards() {
		String errorMessage = "";
		try {
			changeDirectoryObject.execute(terminalObject, "..");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertEquals("",errorMessage);
		assertTrue(changedDirectory.equals(initialDirectory.getParent()));
	}

	@Test
	void test4_ChangeDirectoryToExistingChildDirectory() {
		String errorMessage = "";
		createDirMockObject.execute(initialDirectory, "childDirectory");
		try {
			changeDirectoryObject.execute(terminalObject, "childDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertEquals("",errorMessage);
		assertTrue(changedDirectory.equals(initialDirectory.getChildByName("childDirectory")));
	}

	@Test
	void test5_GoBackwardsManyTimesFromHome() {		
		String errorMessage = "";
		try {
			changeDirectoryObject.execute(terminalObject, "../../../../..");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertEquals("",errorMessage);
		assertTrue(changedDirectory.equals(initialDirectory.getParent()));
	}

	@Test
	void test6_TryToChangeDirectoryToNonExistingDirectory() {
		String errorMessage = "";
		try {
			changeDirectoryObject.execute(terminalObject, "nonExistingDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}
		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertTrue(changedDirectory.equals(initialDirectory));
		assertEquals("cd: nonExistingDirectory : No such file or directory", errorMessage);
	}

	@Test
	void test7_TryToChangeDirectoryToPathWithWrongSideOfSlashes() {
		String errorMessage = "";
		try {
			changeDirectoryObject.execute(terminalObject, "\\..\\..");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertTrue(changedDirectory.equals(initialDirectory));
		assertEquals("cd: \\..\\.. : No such file or directory", errorMessage);
	}

	@Test
	void test8_TryToChangeDirectoryToExistingFile() {
		createFileMockObject.execute(initialDirectory, "file");
		String errorMessage = "";
		try {
			changeDirectoryObject.execute(terminalObject, "file");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertTrue(changedDirectory.equals(initialDirectory));
		assertEquals("cd: file : Not a directory", errorMessage);
	}

	@Test
	void test9_TryToChangeDirectoryUsingMoreThanOneArgument() {
		String errorMessage = "";
		try {
			changeDirectoryObject.execute(terminalObject, "firstDirectory", "secondDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertTrue(changedDirectory.equals(initialDirectory));
		assertEquals("cd: too many arguments: type only one directory name ", errorMessage);
	}

	@Test
	void test10_TryToChangeDirectoryToExistingChildFolder_MoreThanOneArgument() {
		String errorMessage = "";
		createDirMockObject.execute(initialDirectory, "firstDirectory");
		try {
			changeDirectoryObject.execute(terminalObject, "firstDirectory", "secondDirectory");
		} catch (MyException e) {
			errorMessage = e.getMessage();
		}

		TreeNode changedDirectory = terminalObject.getCurrentDirectory();
		assertTrue(changedDirectory.equals(initialDirectory));
		assertEquals("cd: too many arguments: type only one directory name ", errorMessage);
	}
}
