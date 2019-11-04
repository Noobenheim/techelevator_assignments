package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;

@Controller
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	/* What request mapping do we want here */
	@RequestMapping("/actorSearch")
	public String showSearchActorForm() {
		return "actorList";
	}

	/* What about here? */
	@RequestMapping("/actorResult")
	public String searchActors(@RequestParam String lastName, ModelMap modelHolder) {
		List<Actor> results = actorDao.getMatchingActors(lastName);
		
		modelHolder.put("actors", results);
		
		return "actorList";
	}
}
