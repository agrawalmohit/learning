package com.test.beans;

import java.io.Serializable;

public class StudentDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String studentName;
	private String AddressLine1;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	@Override
	public String toString() {
		return "StudentDetails [studentName=" + studentName + ", AddressLine1=" + AddressLine1 + "]";
	}

}
