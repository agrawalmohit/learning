package com.sample.as.impl;

import java.util.ArrayList;
import java.util.List;

import com.sample.as.app.CacheBuilder;
import com.sample.as.dto.FlightsDto;
import com.sample.as.enums.FlightPreferenceEnum;
import com.sample.as.intf.AirlineSearchIntf;

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
