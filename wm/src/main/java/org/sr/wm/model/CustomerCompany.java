package org.sr.wm.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerCompany extends Company {

	private List<BardanaAccount> bardanaAccounts = new ArrayList<>();
	private List<Amad> amads = new ArrayList<>();

	public CustomerCompany(Company company) {
		this.setCompanyId(company.getCompanyId());
		this.setBanner(company.getBanner());
		this.setFinancialYear(company.getFinancialYear());
		this.setName(company.getName());
	}

}
