package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {

    private JdbcTemplate jdbcTemplate;
    
    public JDBCCityDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(City newCity) {
        String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
                               "VALUES(?, ?, ?, ?, ?)";
        newCity.setId(getNextCityId());
        jdbcTemplate.update(sqlInsertCity, newCity.getId(),
                                          newCity.getName(),
                                          newCity.getCountryCode(),
                                          newCity.getDistrict(),
                                          newCity.getPopulation());
    }
    
    @Override
    public City findCityById(long id) {
        City theCity = null;
        String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
                               "FROM city "+
                               "WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
        if(results.next()) {
            theCity = mapRowToCity(results);
        }
        return theCity;
    }
    
    public List<City> searchCity(String search) {
    	List<City> cities = new ArrayList<>();
    	
    	String sql = "SELECT id, name, countrycode, district, population FROM city WHERE name ILIKE '%'|| ? ||'%'";
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, search);
    	while( results.next() ) {
    		cities.add(mapRowToCity(results));
    	}
    	
    	return cities;
    }

    @Override
    public List<City> findCityByCountryCode(String countryCode) {
        ArrayList<City> cities = new ArrayList<>();
        String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
                                           "FROM city "+
                                           "WHERE countrycode = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
        while(results.next()) {
            City theCity = mapRowToCity(results);
            cities.add(theCity);
        }
        return cities;
    }

    @Override
    public List<City> findCityByDistrict(String district) {
        ArrayList<City> cities = new ArrayList<>();
        String sqlFindCitiesByDistrict = "SELECT id, name, countrycode, district, population " +
                                         "FROM city " +
                                         "WHERE district = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCitiesByDistrict, district);
        while(results.next()) {
            City currentCity = mapRowToCity(results);
            cities.add(currentCity);
        }
        return cities;
    }

    @Override
    public void update(City city) {
        String sqlUpdate = "UPDATE city " + 
                           "SET name = ?, countrycode = ?, district = ?, population = ? " +
                           "WHERE id = ?";
        jdbcTemplate.update(sqlUpdate, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation(), city.getId());
    }

    @Override
    public void delete(long id) {
        String sqlDelete = "DELETE FROM city WHERE id = ?";
        jdbcTemplate.update(sqlDelete, id);
    }

    private long getNextCityId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
        if(nextIdResult.next()) {
            long nextId = nextIdResult.getLong(1); 
            return nextId;
        } else {
            throw new RuntimeException("Something went wrong while getting an id for the new city");
        }
    }

    private City mapRowToCity(SqlRowSet results) {
        City theCity = new City();
        theCity.setId(results.getLong("id"));
        theCity.setName(results.getString("name"));
        theCity.setCountryCode(results.getString("countrycode"));
        theCity.setDistrict(results.getString("district"));
        theCity.setPopulation(results.getInt("population"));
        return theCity;
    }
}