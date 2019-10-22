package com.techelevator;

import com.techelevator.city.City;

public class CityDemo {

	public static void main(String[] args) {
		City myNewHome = new City();
		myNewHome.setCountryCode("USA");
		myNewHome.setPopulation(1);
		myNewHome.setDistrict("Hawaii");
		myNewHome.setName("Las Tomsterleans");
		
		// save myNewHome
		
		myNewHome.setDistrict("Alaska");
		myNewHome.setPopulation(10);
		// update myNewHome
		
		// delete myNewHome
	}

}
