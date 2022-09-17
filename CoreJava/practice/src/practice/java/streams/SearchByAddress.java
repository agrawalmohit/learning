package practice.java.streams;

import java.util.List;

public class SearchByAddress {

	public static void main(String[] args) {
		List<Student> studList = PracticeUtils.getStudentList();
		System.out.println(studList.stream().filter(stud->stud.getAddress().getFirstLine().equals("add l4")).findFirst().get());
	}
}
