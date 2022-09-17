package org.sr.wm.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("Customer")
public class Customer {

	@Id
	private String customerId;
	private String name;
	private String fatherName;
	private String village;
	private List<CustomerCompany> companies = new ArrayList<>();

	public Customer(String name, String fatherName, String village) {
		this.name = name;
		this.fatherName = fatherName;
		this.village = village;
	}

}
