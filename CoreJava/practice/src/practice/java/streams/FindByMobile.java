package practice.java.streams;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindByMobile {
	
	public static void main(String[] args) {
		
	
	List<Student> studList = PracticeUtils.getStudentList();
	
	System.out.println(studList.stream().filter(stud->stud.getMobiles().stream().anyMatch(mob->Objects.equals(mob,1234567890))).collect(Collectors.toList()));
	System.out.println(studList.stream().filter(stud->stud.getMobiles().stream().anyMatch(mob->Objects.equals(mob,1234567890)||Objects.equals(mob, 1234567898))).collect(Collectors.toList()));
	
	}

}
