package org.sr.wm.service;

import org.sr.wm.model.Amad;
import org.sr.wm.model.BardanaAccount;
import org.sr.wm.model.Customer;

public interface CustomerService {

	Customer addNewCustomer(String companyId, Customer customer);

	Customer addNewAmadEntry(String companyId, String custId, Amad amad);

	Customer addBardanaAccount(String companyId, String custId, BardanaAccount bardanaAcc);

}
