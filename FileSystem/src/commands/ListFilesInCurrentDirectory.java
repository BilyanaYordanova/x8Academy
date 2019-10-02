package commands;

import java.util.HashMap;
import java.util.TreeMap;

import exceptions.MyException;
import helper_methods.ListFilesDescending;
import mainpackage.Terminal;
import mainpackage.TreeNode;

public class ListFilesInCurrentDirectory implements CommandExecution {

	@Override
	public String execute(Terminal object, String... arguments) throws MyException {
		TreeNode currentDirectory = object.getCurrentDirectory();
		HashMap<String, TreeMap<Integer, String>> files = currentDirectory.getFiles();
		StringBuilder result = new StringBuilder("");

		// only list files
		if (arguments.length == 0) {
			for (String file : files.keySet()) {
				result.append(file + " ");
			}
			if (result.length() > 0) {
				result.deleteCharAt(result.length() - 1);
			}
		}
		// list files in descending order
		else if (arguments.length == 2 && arguments[0].equals("--sorted") && arguments[1].equals("desc")) {

			ListFilesDescending lsFileDescendingObject = new ListFilesDescending();
			return lsFileDescendingObject.listFilesDescending(currentDirectory, files);
		} else {
			throw new MyException("ls : incorrect arguments ");
		}

		return result.toString();
	}
}
