package org.sr.wm.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.sr.wm.model.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {

	List<Company> findByNameContaining(String name);

}
