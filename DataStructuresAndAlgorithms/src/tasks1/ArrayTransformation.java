package tasks1;

public class ArrayTransformation {

	public int[] transformArray(int[] array) {
		int[] transformedArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					transformedArray[i] = array[j];
					break;
				} else if (transformedArray[i] != -1)
					transformedArray[i] = -1;
			}
			if (i == array.length - 1) {
				transformedArray[i] = -1;
			}
		}

		for (int i = 0; i < transformedArray.length; i++) {
			System.out.print(transformedArray[i] + " ");
		}
		return transformedArray;
	}
}
