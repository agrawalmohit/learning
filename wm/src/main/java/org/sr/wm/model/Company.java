package org.sr.wm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "company")
@Getter
@Setter
@NoArgsConstructor
public class Company {

	@Id
	private String companyId;
	private String name;
	private String banner;
	private int financialYear;

	public Company(String name, String banner, int financialYear) {
		this.name = name;
		this.banner = banner;
		this.financialYear = financialYear;
	}
}
