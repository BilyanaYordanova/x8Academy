package package1;

public class EqualSumSides {

	public boolean equalSumSides(int[] numbers) {

		for (int i = 0; i < numbers.length; i++) {
			int sumLeftSide = 0, sumRightSide = 0;
			for (int j = 0; j < i; j++) {
				sumLeftSide += numbers[j];
			}
			for (int k = i + 1; k < numbers.length; k++) {
				sumRightSide += numbers[k];
			}
			if (sumLeftSide == sumRightSide) {
				return true;
			}
		}
		return false;
	}
}
