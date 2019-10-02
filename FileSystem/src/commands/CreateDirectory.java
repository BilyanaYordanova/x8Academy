package commands;

import exceptions.MyException;
import helper_methods.PassThroughDirectories;
import mainpackage.Terminal;
import mainpackage.TreeNode;

public class CreateDirectory implements CommandExecution {

	@Override
	public String execute(Terminal object, String... arguments) throws MyException {

		TreeNode currentDirectory;

		for (int j = 0; j < arguments.length; j++) {
			String[] directories = arguments[j].split("\\/");
			currentDirectory = object.getCurrentDirectory();

			PassThroughDirectories.passingThroughDirectories(directories, currentDirectory);

			String dirName = directories[directories.length - 1];

			if (currentDirectory.getChildByName(dirName) != null) {
				throw new MyException("mkdir: cannot create directory ‘" + dirName + "’: Directory exists");
			} else if (currentDirectory.getFileByName(dirName) != null) {
				throw new MyException("mkdir: cannot create directory ‘" + dirName + "’: File with this name exists");
			} else {
				currentDirectory.addChildByName(dirName);
			}
		}

		return "";
	}
}
