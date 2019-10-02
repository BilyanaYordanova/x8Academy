package commands;

import java.util.TreeMap;

import exceptions.MyException;
import helper_methods.WriteToFileHelper;
import mainpackage.Terminal;
import mainpackage.TreeNode;

public class WriteToFile implements CommandExecution {

	@Override
	public String execute(Terminal object, String... arguments) throws MyException {
		TreeNode currentDirectory = object.getCurrentDirectory();

		if (arguments[0].equals("--overwrite")) {
			if (currentDirectory.getFileByName(arguments[1]) == null) {
				throw new MyException("write: " + arguments[1] + ": No such file");
			}
			TreeMap<Integer, String> file = currentDirectory.getFileByName(arguments[1]);

			int lineNumber = Integer.parseInt(arguments[2]);
			if (lineNumber < 1) {
				throw new MyException("Incorrect line number: use positive number ");
			}

			String lineContent = arguments[3];

			WriteToFileHelper.fillFileWithEmptyLines(file, lineNumber);
			file.put(lineNumber, lineContent);

			WriteToFileHelper.appendFileContent(4, lineNumber, file, arguments);
		} else {
			if (currentDirectory.getFileByName(arguments[0]) == null) {
				throw new MyException("write: " + arguments[0] + ": No such file");
			}
			TreeMap<Integer, String> file = currentDirectory.getFileByName(arguments[0]);

			int lineNumber = Integer.parseInt(arguments[1]);
			if (lineNumber < 1) {
				throw new MyException("Incorrect line number: use positive number ");
			}

			String lineContent = arguments[2];

			WriteToFileHelper.fillFileWithEmptyLines(file, lineNumber);

			if (file.containsKey(lineNumber)) {
				WriteToFileHelper.appendFileContent(2, lineNumber, file, arguments);
			} else {
				file.put(lineNumber, lineContent);
				WriteToFileHelper.appendFileContent(3, lineNumber, file, arguments);
			}
		}
		return "";
	}
}
