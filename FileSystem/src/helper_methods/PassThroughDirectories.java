package helper_methods;

import exceptions.MyException;
import mainpackage.TreeNode;

public class PassThroughDirectories {
	public static void passingThroughDirectories(String[] directories, TreeNode currentDirectory) throws MyException {

		for (int i = 0; i < directories.length - 1; i++) {
			String directory = directories[i];

			if (directory.equals("..")) {
				currentDirectory = currentDirectory.getParent();
			} else if (!directory.equals(".")) {
				if (currentDirectory.getChildByName(directory) != null) {
					currentDirectory = currentDirectory.getChildByName(directory);
				} else {
					if (currentDirectory.getFileByName(directory) != null) {
						throw new MyException(directory + " : Not a directory");
					} else {
						throw new MyException(directory + " : No such file or directory");
					}
				}
			}
		}
	}
}
