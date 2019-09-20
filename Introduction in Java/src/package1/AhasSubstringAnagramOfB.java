package package1;

import package1.IsAnagram;

public class AhasSubstringAnagramOfB {

	public boolean hasAnagramOf(String A, String B) {
		IsAnagram obj = new IsAnagram();
		for (int i = 0; i < A.length(); i++) {
			for (int j = i + 1; j <= A.length(); j++) {
				if (obj.anagram(A.substring(i, j), B)) {
					return true;
				}
			}
		}
		return false;
	}
}