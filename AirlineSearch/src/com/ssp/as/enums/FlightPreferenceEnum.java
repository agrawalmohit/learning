package com.ssp.as.enums;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ssp.as.dto.FlightsDto;

public enum FlightPreferenceEnum {

	EARLIEST {

		@Override
		public List<FlightsDto> orderByPreference(List<FlightsDto> flightsList) {
			Collections.sort(flightsList, new Comparator<FlightsDto>() {

				@Override
				public int compare(FlightsDto object1, FlightsDto object2) {
					if (object1.getFlightTime() < object2.getFlightTime()) {
						return -1;
					} else if (object1.getFlightTime() == object2
							.getFlightTime()) {
						return 0;
					} else {
						return 1;
					}
				}
			});
			return flightsList;
		}

	},
	SHORTEST {

		@Override
		public List<FlightsDto> orderByPreference(List<FlightsDto> flightsList) {
			Collections.sort(flightsList, new Comparator<FlightsDto>() {

				@Override
				public int compare(FlightsDto object1, FlightsDto object2) {
					if (object1.getFlightDur() < object2.getFlightDur()) {
						return -1;
					} else if (object1.getFlightDur() == object2.getFlightDur()) {
						return 0;
					} else {
						return 1;
					}
				}
			});
			return flightsList;
		}

	},
	CHEAPEST {

		@Override
		public List<FlightsDto> orderByPreference(List<FlightsDto> flightsList) {
			Collections.sort(flightsList, new Comparator<FlightsDto>() {

				@Override
				public int compare(FlightsDto object1, FlightsDto object2) {
					if (object1.getFare() < object2.getFare()) {
						return -1;
					} else if (object1.getFare() == object2.getFare()) {
						return 0;
					} else {
						return 1;
					}
				}
			});
			return flightsList;
		}

	};

	public abstract List<FlightsDto> orderByPreference(
			List<FlightsDto> flightsList);

}
