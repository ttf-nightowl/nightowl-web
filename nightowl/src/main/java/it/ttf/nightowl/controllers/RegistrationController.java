package it.ttf.nightowl.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.ttf.nightowl.dao.UserRepository;
import it.ttf.nightowl.model.RegistrationData;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private static final String USERNAME_ERROR_MESSAGE = "Username already taken";
	private static final String PASSWORD_ERROR_MESSAGE = "Passwords don't match";

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public String showRegistrationPage(RegistrationData registrationData) {
		return "register";
	}

	@PostMapping
	public String registerUser(@Valid RegistrationData registrationData, Errors errors, Model model) {
		// validate against bean constraints
		if (errors.hasErrors()) {
			return "register";
		}
		
		// check for unique username
		if (userRepository.findByUsername(registrationData.getUsername()) != null) {
			model.addAttribute("error", USERNAME_ERROR_MESSAGE);
			return "register";
		}
		
		// check for matching passwords
		if (!registrationData.getPassword().equals(registrationData.getConfirmPassword())) {
			model.addAttribute("error", PASSWORD_ERROR_MESSAGE);
			return "register";
		}
		
		// save user
		userRepository.save(registrationData.toUser(passwordEncoder));
		return "redirect:/login";
	}

}
