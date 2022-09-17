package org.test.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
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

	private static Logger LOGGER = LogManager.getLogger(StudentController.class);
	private static final Marker STAT_MARKER = MarkerManager.getMarker("STATS");
	private static final Marker PII_MARKER = MarkerManager.getMarker("PII");

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public int createStudent(@RequestBody Student student) throws DuplicateStudentException {
		long beginTime = System.currentTimeMillis();
		LOGGER.info(STAT_MARKER, "In time: {}", beginTime);
		LOGGER.info(PII_MARKER, "Request : {}", student);
		int returnVal = studentService.createStudent(student);
		LOGGER.info(PII_MARKER, "Response : {}", returnVal);
		long serviceTime = System.currentTimeMillis();
		LOGGER.info(STAT_MARKER, "Process Time: {} Service Time:{}", System.currentTimeMillis() - beginTime,
				serviceTime - beginTime);
		return returnVal;
	}
}
