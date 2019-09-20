package package1;

public class KthFactorial {

	public long kthFac(int k, long n) {
		long result = 1;
		for (int i = 0; i < k; i++) {
			while (n > 0) {
				result *= n;
				n--;
			}
			n = result;
			result = 1;
		}
		return n;
	}
}
