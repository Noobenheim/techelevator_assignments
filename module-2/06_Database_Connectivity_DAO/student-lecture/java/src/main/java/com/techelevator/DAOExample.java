package com.techelevator;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		JDBCCityDAO dao = new JDBCCityDAO(worldDataSource);
		
//		City smallville = new City();
//		smallville.setCountryCode("USA");
//		smallville.setDistrict("KS");
//		smallville.setName("Smallville");
//		smallville.setPopulation(42080);
//		
//		dao.save(smallville);
//		
//		City theCity = dao.findCityById(smallville.getId());
		
		List<City> cities = dao.searchCity("spring");
		System.out.println("Found "+cities.size()+" city(s)");
		
		for( City c : cities ) {
			System.out.println(c.getName());
		}
		
	}

}
