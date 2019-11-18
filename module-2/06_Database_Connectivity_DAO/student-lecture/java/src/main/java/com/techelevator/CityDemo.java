package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.JDBCCityDAO;

public class CityDemo {

	public static void main(String[] args) {

		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("$USER");
		worldDataSource.setPassword("$PASSWORD");		
		
		JDBCCityDAO j = new JDBCCityDAO(worldDataSource);
		
		City myNewHome = new City();
		myNewHome.setCountryCode("USA");
		myNewHome.setPopulation(1);
		myNewHome.setDistrict("Hawaii");
		myNewHome.setName("Las Tomsterleans");
		
		
		// create myNewHome  // FROM JAVA OBJECT TO DATABASE ROW
		j.save(myNewHome);

		
		myNewHome.setDistrict("Alaska");
		myNewHome.setPopulation(10);
		
		j.save(myNewHome);

		// update myNewHome  // FROM JAVA OBJECT TO DATABASE ROW
		j.update(myNewHome);
		
		
		
		// delete myNewHome
		j.delete(myNewHome.getId());
		
		
	}

}
