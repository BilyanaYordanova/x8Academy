package methods;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import package1.Gender;
import package1.Student;

class AverageMarkByGenderTest {

	AverageMarkByGender object = new AverageMarkByGender();
	List<Student> students = new ArrayList<>();

	Student IvanPetrov = new Student("Ivan", "Petrov", 6, 17, Gender.MALE, "ivan_petrov@gmail.com");
	Student MariyaGeorgieva = new Student("Mariya", "Georgieva", 6, 16, Gender.FEMALE, "m_georgieva@gmail.com");
	Student GeorgiPopov = new Student("Georgi", "Popov", 5, 17, Gender.MALE, "georgi_popov@gmail.com");
	Student IvanaPetrova = new Student("Ivana", "Petrova", 5, 15, Gender.FEMALE, "ivana_petrova@gmail.com");
	Student GeorgiaPopova = new Student("Georgia", "Popova", 4, 17, Gender.FEMALE, "georgia_popova@gmail.com");
	Student MarioGeorgiev = new Student("Mario", "Georgiev", 4, 16, Gender.MALE, "m_georgiev@gmail.com");
	Student ElenaIlieva = new Student("Elena", "Ilieva", 3, 17, Gender.FEMALE, "e.ilieva@gmail.com");
	Student AntonIliev = new Student("Anton", "Iliev", 2, 15, Gender.MALE, "a.iliev@gmail.com");
	Student IvaIvanova = new Student("Iva", "Ivanova", 2, 16, Gender.FEMALE, "i.ivanova@gmail.com");

	void fillList() {
		students.add(IvanPetrov);
		students.add(MariyaGeorgieva);
		students.add(GeorgiPopov);
		students.add(IvanaPetrova);
		students.add(GeorgiaPopova);
		students.add(MarioGeorgiev);
		students.add(ElenaIlieva);
		students.add(AntonIliev);
		students.add(IvaIvanova);
	}

	@Test
	void test1_FemaleAverageMark() {
		fillList();
		double averageMarkFemale1 = object.getAverageMarkByGender(students, Gender.FEMALE);
		assertEquals(4.0d, averageMarkFemale1);
	}

	@Test
	void test1_MaleAverageMark() {
		fillList();
		double averageMarkMale1 = object.getAverageMarkByGender(students, Gender.MALE);
		assertEquals(4.25d, averageMarkMale1);
	}

	@Test()
	void test2_FemaleAverageMark() {
		students.add(MariyaGeorgieva);
		students.add(ElenaIlieva);
		double averageMarkFemale2 = object.getAverageMarkByGender(students, Gender.FEMALE);
		assertEquals(4.5d, averageMarkFemale2);
	}

	@Test
	void test2_MaleAverageMark() {
		students.add(AntonIliev);
		students.add(MarioGeorgiev);
		students.add(GeorgiPopov);
		double averageMarkMale2 = object.getAverageMarkByGender(students, Gender.MALE);
		assertEquals(3.7d, Math.round(averageMarkMale2 * 10) / 10.0);
	}

	@Test()
	void test3_FemaleAverageMark() {
		students.add(MariyaGeorgieva);
		students.add(ElenaIlieva);
		students.add(IvanaPetrova);
		double averageMarkFemale3 = object.getAverageMarkByGender(students, Gender.FEMALE);
		assertEquals(4.7d, Math.round(averageMarkFemale3 * 10) / 10.0);
	}
}
