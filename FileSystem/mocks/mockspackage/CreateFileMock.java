package mockspackage;

import java.util.TreeMap;

import mainpackage.TreeNode;

public class CreateFileMock {
	public String execute(TreeNode currentDirectory, String fileName) {
		TreeMap<Integer, String> file = new TreeMap<Integer, String>();
		currentDirectory.addFile(fileName, file);
		return "";
	}
}
