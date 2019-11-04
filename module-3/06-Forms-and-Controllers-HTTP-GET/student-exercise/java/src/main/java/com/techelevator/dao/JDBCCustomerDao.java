package com.techelevator.dao;

import com.techelevator.dao.model.Customer;
import com.techelevator.dao.model.Film;

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
        List<Customer> matchingCustomers = new ArrayList<>();

        String customerSearchSql = "SELECT first_name, last_name, email, activebool FROM customer "+
        						   "WHERE first_name ILIKE '%'||?||'%' OR last_name ILIKE '%'||?||'%' ";
        switch( sort ) {
	        case "last_name":
	        	customerSearchSql += "ORDER BY last_name";
	        	break;
	        case "email":
	        	customerSearchSql += "ORDER BY email";
	        	break;
	        case "active":
	        	customerSearchSql += "ORDER BY active";
	        	break;
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(customerSearchSql, search, search);
        while (results.next()) {
            matchingCustomers.add(mapRowToCustomer(results));
        }
        return matchingCustomers;
	}
	
	private Customer mapRowToCustomer(SqlRowSet results) {
		Customer customer = new Customer();
		
		customer.setActive(results.getBoolean("activebool"));
		customer.setEmail(results.getString("email"));
		customer.setFirstName(results.getString("first_name"));
		customer.setLastName(results.getString("last_name"));
		
		return customer;
	}

}