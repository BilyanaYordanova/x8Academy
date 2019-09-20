package tasks1;

public class DecimalToBinary {

	public int[] decimalToBinary(int number) {

		StackLinkedListImplementation stackLL = new StackLinkedListImplementation();

		if (number == 0) {
			return new int[] { 0 };
		}

		while (number > 0) {
			stackLL.push(number % 2);
			number /= 2;
		}

		int[] array = new int[stackLL.getSize()];
		int i = 0;
		while (!stackLL.isEmpty()) {
			// System.out.print(stackLL.pop() + " ");
			array[i] = (int) stackLL.pop();
			i++;
		}
		return array;
	}
}
