package methods;

import java.util.Comparator;
import java.util.List;

import package1.Student;

public class OrderStudentsByMarks {
	public static void studentsOrderByMarksAscending(List<Student> students) {
		students.stream().sorted(Comparator.comparing(Student::getMark)).forEach(Student::printInformationAboutStudent);
	}

	public static void studentsOrderByMarksDescending(List<Student> students) {
		students.stream().sorted(Comparator.comparing(Student::getMark).reversed())
				.forEach(Student::printInformationAboutStudent);
	}

	public static void main(String[] args) {
		List<Student> students = Student.createShortList();
		System.out.println("==== Students ordered in ascending order by marks =====");
		studentsOrderByMarksAscending(students);

		System.out.println("==== Students ordered in descending order by marks =====");
		studentsOrderByMarksDescending(students);
	}
}
