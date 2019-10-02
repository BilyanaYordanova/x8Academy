package helper_methods;

import java.util.TreeMap;

import exceptions.MyException;
import mainpackage.TreeNode;

public class LinesCount {
	public static int getLinesCount(TreeNode currentDirectory, int linesCount, String... arguments) throws MyException {
		if (currentDirectory.getFileByName(arguments[1]) != null) {

			NumberOfArgumentsChecking.printErrorMessage(arguments, 2,
					"wc " + arguments[0] + ": too many arguments: type only one file name ");

			TreeMap<Integer, String> file = currentDirectory.getFileByName(arguments[1]);
			linesCount = file.keySet().size();

		} else {
			for (int i = 1; i < arguments.length; i++) {
				String[] lines = arguments[i].split("\r\n|\r|\n");
				linesCount += lines.length;
			}
		}
		return linesCount;
	}
}
