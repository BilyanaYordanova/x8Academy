package mockspackage;

import java.util.TreeMap;

import mainpackage.TreeNode;

public class WriteToFileMock {
	public String execute(TreeNode currentDirectory, String fileName, int lineNumber, String content) {
		TreeMap<Integer, String> file = currentDirectory.getFileByName(fileName);
		for (int i = 1; i < lineNumber; i++) {
			file.put(i, "");
		}
		file.put(lineNumber, content);
		return "";
	}
}
