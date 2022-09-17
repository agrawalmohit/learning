package org.sr.wm.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sr.wm.model.Company;
import org.sr.wm.repository.CompanyRepository;

@RestController
@RequestMapping("/api")
public class CompanyController {

	@Autowired
	private CompanyRepository repository;

	@GetMapping("/companies")
	public ResponseEntity<List<Company>> getAllCompany(@RequestParam(required = false) String name) {
		try {
			List<Company> companies = new ArrayList<Company>();

			if (name == null)
				repository.findAll().forEach(companies::add);
			else
				repository.findByNameContaining(name).forEach(companies::add);

			if (companies.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(companies, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/companies/{id}")
	public ResponseEntity<Company> getTutorialById(@PathVariable("id") String id) {
		Optional<Company> companyData = repository.findById(id);

		if (companyData.isPresent()) {
			return new ResponseEntity<>(companyData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/companies")
	public ResponseEntity<Company> createTutorial(@RequestBody Company company) {
		try {
			Company _company = repository
					.save(new Company(company.getName(), company.getBanner(), company.getFinancialYear()));
			return new ResponseEntity<>(_company, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/companies/{id}")
	public ResponseEntity<Company> updateTutorial(@PathVariable("id") String id, @RequestBody Company company) {
		Optional<Company> companyData = repository.findById(id);

		if (companyData.isPresent()) {
			Company _company = companyData.get();
			_company.setName(company.getName());
			_company.setBanner(company.getBanner());
			_company.setFinancialYear(company.getFinancialYear());
			return new ResponseEntity<>(repository.save(_company), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/companies")
	public ResponseEntity<HttpStatus> deleteAllCompanies() {
		try {
		    repository.deleteAll();
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  } catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}

}
