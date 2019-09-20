package package1;

public class minElementArray {

	public int min(int array[]) {
		int minNum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < minNum) {
				minNum = array[i];
			}
		}
		return minNum;
	}
}
