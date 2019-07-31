package com.test.service;

import com.test.alter.Entity.Address;
import com.test.beans.StudentDetails;
import com.test.test.Entity.Student;

public interface StudentDetailsServiceIntf {

	public boolean saveStudentDetails(StudentDetails studentDetails);

	public Long createStudent(Student student);

	public Long createAddress(Address address);

}
