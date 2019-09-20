package package1;

//import java.util.Arrays;

public class KthMinElement {

	public int getItself(int itself, int dummy) {
		return itself;
	}

	public void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					array[j] = getItself(array[j + 1], array[j + 1] = array[j]);
				}
			}
		}
	}

	public int kthMin(int k, int[] array) {
		bubbleSort(array);
		// Arrays.sort(array);
		return array[k - 1];
	}
}
