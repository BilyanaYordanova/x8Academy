package package1;

public class KthMinElementQuickSelect {

	public int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start;

		for (int j = start; j < end; j++) {
			if (array[j] <= pivot) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;

				i++;
			}
		}
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;

		return i;
	}

	public int kthMin(int k, int[] array, int start, int end) {
		int pivotIndex = partition(array, start, end);

		if (pivotIndex == k - 1) {
			return array[pivotIndex];
		} else if (pivotIndex > k - 1) {
			return kthMin(k, array, start, pivotIndex - 1);
		} else {
			return kthMin(k, array, pivotIndex + 1, end);
		}
	}
}
