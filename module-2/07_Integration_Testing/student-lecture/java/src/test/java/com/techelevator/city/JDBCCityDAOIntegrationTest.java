package com.techelevator.city;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCCityDAOIntegrationTest {
	private SingleConnectionDataSource worldDataSource;
	
	@BeforeClass
	public void setupDataSource() {
		worldDataSource = new SingleConnectionDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		worldDataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public void closeDataSource() {
		worldDataSource.destroy();
	}
	
	@After
	public void walmart() throws SQLException {
		worldDataSource.getConnection().rollback();
	}
	
	
}
