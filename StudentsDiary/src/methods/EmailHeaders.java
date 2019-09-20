package methods;

import java.util.List;
import java.util.stream.Collectors;

import package1.Student;

public class EmailHeaders {
//	public List<String> getEmailHeadersToAllStudents(List<Student> students) {
//		return students.stream().map(Student::geteMail).collect(Collectors.toList());
//	}

	public String getEmailHeadersToAllStudents(List<Student> students) {
		return students.stream().map(Student::geteMail).collect(Collectors.toList()).toString();
	}
}
