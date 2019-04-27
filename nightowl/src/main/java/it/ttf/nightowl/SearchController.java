package it.ttf.nightowl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@Autowired
	private VenueFinder venueFinder;

	@GetMapping("/search")
	public List<Venue> search(@RequestParam(value = "latitude") double latitude, @RequestParam(value = "longitude") double longitude) {
		return venueFinder.find(latitude, longitude);
	}

}
