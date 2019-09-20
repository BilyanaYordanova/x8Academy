package methods;

import java.util.List;
import java.util.OptionalDouble;

import package1.Gender;
import package1.Student;

public class AverageMarkByGender {

	public double getAverageMarkByGender(List<Student> students, Gender gender) {
		OptionalDouble averageMarkByGender = students.stream().filter(s -> s.getGender().equals(gender))
				.mapToDouble(s -> s.getMark()).average();

		return averageMarkByGender.getAsDouble();
	}
}
