package org.sr.wm.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nikasi {

	private int nikasiNo;
	private String lotNo;
	private int packs;
	private BigDecimal weight;
	private String vehicleNo;
	private int balancePacks;
	private BigDecimal balanceWeigh;
}
