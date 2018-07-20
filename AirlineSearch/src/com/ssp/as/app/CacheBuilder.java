package com.ssp.as.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssp.as.dto.FlightsDto;

public class CacheBuilder {
	public static List<FlightsDto> flightsCacheList = new ArrayList<FlightsDto>();
	static {
		// below can be done reading files recursively from the directory as well
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(
					"C:\\Users\\test\\Desktop\\csv\\AIR_2.csv"));
			br.readLine();
			String line = br.readLine();
			addToCache(line, br);
			br = new BufferedReader(new FileReader(
					"C:\\Users\\test\\Desktop\\csv\\AIR_3.csv"));
			br.readLine();
			line = br.readLine();
			addToCache(line, br);
			br = new BufferedReader(new FileReader(
					"C:\\Users\\test\\Desktop\\csv\\AIR_4.csv"));
			br.readLine();
			line = br.readLine();
			addToCache(line, br);

		} catch (FileNotFoundException fnEx) {
			fnEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void addToCache(String flightDetails, BufferedReader br)
			throws IOException {
		while (flightDetails != null) {
			String[] elements = flightDetails.split(",");
			FlightsDto flight = new FlightsDto();
			flight.setFilghtNum(Integer.parseInt(elements[0]));
			flight.setDepLoc(elements[1]);
			flight.setArrLoc(elements[2]);
			flight.setValidTill(elements[3]);
			flight.setFlightTime(Integer.parseInt(elements[4]));
			flight.setFlightDur(Integer.parseInt(elements[5]));
			flight.setFare(Float.parseFloat(elements[6]));
			flightsCacheList.add(flight);
			flightDetails = br.readLine();
		}
	}
}
