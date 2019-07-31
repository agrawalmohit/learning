package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.alter.Entity.Address;
import com.test.alter.dao.AddressDAOIntf;
import com.test.beans.StudentDetails;
import com.test.test.Entity.Student;
import com.test.test.dao.StudentDAOIntf;

@Service
@Transactional(transactionManager = "chainedTransactionManager", propagation = Propagation.REQUIRED)
public class StudentDetailsService implements StudentDetailsServiceIntf {

	@Autowired
	private StudentDAOIntf studentDAO;

	@Autowired
	private AddressDAOIntf addressDAO;

	@Override
	public boolean saveStudentDetails(StudentDetails studentDetails) {
		try {
			Student student = new Student();
			student.setName(studentDetails.getStudentName());
			Address address = new Address();
			address.setAddressLine1(studentDetails.getAddressLine1());
			address.setStudentId(createStudent(student));
			createAddress(address);
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Long createStudent(Student student) {
		return studentDAO.createStudent(student);
	}

	@Override
	public Long createAddress(Address address) {
		return addressDAO.addAddress(address);
	}

}
