package org.sr.wm.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amad {

	private int amadNo;
	private int packs;
	private String lotNo;
	private int room;
	private int story;
	private int rack;
	private String type;
	private String condition;
	private String remarks;
	private BigDecimal weight1;
	private BigDecimal weight2;
	private BigDecimal weight3;
	private BigDecimal weight4;
	private BigDecimal weight5;
	private BigDecimal totalWeight;
	private BigDecimal rate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate entryDate;
	private List<Nikasi> nikasi = new ArrayList<>();
}
