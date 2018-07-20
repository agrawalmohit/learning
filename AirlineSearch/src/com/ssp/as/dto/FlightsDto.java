package com.ssp.as.dto;

public class FlightsDto {

	private Integer filghtNum;
	private String depLoc;
	private String arrLoc;
	private String validTill;
	private int flightTime;
	private int flightDur;
	private float fare;

	public Integer getFilghtNum() {
		return filghtNum;
	}

	public void setFilghtNum(Integer filghtNum) {
		this.filghtNum = filghtNum;
	}

	public String getDepLoc() {
		return depLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public int getFlightDur() {
		return flightDur;
	}

	public void setFlightDur(int flightDur) {
		this.flightDur = flightDur;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}
}
