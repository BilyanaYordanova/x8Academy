package package1;

public class LargestPalindromeNumberUpToN {

	public int digits(long number) {
		int digits = 0;
		while (number != 0) {
			digits += 1;
			number /= 10;
		}
		return digits;
	}

	public boolean isPalindrome(long argument) {
		long[] numArray = new long[digits(argument)];
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

	public long getLargestPalindrome(long N) {
		long maxPalindrome = 0;
		for (long i = 0; i < N; i++) {
			if (isPalindrome(i)) {
				if (i > maxPalindrome) {
					maxPalindrome = i;
				}
			}
		}
		return maxPalindrome;
	}
}
