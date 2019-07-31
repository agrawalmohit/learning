package com.test.alter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.test.alter.Entity.Address;

@Repository
public class AddressDAO implements AddressDAOIntf {

	@Autowired
	@Qualifier("alterSessionFactory")
	private SessionFactory alterSessionFactory;

	@Override
	public Long addAddress(Address address) {
		return (Long) this.getSession().save(address);
	}

	private Session getSession() {
		return alterSessionFactory.getCurrentSession();
	}

}
