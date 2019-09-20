package package1;

public class ReverseEachWordInString {

	public String reverse(String argument) {

		StringBuilder reverse = new StringBuilder();
		for (int i = argument.length() - 1; i >= 0; i--) {
			reverse.append(argument.charAt(i));
		}
		return reverse.toString();
	}

	public String reverseEveryWord(String arg) {
		int length = arg.length();
		int i = 0;
		StringBuilder reversed = new StringBuilder();
		StringBuilder str = new StringBuilder();

		while (length > 0) {
			while (arg.charAt(i) != ' ') {
				str.append(arg.charAt(i));
				i++;
				length--;
				if (i == arg.length()) {
					break;
				}
			}

			reversed.append(reverse(str.toString()));
			reversed.append(" ");
			i++;
			length--;
			str = new StringBuilder();
		}

		reversed.deleteCharAt(reversed.length() - 1);
		return reversed.toString();
	}
}
