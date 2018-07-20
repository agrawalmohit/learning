package com.ssp.as.impl;

import java.util.ArrayList;
import java.util.List;

import com.ssp.as.app.CacheBuilder;
import com.ssp.as.dto.FlightsDto;
import com.ssp.as.enums.FlightPreferenceEnum;
import com.ssp.as.intf.AirlineSearchIntf;

public class AirlineSearchImpl implements AirlineSearchIntf {

	@Override
	public List<FlightsDto> searchFlights(String departure, String arrival,
			int flightTime, String preference) {
		List<FlightsDto> flightListResult = new ArrayList<FlightsDto>();
		for (FlightsDto flight : CacheBuilder.flightsCacheList) {
			if (departure.equals(flight.getDepLoc())
					&& arrival.equals(flight.getArrLoc())
					&& flightTime <= flight.getFlightTime()) {
				flightListResult.add(flight);
			}
		}
		return FlightPreferenceEnum.valueOf(preference).orderByPreference(
				flightListResult);
	}

}
