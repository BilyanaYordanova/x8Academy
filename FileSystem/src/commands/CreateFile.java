package commands;

import java.util.TreeMap;

import exceptions.MyException;
import helper_methods.PassThroughDirectories;
import mainpackage.Terminal;
import mainpackage.TreeNode;

public class CreateFile implements CommandExecution {

	@Override
	public String execute(Terminal object, String... arguments) throws MyException {

		TreeNode currentDirectory;

		for (int j = 0; j < arguments.length; j++) {
			String[] directories = arguments[j].split("\\/");
			currentDirectory = object.getCurrentDirectory();

			PassThroughDirectories.passingThroughDirectories(directories, currentDirectory);

			String fileName = directories[directories.length - 1];

			if (currentDirectory.getFileByName(fileName) != null) {
				throw new MyException("create_file: cannot create file ‘" + fileName + "’: File exists");
			} else if (currentDirectory.getChildByName(fileName) != null) {
				throw new MyException(
						"create_file: cannot create file ‘" + fileName + "’: Directory with this name exists");
			} else {
				TreeMap<Integer, String> file = new TreeMap<Integer, String>();
				currentDirectory.addFile(fileName, file);
			}
		}

		return "";
	}
}
