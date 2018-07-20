package com.ssp.as.app;

import java.util.List;

import com.ssp.as.dto.FlightsDto;
import com.ssp.as.impl.AirlineSearchImpl;
import com.ssp.as.intf.AirlineSearchIntf;

public class TestFlightSearch {

	public static void main(String[] args) {
		AirlineSearchIntf airlineSearch = new AirlineSearchImpl();
		List<FlightsDto> flightsliDtos = airlineSearch.searchFlights(args[0],
				args[1], Integer.parseInt(args[2]), args[3]);
		for (FlightsDto flight : flightsliDtos) {
			System.out.println(flight.getFilghtNum());
		}
	}
}
