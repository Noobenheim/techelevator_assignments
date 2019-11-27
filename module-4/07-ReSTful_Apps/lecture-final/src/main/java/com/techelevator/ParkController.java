package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;
import com.techelevator.model.Weather;
import com.techelevator.model.WeatherDAO;

@RestController
@CrossOrigin
@RequestMapping("/api/parks")
public class ParkController {

	@Autowired
	ParkDAO dao;
	
	@Autowired
	@Qualifier("weatherapi")
	WeatherDAO wdao;
		
	@GetMapping("/")
	public List<Park> getParks() {
		return dao.getAllParks();
	}
	
	
	@GetMapping("/{parkcode}")
	public Park getParkById(@PathVariable String parkcode) {
		return dao.getParkByCode(parkcode);
	}
	

//	@GetMapping("/{parkcode}/weather")
//	public List<Weather> getWeatherByPark(@PathVariable String parkcode) {
//		return dao.getForecastForPark(parkcode);
//	}


	@GetMapping("/{parkcode}/weather")
	public List<Weather> getWeatherByPark(@PathVariable String parkcode) {
		return wdao.getForecastForPark(parkcode);
	}
	
	/*
	 * 	GET api/parks
	 *  GET api/parks/{parkcode}
	 *  GET api/parks/{parkcode}/weather
	 *  PUT api/parks/temperaturePreference
	 *  GET api/parks/temperaturePreference
	 *  GET api/parks/favorites
	 */
}
