package methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import package1.Student;

public class GroupStudentsByMark {

	public Map<Boolean, List<Student>> groupStudentsByParticularMark(List<Student> students, int markToGroupBy) {
		Map<Boolean, List<Student>> splittedStudents = new HashMap<>();

		List<Student> higherOrEqualThanParticularMark = students.stream().filter(s -> s.getMark() >= markToGroupBy)
				.collect(Collectors.toList());
		List<Student> lessThanParticularMark = students.stream().filter(s -> s.getMark() < markToGroupBy)
				.collect(Collectors.toList());

		splittedStudents.put(true, higherOrEqualThanParticularMark);
		splittedStudents.put(false, lessThanParticularMark);

		return splittedStudents;
	}
}
