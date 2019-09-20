package tasks1;

public class SortedArrayFindMinMissing {

	public boolean binarySearch(int[] array, int left, int right, int number) {
		if (left <= right) {
			int middle = left + (right - left) / 2;

			if (array[middle] == number)
				return true;
			else if (array[middle] > number)
				return binarySearch(array, left, middle - 1, number);
			else
				return binarySearch(array, middle + 1, right, number);
		}
		return false;
	}

	public int minMissingSortedArray(int[] array) {

		for (int i = 1; i <= array.length - 1; i++) {
			// if number not found return it
			if (!binarySearch(array, 0, array.length - 1, i)) {
				return i;
			}
		}
		// if all the numbers are in the array
		return -1;
	}

//	public static void main(String[] args) {
//		SortedArrayFindMinMissing obj = new SortedArrayFindMinMissing();
//		//int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
//		int[] array = new int[] { 1,1,1,2,2,3,4,5};
//		
//		System.out.println(obj.minMissingSortedArray(array));
//	}

}
