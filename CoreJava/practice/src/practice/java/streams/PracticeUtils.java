package practice.java.streams;

import java.util.ArrayList;
import java.util.List;

public class PracticeUtils {

	static List<Student> getStudentList() {

		Student student1 = new Student(1, "One", new ArrayList<Integer>() {
			{
				add(1234567890);
				add(1234567891);
				add(1234567892);
			}
		}, new Address("add l1", "add l2", 12345));
		Student student2 = new Student(2, "Two", new ArrayList<Integer>() {
			{
				add(1234567894);
				add(1234567895);
				add(1234567896);
			}
		}, new Address("add l4", "add l42", 12345));
		Student student3 = new Student(3, "Three", new ArrayList<Integer>() {
			{
				add(1234567897);
				add(1234567898);
				add(1234567899);
			}
		}, new Address("add l5", "add l52", 12345));
		return new ArrayList<Student>() {
			{
				add(student1);
				add(student2);
				add(student3);
			}
		};

	}
}
