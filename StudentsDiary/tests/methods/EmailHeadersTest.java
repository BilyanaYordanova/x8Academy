package methods;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import package1.Gender;
import package1.Student;

class EmailHeadersTest {

	EmailHeaders object = new EmailHeaders();
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

	@Test
	void test1_EmailHeaders() {
		students = Student.createShortList();
		String expected = "[ivan_petrov@gmail.com, m_georgieva@gmail.com, georgi_popov@gmail.com, ivana_petrova@gmail.com, georgia_popova@gmail.com, m_georgiev@gmail.com, e.ilieva@gmail.com, a.iliev@gmail.com, i.ivanova@gmail.com]";
		String actual = object.getEmailHeadersToAllStudents(students);
		assertEquals(expected, actual);
	}

	@Test
	void test2_EmailHeaders() {
		students.add(IvanPetrov);
		students.add(GeorgiPopov);
		students.add(IvaIvanova);
		students.add(ElenaIlieva);

		String expected = "[ivan_petrov@gmail.com, georgi_popov@gmail.com, i.ivanova@gmail.com, e.ilieva@gmail.com]";
		String actual = object.getEmailHeadersToAllStudents(students);
		assertEquals(expected, actual);
	}

}
