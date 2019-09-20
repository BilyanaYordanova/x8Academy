package methods;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import package1.Student;

public class MarksByDistribution {
	public Map<Integer, Long> getMarksByDistribution(List<Student> students) {
		return students.stream().collect(Collectors.groupingBy(Student::getMark, Collectors.counting()));
	}
}
