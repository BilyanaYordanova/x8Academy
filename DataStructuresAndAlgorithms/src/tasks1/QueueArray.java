package tasks1;

public class QueueArray {

	private static final int INITIALSIZE = 10;
	private Object[] queue;
	private int numElements;
	private int frontIndex, rearIndex;

	public QueueArray() {
		queue = new Object[INITIALSIZE];
		numElements = 0;
		frontIndex = rearIndex = 0;
	}

	public void enqueue(Object element) {
		if (numElements == queue.length) {
			resize();
		}
		if (rearIndex == queue.length - 1 && frontIndex != 0) {
			rearIndex = 0;
			queue[rearIndex] = element;
			rearIndex++;
			numElements++;
		} else {
			queue[rearIndex] = element;
			rearIndex++;
			numElements++;
		}
	}

	private void resize() {
		Object[] temp = new Object[2 * queue.length];
		System.arraycopy(queue, frontIndex, temp, frontIndex, queue.length - frontIndex);
		if (frontIndex != 0) {
			System.arraycopy(queue, 0, temp, queue.length, frontIndex);
		}
		queue = temp;
		rearIndex = frontIndex + numElements;
		// System.out.println("new length: " + queue.length);
	}

	public Object dequeue() {
		if (!isEmpty()) {
			numElements--;
			Object returnValue = queue[frontIndex];
			if (frontIndex == queue.length - 1)
				frontIndex = 0;
			else
				frontIndex++;
			return returnValue;
		} else
			return -1;
	}

	public void print() {
		if (frontIndex == 0) {
			for (int i = frontIndex; i < rearIndex; i++) {
				System.out.print(queue[i] + " ");
			}
		} else if (rearIndex < frontIndex) {
			for (int i = frontIndex; i < queue.length; i++) {
				System.out.print(queue[i] + " ");
			}
			for (int j = 0; j <= rearIndex; j++) {
				System.out.print(queue[j] + " ");
			}
		} else if (rearIndex < queue.length) {
			for (int i = frontIndex; i < rearIndex; i++) {
				System.out.print(queue[i] + " ");
			}
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
}
