package org.sr.wm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sr.wm.model.Amad;
import org.sr.wm.model.BardanaAccount;
import org.sr.wm.model.Company;
import org.sr.wm.model.Customer;
import org.sr.wm.model.CustomerCompany;
import org.sr.wm.repository.CompanyRepository;
import org.sr.wm.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private CompanyRepository companyRepo;

	@Override
	public Customer addNewCustomer(String companyId, Customer customer) {
		Optional<Company> companyData = companyRepo.findById(companyId);
		if (companyData.isPresent()) {
			CustomerCompany custCompany = new CustomerCompany(companyData.get());
			customer.getCompanies().add(custCompany);
			return custRepo.save(customer);
		} else
			return null;
	}

	@Override
	public Customer addNewAmadEntry(String companyId, String custId, Amad amad) {
		Optional<Customer> customerData = custRepo.findByCustomerIdAndCompanyId(custId, companyId);
		if (customerData.isPresent()) {
			Customer customer = customerData.get();
			customer.getCompanies().get(0).getAmads().add(amad);
			return custRepo.save(customer);
		}
		return null;
	}

	@Override
	public Customer addBardanaAccount(String companyId, String custId, BardanaAccount bardanaAcc) {
		Optional<Customer> customerData = custRepo.findByCustomerIdAndCompanyId(custId, companyId);
		if (customerData.isPresent()) {
			Customer customer = customerData.get();
			customer.getCompanies().get(0).getBardanaAccounts().add(bardanaAcc);
			return custRepo.save(customer);
		}
		return null;
	}

}
