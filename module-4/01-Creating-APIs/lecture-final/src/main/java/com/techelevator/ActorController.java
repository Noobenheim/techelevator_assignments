package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Actor;
import com.techelevator.model.ActorDAO;

@RestController
@RequestMapping("/api")
public class ActorController {

	@Autowired
	private ActorDAO dao;
	
	@GetMapping("/actors")
	public List<Actor> displayActors() {
		return dao.getAllActors();
	}

	@GetMapping("/actors/{id}")
	public Actor findThisGuy(@PathVariable int id) {
		return dao.getOneActor(new Long(id));
	}
	
	@PostMapping("/actors")
	@ResponseStatus(HttpStatus.CREATED)
	public void insertNewActor(@RequestBody Actor newActor) {
		dao.createActor(newActor);
	}
	
	@PutMapping("/actors")
	@ResponseStatus(HttpStatus.ACCEPTED) 
	public Actor updateActor(@RequestBody Actor changedActor) {
		return dao.saveActor(changedActor) ? changedActor : null;
	}
	
	
	@DeleteMapping("/actors/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void killThisGuy(@PathVariable int id) {
		dao.killActor(new Long(id));
	}
	
}
