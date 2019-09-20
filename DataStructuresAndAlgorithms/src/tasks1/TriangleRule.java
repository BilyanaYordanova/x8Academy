package tasks1;

public class TriangleRule {

	public int partition(int[] array, int left, int right) {

		int pivot = array[right];
		int j = (left - 1);
		for (int i = left; i <= right - 1; i++) {
			if (array[i] <= pivot) {
				j++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[j + 1];
		array[j + 1] = array[right];
		array[right] = temp;

		return j + 1;
	}

	public void quickSort(int[] array, int left, int right) {
		if (left < right) {

			int partition = partition(array, left, right);

			quickSort(array, 0, partition - 1);
			quickSort(array, partition + 1, right);
		}
	}

	public int[] threeNumbersCorrespondingTriangleRule(int[] array) {
		quickSort(array, 0, array.length - 1);
		int[] triangleNumbers = new int[3];

		for (int i = 0; i < array.length; i++) {
			if (i + 1 < array.length && i + 2 < array.length) {
				if (array[i] + array[i + 1] > array[i + 2]) {
					triangleNumbers[0] = array[i];
					triangleNumbers[1] = array[i + 1];
					triangleNumbers[2] = array[i + 2];
					break;
				}
			}

			if (i + 1 < array.length && i + 2 == array.length) {
				if (array[i] + array[i + 1] > array[0] && array[0] + array[i + 1] > array[i]
						&& array[i] + array[0] > array[i + 1]) {
					triangleNumbers[0] = array[i];
					triangleNumbers[1] = array[i + 1];
					triangleNumbers[2] = array[0];
					break;
				}
			}

			if (i + 1 == array.length && i + 2 == array.length + 1) {
				if (array[i] + array[0] > array[1] && array[i] + array[1] > array[0]
						&& array[0] + array[1] > array[i]) {
					triangleNumbers[0] = array[i];
					triangleNumbers[1] = array[0];
					triangleNumbers[2] = array[1];
					break;
				}
			}
		}
		return triangleNumbers;
	}
}
