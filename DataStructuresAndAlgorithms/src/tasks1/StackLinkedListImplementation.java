package tasks1;

public class StackLinkedListImplementation {

	private LinkedList stack;

	public StackLinkedListImplementation() {
		stack = new LinkedList();
	}

	public void push(int element) {
		stack.insertAtStart(element);
	}

	public Object pop() {
		if (stack.isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			return stack.removeAndGetElementAtStart();
		}
	}

	public Object peek() {
		if (stack.isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			return stack.peekAtElementAtStart();
		}
	}

	public int getSize() {
		return stack.getNumElements();
	}

	public void print() {
		stack.print();
	}

	public boolean isEmpty() {
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
}
