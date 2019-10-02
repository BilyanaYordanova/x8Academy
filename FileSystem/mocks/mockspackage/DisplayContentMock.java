package mockspackage;

import java.util.TreeMap;

import mainpackage.TreeNode;

public class DisplayContentMock {
	public String execute(TreeNode currentDirectory, String fileName) {
		TreeMap<Integer, String> file = currentDirectory.getFileByName(fileName);
		StringBuilder fileContent = new StringBuilder("");

		for (Integer line : file.keySet()) {
			fileContent.append(file.get(line) + "\n");
		}

		return fileContent.toString();
	}
}
