package it.ttf.nightowl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConsoleController {

	@Autowired
	private VenueRepository venueRepository;

	@GetMapping("/console")
	public String console(Model model) {
		model.addAttribute("venue", new Venue()).addAttribute("venues", venueRepository.findAll());
		return "console";
	}

	@PostMapping("/console")
	public void addVenue(@ModelAttribute Venue venue, Model model) {
		venueRepository.save(venue);
		console(model);
	}

}
