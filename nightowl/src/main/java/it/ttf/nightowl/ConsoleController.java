package it.ttf.nightowl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsoleController {

	@Autowired
	private VenueRepository venueRepository;
	
    @GetMapping("/console")
    public String console(Model model) {
    	venueRepository.save(new Venue("Alcatraz", "Nightclub in Milan", 1.0, 2.0, VenueType.NIGHTCLUB));
    	venueRepository.save(new Venue("Maggie's Park", "The best if you're looking for a MILF", 2.0, 3.0, VenueType.NIGHTCLUB));
        model.addAttribute("venues", venueRepository.findAll());
        return "console";
    }
	
}
