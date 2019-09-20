package package1;

public class SumAllNumbersInString {

	public int sumOfNumbers(String input) {
		int sum = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				sum += Character.getNumericValue(input.charAt(i));
			}
		}

		return sum;
	}
}
