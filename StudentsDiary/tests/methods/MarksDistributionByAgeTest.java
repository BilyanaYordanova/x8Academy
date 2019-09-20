package methods;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import package1.Student;

class MarksDistributionByAgeTest {

	MarksDistributionByAge object = new MarksDistributionByAge();
	List<Student> students = new ArrayList<>();

	@Test
	void test1() {
		students = Student.createShortList();
		Map<Integer, List<Integer>> mapMarksDistributionByAge = object.getMarksDistributionByAge(students);
		assertEquals("[6, 5, 4, 3]", mapMarksDistributionByAge.get(17).toString());
		assertEquals("[6, 4, 2]", mapMarksDistributionByAge.get(16).toString());
		assertEquals("[5, 2]", mapMarksDistributionByAge.get(15).toString());
	}

}
