package org.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.domain.Student;
import org.test.exception.DuplicateStudentException;
import org.test.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public int createStudent(@RequestBody Student student) throws DuplicateStudentException {
		return studentService.createStudent(student);
	}
}
