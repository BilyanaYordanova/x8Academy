package package1;

public class IsStringPalindrome {

	public String reverse(String argument) {
		char[] stringToChar = argument.toCharArray();
		char[] reversedCharArray = new char[stringToChar.length];

		int j = 0;
		for (int i = stringToChar.length - 1; i >= 0; i--) {
			reversedCharArray[j] = stringToChar[i];
			j++;
		}

		String result = "";
		for (int i = 0; i < reversedCharArray.length; i++) {
			result += reversedCharArray[i];
		}

		return result;
	}

	public boolean isPalindrome(String argument) {
		if (argument.equals(reverse(argument))) {
			return true;
		}
		return false;
	}
}
