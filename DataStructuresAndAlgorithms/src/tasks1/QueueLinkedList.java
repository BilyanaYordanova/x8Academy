package tasks1;

public class QueueLinkedList {

	private LinkedList queue;

	public QueueLinkedList() {
		queue = new LinkedList();
	}

	public void enqueue(int element) {
		queue.insertAtEnd(element);
	}

	public Object dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return queue.removeAndGetElementAtStart();
	}

	public void print() {
		queue.print();
	}

	public boolean isEmpty() {
		if (queue.isEmpty())
			return true;
		else
			return false;
	}

	public int getSize() {
		return queue.getNumElements();
	}
}
