package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.StudentDetails;
import com.test.service.StudentDetailsServiceIntf;

@RestController
public class StudentDetailsController {

	@Autowired
	private StudentDetailsServiceIntf studentDetailsService;

	@PostMapping(path = "/studentDetails", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Boolean> createStudent(@RequestBody StudentDetails studentDetails) {
		System.out.println("received: " + studentDetails);
		try {
			return new ResponseEntity<Boolean>(studentDetailsService.saveStudentDetails(studentDetails),
					HttpStatus.CREATED);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}

}
