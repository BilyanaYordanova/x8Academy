package methods;

import java.util.List;
import java.util.stream.Collectors;

import package1.Student;

public class StudentsWithHighestAndLowestMark {

	public List<Student> studentsWithHighestMark(List<Student> students) {
		Integer maxMark = students.stream().map(Student::getMark).reduce(Integer.MIN_VALUE, Integer::max);

		return students.stream().filter(s -> s.getMark() == maxMark).collect(Collectors.toList());
	}

	public List<Student> studentsWithLowestMark(List<Student> students) {
		Integer minMark = students.stream().map(Student::getMark).reduce(Integer.MAX_VALUE, Integer::min);

		return students.stream().filter(s -> s.getMark() == minMark).collect(Collectors.toList());
	}
}
