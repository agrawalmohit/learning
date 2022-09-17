package practice.java.streams;

import java.util.List;
import java.util.stream.Collectors;

public class ToStringList {

	public static void main(String[] args) {
		List<Student> studList = PracticeUtils.getStudentList();
		System.out.println(studList.stream().map(stud->stud.getName()).collect(Collectors.toList()));
	}
}
