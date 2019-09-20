package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.oddOccurrenceNumber;

public class TestIfFuncgetOddOccurrenceReturnsNumberWhichOccursOddTimeInIntArray {

	oddOccurrenceNumber obj = new oddOccurrenceNumber();

	@Test
	public void test1() {
		int[] array = { 14, 65, 13, 1, 65, 14, 4, 14 }; // 14,13,4
		assertEquals(14, obj.getOddOccurrence(array));
	}

}
