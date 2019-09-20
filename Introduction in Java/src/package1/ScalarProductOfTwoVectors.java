package package1;

public class ScalarProductOfTwoVectors {

	public long scalarSum(int[] a, int[] b) {
		if (a.length == b.length) {
			long scalarProduct = 0;
			for (int i = 0; i < b.length; i++) {
				scalarProduct += a[i] * b[i];
			}
			return scalarProduct;
		} else
			return -1;
	}
}
