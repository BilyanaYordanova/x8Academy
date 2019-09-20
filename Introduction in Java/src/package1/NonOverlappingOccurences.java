package package1;

public class NonOverlappingOccurences {

	public int mentions(String word, String text) {
		int i = 0, j = 0, counter = 0;
		boolean flag = false;

		while (i < text.length() - 1) {
			if (text.charAt(i) == word.charAt(j)) {
				i++;
				j++;
				while (j < word.length()) {
					if (text.charAt(i) == word.charAt(j)) {
						i++;
						j++;
						flag = true;
					} else {
						flag = false;
						break;
					}
				}
			} else {
				flag = false;
			}
			if (flag == true) {
				counter++;
				j = 0;
			} else {
				i++;
			}
		}
		return counter;
	}
}
