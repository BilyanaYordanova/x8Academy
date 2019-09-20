package package1;

public class DoubleFactorial {
	
	public long doubleFac(long n) {
		// if(n == 0) return 1;
		// else return n*doubleFac(n - 1);
		long result = 1;
		for(int i = 0; i < 2; i++) {
			while(n > 0) {
				result *= n;
				n--;
			}
			n = result;
			result = 1;
		}
		return n;
	}
}
