package org.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.test.domain.Student;
import org.test.exception.DuplicateStudentException;

@Component
public class StudentDao {

	private List<Student> studentList = new ArrayList<>();

	public int addStudent(Student student) throws DuplicateStudentException {
		if (!studentList.isEmpty()) {
			if (studentList.contains(student)) {
				throw new DuplicateStudentException(Student.class, "Id", String.valueOf(student.getId()));
			}
		}
		studentList.add(student);
		return student.getId();
	}
}
