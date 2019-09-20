package package1;

public class StringReverse {

	public String reverse(String argument) {

		StringBuilder reverse = new StringBuilder();
		for (int i = argument.length() - 1; i >= 0; i--) {
			reverse.append(argument.charAt(i));
		}
		return reverse.toString();
	}
}
