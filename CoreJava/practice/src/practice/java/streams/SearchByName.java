package practice.java.streams;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByName {

	public static void main(String[] args) {
		List<Student> studentList = PracticeUtils.getStudentList();
		System.out.println(studentList.stream().map(stud -> stud.getName().equals("Two")).collect(Collectors.toList()));
		System.out.println(studentList.stream().filter(stud->stud.getName().equals("Two")).findFirst().get());
	}

}
