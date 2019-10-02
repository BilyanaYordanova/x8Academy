package commands;

import exceptions.MyException;
import helper_methods.NumberOfArgumentsChecking;
import mainpackage.Terminal;
import mainpackage.TreeNode;

public class ChangeDirectory implements CommandExecution {

	@Override
	public String execute(Terminal object, String... arguments) throws MyException {

		NumberOfArgumentsChecking.printErrorMessage(arguments, 1,
				"cd: too many arguments: type only one directory name ");

		String[] directories = arguments[0].split("\\/");
		TreeNode currentDirectory;

		for (int i = 0; i < directories.length; i++) {
			currentDirectory = object.getCurrentDirectory();
			String directory = directories[i];

			if (directory.equals("..")) {
				object.setCurrentDirectory(currentDirectory.getParent());
			} else if (!directory.equals(".")) {
				if (currentDirectory.getChildByName(directory) != null) {
					object.setCurrentDirectory(currentDirectory.getChildByName(directory));
				} else {
					if (currentDirectory.getFileByName(directory) != null) {
						throw new MyException("cd: " + directory + " : Not a directory");
					} else {
						throw new MyException("cd: " + directory + " : No such file or directory");
					}
				}
			}
		}
		System.out.println("cd: current directory: " + object.getCurrentDirectory().getName());
		return "";
	}
}