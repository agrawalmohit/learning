package com.test.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.test.test.Entity.Student;

@Repository
public class StudentDAO implements StudentDAOIntf {

	@Autowired
	@Qualifier("testSessionFactory")
	private SessionFactory alterSessionFactory;

	@Override
	public Long createStudent(Student student) {
		return (Long) this.getSession().save(student);
	}

	private Session getSession() {
		return alterSessionFactory.getCurrentSession();

	}

}
