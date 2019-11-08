package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;

@Controller
public class UserController {
	// GET: /
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	// Add the following Controller Actions

	// GET: /register
	// Return the empty registration view
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String showRegistrationPage(ModelMap modelMap) {
		if( !modelMap.containsAttribute("registration") ) {
			modelMap.addAttribute("registration", new Registration());
		}
		return "registration/form";
	}

	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("registration") Registration registration,
									  BindingResult result, 
									  RedirectAttributes flashScope) {
		if( result.hasErrors() ) {
			flashScope.addFlashAttribute("registration", registration);
			flashScope.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "registration", result);
			
			return "redirect:/register";
		}
		return "redirect:/registrationSuccessful";
	}
	
	@RequestMapping(path="/registrationSuccessful", method=RequestMethod.GET)
	public String showSuccessfulRegistration() {
		return "registration/success";
	}

	// GET: /login
	// Return the empty login view
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLoginView(ModelMap modelMap) {
		if( !modelMap.containsAttribute("login") ) {
			modelMap.addAttribute("login", new Login());
		}
		return "login/form";
	}

	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String processLogin(@Valid @ModelAttribute("login") Login login,
							   BindingResult result, 
							   RedirectAttributes flashScope) {
		if( result.hasErrors() ) {
			flashScope.addFlashAttribute("login", login);
			flashScope.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "login", result);
			
			return "redirect:/login";
		}
		return "redirect:/loginSuccessful";
	}
	
	@RequestMapping(path="/loginSuccessful", method=RequestMethod.GET)
	public String showSuccessfulLogin() {
		return "login/success";
	}

	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmationView() {
		return "register/confirmation";
	}
}
