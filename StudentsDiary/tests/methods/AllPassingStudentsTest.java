package methods;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import package1.Gender;
import package1.Student;

class AllPassingStudentsTest {

	AllPassingStudents object = new AllPassingStudents();
	List<Student> students = new ArrayList<>();
	List<Student> passingStudents = new ArrayList<>();

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

		passingStudents = object.getAllPassingStudent(students);
	}

	@Test
	void test1() {
		fillList();
		assertTrue(passingStudents.contains(IvanPetrov));
	}

	@Test
	void test2() {
		fillList();
		assertTrue(passingStudents.contains(IvanaPetrova));
	}

	@Test
	void test3() {
		fillList();
		assertFalse(passingStudents.contains(AntonIliev));
	}

	@Test
	void test4() {
		fillList();
		assertFalse(passingStudents.contains(IvaIvanova));
	}
}
