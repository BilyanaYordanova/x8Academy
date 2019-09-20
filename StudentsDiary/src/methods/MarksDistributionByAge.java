package methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import package1.Student;

public class MarksDistributionByAge {

	public Map<Integer, List<Integer>> getMarksDistributionByAge(List<Student> students) {
		Map<Integer, List<Integer>> mapAgeToListOfMarks = new HashMap<>();

		List<Integer> listOfAges = students.stream().map(Student::getAge).distinct().collect(Collectors.toList());

		for (int i = 0; i < listOfAges.size(); i++) {
			int age = listOfAges.get(i);
			List<Integer> marksOfStudentsOfParticularAge = students.stream().filter(s -> s.getAge() == age)
					.map(Student::getMark).collect(Collectors.toList());
			mapAgeToListOfMarks.put(age, marksOfStudentsOfParticularAge);
		}

		return mapAgeToListOfMarks;
	}
}
