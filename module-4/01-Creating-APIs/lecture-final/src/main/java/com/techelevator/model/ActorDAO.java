package com.techelevator.model;

import java.util.List;

public interface ActorDAO {

	// Read
	List<Actor> getAllActors();
	Actor getOneActor(Long id);
	
	// Create
	boolean createActor(Actor newActor);
	
	
	// Update
	boolean saveActor(Actor changedActor);
	
	// Delete
	boolean killActor(Long id);
	
}
