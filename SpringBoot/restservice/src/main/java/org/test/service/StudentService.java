package org.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.dao.StudentDao;
import org.test.domain.Student;
import org.test.exception.DuplicateStudentException;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	public int createStudent(Student student) throws DuplicateStudentException {
		return studentDao.addStudent(student);
	}

}
