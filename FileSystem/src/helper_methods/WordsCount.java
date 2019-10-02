package helper_methods;

import java.util.TreeMap;

import exceptions.MyException;
import mainpackage.TreeNode;

public class WordsCount {
	public static int getWordsCount(TreeNode currentLocation, int wordsCount, String... arguments) throws MyException {
		if (currentLocation.getFileByName(arguments[0]) != null) {

			NumberOfArgumentsChecking.printErrorMessage(arguments, 1,
					"wc: too many arguments: type only one file name ");

			TreeMap<Integer, String> file = currentLocation.getFileByName(arguments[0]);

			for (Integer line : file.keySet()) {
				String textOnThisLine = file.get(line);
				if (!textOnThisLine.equals("")) {
					String[] splitText = textOnThisLine.split("\\s+");
					wordsCount += splitText.length;
				}
			}
		} else {
			for (int i = 0; i < arguments.length; i++) {
				String[] splitArgument = arguments[i].split("\\s+");
				for (int j = 0; j < splitArgument.length; j++) {
					if (!splitArgument[j].equals("")) {
						wordsCount++;
					}
				}
			}
		}
		return wordsCount;
	}
}
