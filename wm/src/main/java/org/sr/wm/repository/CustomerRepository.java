package org.sr.wm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.sr.wm.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	@Query(value = "{'customerId' : ?0, 'companies.companyId' : ?1}")
	Optional<Customer> findByCustomerIdAndCompanyId(String custId, String companyId);

	@Query(value = "{'companies.companyId' : ?0}")
	Optional<List<Customer>> findByCompanyId(String companyId);

}
