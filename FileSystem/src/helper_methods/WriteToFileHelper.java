package helper_methods;

import java.util.TreeMap;

public class WriteToFileHelper {

	public static void fillFileWithEmptyLines(TreeMap<Integer, String> file, int lineNumber) {
		for (int i = 1; i < lineNumber; i++) {
			if (!file.containsKey(i)) {
				file.put(i, "");
			}
		}
	}

	public static void appendFileContent(int index, int lineNumber, TreeMap<Integer, String> file,
			String... arguments) {
		while (index < arguments.length) {
			if (file.get(lineNumber).equals("")) {
				file.put(lineNumber, arguments[index]);
			} else {
				file.put(lineNumber, file.get(lineNumber) + " " + arguments[index]);
			}
			index++;
		}
	}
}
