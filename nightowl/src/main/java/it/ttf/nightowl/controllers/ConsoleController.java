package it.ttf.nightowl.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.ttf.nightowl.model.Venue;
import it.ttf.nightowl.repositories.VenueRepository;

@Controller
public class ConsoleController {

	@Autowired
	private VenueRepository venueRepository;

	@GetMapping("/console")
	public String showConsole(Model model) {
		model.addAttribute("venue", new Venue());
		model.addAttribute("venues", venueRepository.findAll());
		return "console";
	}

	@PostMapping("/console")
	public String addVenue(@Valid Venue venue, Errors errors) {
		if (errors.hasErrors()) {
			return "console";
		}
		venueRepository.save(venue);
		return "redirect:/console";
	}

}
