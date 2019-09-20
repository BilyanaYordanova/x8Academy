package tasks1;

import java.util.HashSet;

public class FindMinMissing1ToN {

	public void merge(int[] array, int left, int middle, int right) {

		int sizeLeftArray = middle - left + 1;
		int sizeRightArray = right - middle;
		int k = left;
		int[] leftArray = new int[sizeLeftArray];
		int[] rightArray = new int[sizeRightArray];

		for (int i = 0; i < sizeLeftArray; i++) {
			leftArray[i] = array[left + i];
		}
		for (int j = 0; j < sizeRightArray; j++) {
			rightArray[j] = array[middle + 1 + j];
		}

		int i = 0, j = 0;
		while (i < sizeLeftArray && j < sizeRightArray) {
			if (leftArray[i] < rightArray[j]) {
				array[k++] = leftArray[i++];
			} else {
				array[k++] = rightArray[j++];
			}
		}

		while (i < sizeLeftArray) {
			array[k++] = leftArray[i++];
		}
		while (j < sizeRightArray) {
			array[k++] = rightArray[j++];
		}

	}

	public void mergeSort(int[] array, int left, int right) {
		if (left < right) {

			int middle = (left + right) / 2;
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);

			merge(array, left, middle, right);
		}
	}

	public int findMinMissing(int[] array) {
		mergeSort(array, 0, array.length - 1);
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		int k = 1;
		for (Integer item : set) {
			if (item != k)
				return k;
			else
				k++;
		}

		return k;
	}
}
