package package1;

import java.util.Arrays;

public class MaximumScalarProduct {

	public long maximalScalarSum(int[] a, int[] b) {
		if (a.length == b.length) {
			Arrays.sort(a);
			Arrays.sort(b);

			long result = 0;
			for (int i = 0; i < b.length; i++) {
				result += a[i] * b[i];
			}
			return result;
		} else
			return -1;
	}
}
