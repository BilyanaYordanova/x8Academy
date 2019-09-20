package package1;

public class IsNumberPalindrome {

	public int digits(int number) {
		int digits = 0;
		while (number != 0) {
			digits += 1;
			number /= 10;
		}
		return digits;
	}

	public boolean isPalindrome(int argument) {
		int[] numArray = new int[digits(argument)];
		int k = 0;
		while (argument != 0) {
			numArray[k] = argument % 10;
			k++;
			argument /= 10;
		}

		int i = 0, j = numArray.length - 1;
		boolean flag = false;
		while (i <= j) {
			if (numArray[i] == numArray[j]) {
				flag = true;
			} else {
				flag = false;
				break;
			}
			i++;
			j--;
		}
		return flag;
	}
}
