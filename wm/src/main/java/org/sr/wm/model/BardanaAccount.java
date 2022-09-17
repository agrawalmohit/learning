package org.sr.wm.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BardanaAccount {

	private int bookNo;
	private int seqNo;
	private int bardanaCount;
	private BigDecimal rate;
	private BigDecimal cost;
	private BigDecimal advance;
	private String remarks;

}
