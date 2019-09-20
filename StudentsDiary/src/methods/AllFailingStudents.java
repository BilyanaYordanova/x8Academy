package methods;

import java.util.List;
import java.util.stream.Collectors;

import package1.Student;

public class AllFailingStudents {
	public List<Student> getAllFailingStudents(List<Student> students) {
		return students.stream().filter(s -> s.getMark() <= 2).collect(Collectors.toList());
	}
}
