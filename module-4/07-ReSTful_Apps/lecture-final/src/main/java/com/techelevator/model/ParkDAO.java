package com.techelevator.model;

import java.util.List;

public interface ParkDAO extends WeatherDAO {
	
	List<Park> getAllParks();
	Park getParkByCode(String parkcode);

}
