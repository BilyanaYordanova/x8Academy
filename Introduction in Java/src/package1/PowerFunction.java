package package1;

public class PowerFunction {

	/*
	 * public long pow(int a, int b) { long result = 1; for(int i = 0; i < b; i++) {
	 * result *= a; } return result; }
	 */
	public long pow(int a, int b) {
		long result = 1;
		while (b > 0) {
			if (b % 2 != 0) {
				result *= a;
				b--;
			}
			a *= a;
			b /= 2;
		}
		return result;
	}
}
