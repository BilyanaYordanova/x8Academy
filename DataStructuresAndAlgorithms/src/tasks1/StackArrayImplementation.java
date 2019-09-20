package tasks1;

import java.util.Arrays;

public class StackArrayImplementation {

	// fields
	private static final int INITIALSIZE = 10;
	private Object[] stack;
	private int numElements;

	// methods
	public StackArrayImplementation() {
		stack = new Object[INITIALSIZE];
		numElements = 0;
	}

	public void push(Object element) {
		if (numElements == stack.length) {
			resize();
		}
		stack[numElements] = element;
		numElements++;
	}

	public Object pop() {
		if (!isEmpty()) {
			numElements--;
			return stack[numElements];
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public Object peek() {
		if (!isEmpty()) {
			return stack[numElements - 1];
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public boolean isEmpty() {
		if (numElements == 0)
			return true;
		else
			return false;
	}

	public int getSize() {
		return numElements;
	}

	private void resize() {
		int newSize = stack.length * 2;
		stack = Arrays.copyOf(stack, newSize);
		// System.out.println("New length: " + stack.length);
	}
}
