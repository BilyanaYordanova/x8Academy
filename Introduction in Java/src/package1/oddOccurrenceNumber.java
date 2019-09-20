package package1;

import java.util.LinkedHashMap;

public class oddOccurrenceNumber {

	public int getOddOccurrence(int[] array) {

		LinkedHashMap<Integer, Integer> occurrenceMap = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			if (occurrenceMap.containsKey(array[i])) {
				occurrenceMap.put(array[i], occurrenceMap.get(array[i]) + 1);
			} else {
				occurrenceMap.put(array[i], 1);
			}
		}

		for (int i : occurrenceMap.keySet()) {
			if (occurrenceMap.get(i) % 2 != 0) {
				return i;
			}
		}
		return -1;
	}
}
