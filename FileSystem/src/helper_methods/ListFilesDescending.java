package helper_methods;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import mainpackage.TreeNode;

public class ListFilesDescending {

	public String listFilesDescending(TreeNode currentDirectory, HashMap<String, TreeMap<Integer, String>> files) {
		Map<String, Integer> filesDescendingSize = new HashMap<>();
		StringBuilder result = new StringBuilder("");

		for (String file : files.keySet()) {
			filesDescendingSize.put(file, evaluateFileSize(file, currentDirectory));
		}

		filesDescendingSize = sortMapByValue(filesDescendingSize);

		for (String fileName : filesDescendingSize.keySet()) {
			result.append(fileName + " ");
		}
		if (result.length() > 0) {
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	public int evaluateFileSize(String fileName, TreeNode currentDirectory) {
		TreeMap<Integer, String> file = currentDirectory.getFileByName(fileName);
		int fileLines = file.size();
		int charactersNumber = 0;

		for (Integer i : file.keySet()) {
			charactersNumber += file.get(i).length();
		}
		return fileLines + charactersNumber;
	}

	public Map<String, Integer> sortMapByValue(Map<String, Integer> notSortedMap) {
		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
		notSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		return reverseSortedMap;
	}
}
