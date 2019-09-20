package package1;

public class CopyCharacterNTimes {

	public StringBuilder copyChars(String input, int k) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < k; i++) {
			result.append(input);
		}
		return result;
	}
}
