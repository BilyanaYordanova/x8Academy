package package1;

import java.util.Map;
import java.util.HashMap;

public class MaxSpan {

	public int maxSpan(int[] numbers) {
		Map<Integer, Integer> occurenceMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (occurenceMap.containsKey(numbers[i])) {
				occurenceMap.put(numbers[i], occurenceMap.get(numbers[i]) + 1);
			} else {
				occurenceMap.put(numbers[i], 1);
			}
		}

		Map<Integer, Integer> newMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int occurrence = occurenceMap.get(numbers[i]);
			if (newMap.containsKey(numbers[i])) {
				continue;
			} else {
				if (occurrence == 1) {
					newMap.put(numbers[i], 1);
				} else {
					int span = 1;
					for (int j = i + 1; j < numbers.length; j++) {
						if (occurrence <= 1) {
							break;
						}
						if (numbers[j] == numbers[i]) {
							occurrence--;
						}
						span += 1;
					}
					newMap.put(numbers[i], span);
				}
			}
		}

		int maxSpan = 1;
		for (Integer i : newMap.keySet()) {
			if (newMap.get(i) > maxSpan) {
				maxSpan = newMap.get(i);
			}
		}
		return maxSpan;
	}
}
