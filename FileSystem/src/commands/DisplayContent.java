package commands;

import java.util.TreeMap;

import exceptions.MyException;
import helper_methods.PassThroughDirectories;
import mainpackage.Terminal;
import mainpackage.TreeNode;

public class DisplayContent implements CommandExecution {

	@Override
	public String execute(Terminal object, String... arguments) throws MyException {

		TreeNode currentDirectory;
		StringBuilder fileContent = new StringBuilder("");

		for (int i = 0; i < arguments.length; i++) {
			String[] currentArgument = arguments[i].split("\r\n|\r|\n| ");

			for (int j = 0; j < currentArgument.length; j++) {
				String[] directories = currentArgument[j].split("\\/");
				currentDirectory = object.getCurrentDirectory();

				PassThroughDirectories.passingThroughDirectories(directories, currentDirectory);

				String fileName = directories[directories.length - 1];

				if (currentDirectory.getFileByName(fileName) != null) {
					TreeMap<Integer, String> file = currentDirectory.getFileByName(fileName);

					for (Integer line : file.keySet()) {
						fileContent.append(file.get(line) + "\n");
					}
				} else if (currentDirectory.getChildByName(fileName) != null) {
					throw new MyException("cat: " + fileName + ": Is a directory");
				} else {
					throw new MyException("cat: " + fileName + ": No such file");
				}
			}
		}

		return fileContent.toString();
	}
}
