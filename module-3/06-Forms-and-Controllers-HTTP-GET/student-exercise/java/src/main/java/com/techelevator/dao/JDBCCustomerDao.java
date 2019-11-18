package com.techelevator.dao;

import com.techelevator.dao.model.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<Customer> searchAndSortCustomers(String search, String sort) {
		
		String sql = "SELECT first_name, last_name, email, active " + 
					 "FROM customer " +
					 "WHERE first_name ILIKE ? OR last_name ILIKE ? ";

		
		if(sort.equals("lastName")) {
			sql += "ORDER BY last_name ";
			
		} else if(sort.equals("email")) {
			sql += "ORDER BY email ";
			
		} else if(sort.equals("active")) {
			sql += "ORDER BY active DESC";	
		}
		
		String searchToken = "%" + search + "%";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchToken, searchToken);
		
		List<Customer> output = new ArrayList<>();
		while(results.next()) {
			Customer c = new Customer();
			c.setFirstName(results.getString("first_name"));
			c.setLastName(results.getString("last_name"));
			c.setEmail(results.getString("email"));
			c.setActive(results.getInt("active") == 1 ? true : false);
			
			output.add(c);
		}
		
		return output;
	}

}