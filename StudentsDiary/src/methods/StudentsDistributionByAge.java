package methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import package1.Student;

public class StudentsDistributionByAge {

	public static Map<Integer, List<Student>> getStudentDistributionByAge(List<Student> students) {

		Map<Integer, List<Student>> mapAgeToListOfStudentsPerAge = new HashMap<>();

		List<Integer> listOfAges = students.stream().map(Student::getAge).distinct().collect(Collectors.toList());

		for (int i = 0; i < listOfAges.size(); i++) {
			int age = listOfAges.get(i);
			List<Student> studentsOfParticularAge = students.stream().filter(s -> s.getAge() == age)
					.collect(Collectors.toList());
			mapAgeToListOfStudentsPerAge.put(age, studentsOfParticularAge);
		}

		return mapAgeToListOfStudentsPerAge;
	}
}
