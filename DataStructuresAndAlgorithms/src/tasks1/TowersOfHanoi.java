package tasks1;

public class TowersOfHanoi {

	private StackLinkedListImplementation[] towers = new StackLinkedListImplementation[4];

	public void towerOfHanoi(int numberDisks) {
		towers = new StackLinkedListImplementation[4];
		for (int j = 0; j <= 3; j++) {
			towers[j] = new StackLinkedListImplementation();
		}

		for (int i = numberDisks; i > 0; i--) {
			towers[1].push(i);
		}
		// showTowers();
		moveDisks(numberDisks, 1, 2, 3);
	}

	public void moveDisks(int numberDisks, int A, int B, int C) {
		if (numberDisks > 0) {
			moveDisks(numberDisks - 1, A, C, B);
			int diskToMove = (int) towers[A].pop();
			towers[B].push(diskToMove);
			showTowers();
			moveDisks(numberDisks - 1, C, B, A);
		}
	}

	public void showTowers() {
		System.out.println("First tower: ");
		towers[1].print();

		System.out.println("Second tower: ");
		towers[2].print();

		System.out.println("Third tower: ");
		towers[3].print();
	}
}
