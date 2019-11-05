package com.techelevator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class HomeController {

	@RequestMapping({"/", "/home", "HOME", "homepage"})
	public String displayHomePage() {
		
		return "homePage";
	}
}
