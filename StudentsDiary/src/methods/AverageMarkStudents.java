package methods;

import java.util.List;
import java.util.OptionalDouble;

import package1.Student;

public class AverageMarkStudents {
	public double getAverageMark(List<Student> students) {
		OptionalDouble averageMark = students.stream().mapToDouble(s -> s.getMark()).average();
		return averageMark.getAsDouble();
	}
}
