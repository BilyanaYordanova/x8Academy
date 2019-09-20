package package1;

public class SmallestMultiple {

	public long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	public long getSmallestMultiple(int N) {
		long multiple = 1;

		for (int i = 2; i <= N; i++) {
			multiple *= i / gcd(i, multiple);
		}

		return multiple;
	}
}
