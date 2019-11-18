package com.techelevator.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Actor;
import com.techelevator.model.ActorDAO;

@Component
public class JDBCActorDAO implements ActorDAO {

	private JdbcTemplate jdbc;
	
	@Autowired
	public JDBCActorDAO(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Actor> getAllActors() {
		String sql = "SELECT actor_id, first_name, last_name FROM actor";
		
		SqlRowSet results = jdbc.queryForRowSet(sql);
		
		List<Actor> output = new ArrayList<Actor>();
		while(results.next()) {
			Actor thisGuy = mapRowToActor(results);
			output.add(thisGuy);
		}
		return output;
	}

	@Override
	public boolean createActor(Actor newActor) {
		String sql = "INSERT INTO actor VALUES (DEFAULT, ?, ?) RETURNING actor_id";
		try {
			SqlRowSet result = jdbc.queryForRowSet(sql, newActor.getFirstName(), newActor.getLastName());
			result.next();
			newActor.setActorId(result.getLong(1));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean saveActor(Actor changedActor) {
		String sql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
		int rowsAffected = jdbc.update(sql, changedActor.getFirstName(), changedActor.getLastName(), changedActor.getActorId());

		return rowsAffected == 1;
	}

	@Override
	public boolean killActor(Long id) {
		String sql = "DELETE FROM actor WHERE actor_id = ?";
		int rowsAffected = jdbc.update(sql, id);

		return rowsAffected == 1;
	}

	private Actor mapRowToActor(SqlRowSet results) {
		Actor a = new Actor();
		a.setActorId(results.getLong("actor_id"));
		a.setFirstName(results.getString("first_name"));
		a.setLastName(results.getString("last_name"));
		return a;
	}

	@Override
	public Actor getOneActor(Long id) {
		String sql = "SELECT actor_id, first_name, last_name FROM actor WHERE actor_id = ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, id);
		results.next();
		Actor specificActor = mapRowToActor(results);
		return specificActor;
	}
	
}
