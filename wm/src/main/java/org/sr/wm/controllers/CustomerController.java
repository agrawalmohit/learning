package org.sr.wm.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sr.wm.PDFExporterUtility;
import org.sr.wm.model.Amad;
import org.sr.wm.model.BardanaAccount;
import org.sr.wm.model.Customer;
import org.sr.wm.repository.CustomerRepository;
import org.sr.wm.service.CustomerService;

import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository repo;

	@PostMapping("/companies/{compId}/customer")
	public ResponseEntity<Customer> addNewCustomer(@PathVariable("compId") String companyId,
			@RequestBody Customer customer) {
		Customer _customer = customerService.addNewCustomer(companyId, customer);
		if (null != _customer) {
			return new ResponseEntity<>(_customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/companies/{compId}/customer/{custId}/amad")
	public ResponseEntity<Customer> addNewAmadEntry(@PathVariable("compId") String companyId,
			@PathVariable("custId") String custId, @RequestBody Amad amad) {
		Customer _customer = customerService.addNewAmadEntry(companyId, custId, amad);
		if (null != _customer) {
			return new ResponseEntity<>(_customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/companies/{compId}/customer/{custId}/bardana-ac")
	public ResponseEntity<Customer> addBardanaAccountEntry(@PathVariable("compId") String companyId,
			@PathVariable("custId") String custId, @RequestBody BardanaAccount bardanaAcc) {
		Customer _customer = customerService.addBardanaAccount(companyId, custId, bardanaAcc);
		if (null != _customer) {
			return new ResponseEntity<>(_customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/companies/{compId}/customer/pdf/group/village/asc")
	public ResponseEntity<String> exportToPDFGroupAsc(@PathVariable("compId") String companyId)
			throws DocumentException, IOException {
		Optional<List<Customer>> custData = repo.findByCompanyId(companyId);
		if (custData.isPresent()) {
			List<Customer> customers = custData.get();
			Collections.sort(customers, new Comparator<Customer>() {
				@Override
				public int compare(Customer o1, Customer o2) {
					return o1.getVillage().compareTo(o2.getVillage());
				}
			});
			PDFExporterUtility exporter = new PDFExporterUtility(customers);
			exporter.exportGroupedDataByVillage();
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/companies/{compId}/customer/pdf/group/village/dsc")
	public ResponseEntity<String> exportToPDFGroupDsc(@PathVariable("compId") String companyId)
			throws DocumentException, IOException {
		Optional<List<Customer>> custData = repo.findByCompanyId(companyId);
		if (custData.isPresent()) {
			List<Customer> customers = custData.get();
			Collections.sort(customers, new Comparator<Customer>() {
				@Override
				public int compare(Customer o1, Customer o2) {
					return o2.getVillage().compareTo(o1.getVillage());
				}
			});
			PDFExporterUtility exporter = new PDFExporterUtility(customers);
			exporter.exportGroupedDataByVillage();
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/companies/{compId}/customer/pdf/order/{column}")
	public ResponseEntity<String> exportToPDFOrder(@PathVariable("compId") String companyId,
			@PathVariable("column") int column) throws DocumentException, IOException {
		Optional<List<Customer>> custData = repo.findByCompanyId(companyId);
		if (custData.isPresent()) {
			List<Customer> customers = custData.get();
			switch (column) {
			case 1:
				Collections.sort(customers, new Comparator<Customer>() {
					@Override
					public int compare(Customer o1, Customer o2) {
						return o1.getName().compareTo(o2.getName());
					}
				});
				break;
			case 2:
				Collections.sort(customers, new Comparator<Customer>() {
					@Override
					public int compare(Customer o1, Customer o2) {
						return o1.getVillage().compareTo(o2.getVillage());
					}
				});
				break;
			case 3:
				Collections.sort(customers, new Comparator<Customer>() {
					@Override
					public int compare(Customer o1, Customer o2) {
						return o1.getFatherName().compareTo(o2.getFatherName());
					}
				});
				break;
			}
			PDFExporterUtility exporter = new PDFExporterUtility(customers);
			exporter.export();
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
