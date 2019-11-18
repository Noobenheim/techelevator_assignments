package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.Actor;
import com.techelevator.model.ActorDAO;

@Controller 
public class HelloController {

	@Autowired
	private ActorDAO dao;
	
	@RequestMapping("/greeting")
	public String displayGreeting() {
		
		return "greeting";
	}
	
	@RequestMapping("/actors")
	public String displayActors(ModelMap m) {
		List<Actor> errrrybody = dao.getAllActors();
		m.put("actors", errrrybody);
		
		return "actors";
	}

}
