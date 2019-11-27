package com.techelevator.model;

import java.util.List;

public interface WeatherDAO {
	List<Weather> getForecastForPark(String parkcode);
}
