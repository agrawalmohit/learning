package com.sample.as.intf;

import java.util.List;

import com.sample.as.dto.FlightsDto;

public interface AirlineSearchIntf {
	
	List<FlightsDto> searchFlights(String departure, String arrival, int flightTime, String preference0);

}
