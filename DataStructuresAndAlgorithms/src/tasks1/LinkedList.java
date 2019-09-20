package tasks1;

public class LinkedList {

	private Node head;
	private Node tail;
	private int numElements = 0;

	public LinkedList() {
		head = null;
		tail = null;
	}

	private void ifEmptyHelper(Node temp) {
		head = temp;
		tail = temp;
		temp = null;
	}

	public int getNumElements() {
		return numElements;
	}

	public void insertAtStart(int data) {
		Node temp = new Node(data, null);
		if (isEmpty()) {
			ifEmptyHelper(temp);
			numElements++;
		} else {
			temp.setNext(head);
			head = temp;
			numElements++;
		}
	}

	public void insertAtPosition(int positionIndex, int data) {
		Node temp = new Node(data, null);
		if (isEmpty()) {
			ifEmptyHelper(temp);
			numElements++;
		} else {
			if (positionIndex > 0 && positionIndex <= numElements) {
				Node prev = new Node();
				Node next = head;

				for (int i = 0; i < positionIndex; i++) {
					prev = next;
					next = next.getNext();
				}

				prev.setNext(temp);
				temp.setNext(next);
				numElements++;
			} else {
				System.out.println("Not valid position");
				return;
			}
		}
	}

	public void insertAtEnd(int data) {
		Node temp = new Node(data, null);
		if (isEmpty()) {
			ifEmptyHelper(temp);
			numElements++;
		} else {
			tail.setNext(temp);
			tail = temp;
			numElements++;
		}
	}

	public void removeAtStart() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		} else {
			head = head.getNext();
			numElements--;
		}
	}

	// used for stack linked list implementation
	public Object removeAndGetElementAtStart() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return -1;
		} else {
			int number = head.getData();
			head = head.getNext();
			numElements--;
			return number;
		}
	}

	// used for stack linked list implementation
	public Object peekAtElementAtStart() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return -1;
		} else {
			return head.getData();
		}
	}

	public void removeAtPosition(int positionIndex) {
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		} else {
			if (positionIndex > 0 && positionIndex <= numElements - 1) {
				Node prev = new Node();
				Node cur = head;

				for (int i = 0; i < positionIndex; i++) {
					prev = cur;
					cur = cur.getNext();
				}

				prev.setNext(cur.getNext());
				numElements--;
			} else {
				System.out.println("Not valid position");
				return;
			}
		}
	}

	public void removeAtEnd() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		} else {
			Node prev = new Node();
			Node cur = head;
			while (cur.getNext() != null) {
				prev = cur;
				cur = cur.getNext();
			}
			tail = prev;
			prev.setNext(null);
			cur = null;
			numElements--;
		}
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public void print() {
		if (isEmpty()) {
			return;
		}
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.getData() + " ");
			cur = cur.getNext();
		}
		System.out.println();
	}

	public boolean search(int data) {
		Node cur = head;
		while (cur != null) {
			if (cur.getData() == data) {
				return true;
			}
			cur = cur.getNext();
		}
		return false;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		LinkedList obj = new LinkedList();
//		obj.insertAtStart(21);
//		obj.insertAtStart(31);
//		obj.insertAtStart(43);
//		obj.insertAtEnd(83);
//		obj.insertAtPosition(4, 33);
//
//		obj.removeAtStart();
//		obj.removeAtEnd();
//		obj.removeAtPosition(4);
//
//		System.out.println(obj.search(34));
//		System.out.println(obj.getNumElements());
//		
//		obj.print();
//	}

}
