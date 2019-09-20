package package1;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private int mark;
	private int age;
	private Gender gender;
	private String eMail;

	public Student(String firstName, String lastName, int mark, int age, Gender gender, String eMail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
		this.setAge(age);
		this.setGender(gender);
		this.seteMail(eMail);
	}

	public static List<Student> createShortList() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ivan", "Petrov", 6, 17, Gender.MALE, "ivan_petrov@gmail.com"));
		students.add(new Student("Mariya", "Georgieva", 6, 16, Gender.FEMALE, "m_georgieva@gmail.com"));
		students.add(new Student("Georgi", "Popov", 5, 17, Gender.MALE, "georgi_popov@gmail.com"));
		students.add(new Student("Ivana", "Petrova", 5, 15, Gender.FEMALE, "ivana_petrova@gmail.com"));
		students.add(new Student("Georgia", "Popova", 4, 17, Gender.FEMALE, "georgia_popova@gmail.com"));
		students.add(new Student("Mario", "Georgiev", 4, 16, Gender.MALE, "m_georgiev@gmail.com"));
		students.add(new Student("Elena", "Ilieva", 3, 17, Gender.FEMALE, "e.ilieva@gmail.com"));
		students.add(new Student("Anton", "Iliev", 2, 15, Gender.MALE, "a.iliev@gmail.com"));
		students.add(new Student("Iva", "Ivanova", 2, 16, Gender.FEMALE, "i.ivanova@gmail.com"));

		return students;
	}

	public void printInformationAboutStudent() {
		System.out.println("Name: " + this.getFirstName() + " " + this.getLastName() + "\n" + "Mark: " + this.getMark()
				+ " Age: " + this.getAge() + "\n" + "Gender: " + this.getGender() + "\n" + "Email: " + this.geteMail()
				+ "\n");
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getMark() {
		return mark;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Gender getGender() {
		return gender;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String geteMail() {
		return eMail;
	}
}
