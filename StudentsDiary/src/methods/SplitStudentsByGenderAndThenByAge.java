package methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import package1.Gender;
import package1.Student;

public class SplitStudentsByGenderAndThenByAge {

	public static List<Student> splitStudentsByGender(List<Student> students, Gender gender) {
		return students.stream().filter(s -> s.getGender().equals(gender)).collect(Collectors.toList());
	}

	public static Map<Gender, Map<Integer, List<Student>>> splitByGenderThenByAge(List<Student> students) {
		List<Student> females = splitStudentsByGender(students, Gender.FEMALE);
		List<Student> males = splitStudentsByGender(students, Gender.MALE);

		Map<Gender, Map<Integer, List<Student>>> mapGenderToStudentsDistributedByAge = new HashMap<>();

		mapGenderToStudentsDistributedByAge.put(Gender.FEMALE,
				StudentsDistributionByAge.getStudentDistributionByAge(females));
		mapGenderToStudentsDistributedByAge.put(Gender.MALE,
				StudentsDistributionByAge.getStudentDistributionByAge(males));

		return mapGenderToStudentsDistributedByAge;
	}
}
