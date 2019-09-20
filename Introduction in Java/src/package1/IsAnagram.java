package package1;

import java.util.Map;
import java.util.HashMap;

public class IsAnagram {

	public boolean anagram(String A, String B) {
		Map<Character, Integer> stringAMap = new HashMap<Character, Integer>();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == ' ') {
				continue;
			}
			if (stringAMap.containsKey(A.charAt(i))) {
				stringAMap.put(A.charAt(i), stringAMap.get(A.charAt(i)) + 1);
			} else {
				stringAMap.put(A.charAt(i), 1);
			}
		}

		Map<Character, Integer> stringBMap = new HashMap<Character, Integer>();
		for (int i = 0; i < B.length(); i++) {
			if (B.charAt(i) == ' ') {
				continue;
			}
			if (stringBMap.containsKey(B.charAt(i))) {
				stringBMap.put(B.charAt(i), stringBMap.get(B.charAt(i)) + 1);
			} else {
				stringBMap.put(B.charAt(i), 1);
			}
		}

		boolean flag = false;
		if (stringAMap.size() != stringBMap.size()) {
			return false;
		} else {
			for (Character c : stringAMap.keySet()) {
				if (stringBMap.containsKey(c)) {
					if (stringAMap.get(c) == stringBMap.get(c)) {
						flag = true;
					} else {
						flag = false;
						return flag;
					}
				} else {
					return false;
				}
			}
		}
		return flag;
	}
}
