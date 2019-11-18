package com.techelevator.city;

import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCCityDAOIntegrationTest {
	
	private static SingleConnectionDataSource worldDataSource;
	private static final String bogusCountryCode = "XYZ";

	private JDBCCityDAO dao;
	
	@BeforeClass
	public static void setupDataSource() {
		worldDataSource = new SingleConnectionDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
	
		worldDataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() {
		worldDataSource.destroy();
	}
	
	@After
	public void walmart() throws SQLException {
		worldDataSource.getConnection().rollback();
	}	

	@Before
	public void makeFakeCountry() {
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) " +
								  "VALUES (?, 'Tomistan', 'Asia', 'Southern and Central Asia', 652090.0, 1919, 22720000, 45.9, 5976.00, NULL,'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(worldDataSource);
		jdbcTemplate.update(sqlInsertCountry, bogusCountryCode);

		dao = new JDBCCityDAO(worldDataSource);
	}
	
	@Test
	public void save_new_city_and_read_it_back() {
		City newCity = weBuiltThisCity("Las Tomsterleans", "Nevada", 1); // ARRANGE

		dao.save(newCity);
		City fetchedCity = dao.findCityById(newCity.getId());
		
		assertCitiesAreEqual(newCity, fetchedCity);  // ASSERT
	}
	
	private City weBuiltThisCity(String name, String district, int pop) {
		City newCity = new City();
		newCity.setName(name);
		newCity.setDistrict(district);
		newCity.setPopulation(pop);
		newCity.setCountryCode(bogusCountryCode);
		
		return newCity;
	}
	
	private void assertCitiesAreEqual(City expected, City actual) {
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getDistrict(), actual.getDistrict());
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getCountryCode(), actual.getCountryCode());
		Assert.assertEquals(expected.getPopulation(), actual.getPopulation());		
	}
	
	@Test
	public void return_cities_by_country_code() {
		City c1 = weBuiltThisCity("Javaland", "Indonesia", 100);
		City c2 = weBuiltThisCity("SQL Station", "North Dakota", 102);
		dao.save(c1);
		dao.save(c2);
		
		List<City> cities = dao.findCityByCountryCode(bogusCountryCode);
		Assert.assertNotNull(cities);
		Assert.assertEquals(2, cities.size());
	}
	
	@Test
	public void return_cities_by_district() {
		//ARRANGE!
		String bogusDistrict = "Detroit Rock City";
		City fakeCity = weBuiltThisCity("Rock N Roll", bogusDistrict, 99);
		dao.save(fakeCity);
		
		List<City> cities = dao.findCityByDistrict(bogusDistrict); // ACT!
		
		//ASSERT!
		Assert.assertNotNull(cities);
		Assert.assertEquals(1, cities.size());
		assertCitiesAreEqual(fakeCity, cities.get(0));
	}
}
