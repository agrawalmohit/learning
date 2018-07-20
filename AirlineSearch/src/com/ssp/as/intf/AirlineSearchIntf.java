package com.ssp.as.intf;

import java.util.List;

import com.ssp.as.dto.FlightsDto;

public interface AirlineSearchIntf {
	
	List<FlightsDto> searchFlights(String departure, String arrival, int flightTime, String preference0);

}
