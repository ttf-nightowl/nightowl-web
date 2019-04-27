package it.ttf.nightowl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VenueFinder {

	private final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

	@Autowired
	private VenueRepository venueRepository;

	public List<Venue> find(double latitude, double longitude) {
		// create tree map to hold distance-venue pairs, entries are automatically
		// sorted by distance
		Map<Integer, Venue> map = new TreeMap<Integer, Venue>();

		// populate map with all venues and respective distance from user location
		for (Venue venue : venueRepository.findAll()) {
			map.put(getDistanceInKm(latitude, longitude, venue), venue);
		}

		// extract ordered list of venues
		List<Venue> list = new ArrayList<Venue>(map.values());

		// return first ten venues
		return list.subList(0, 10);
	}

	// get distance from user coordinates to venue (haversine formula)
	private int getDistanceInKm(double userLat, double userLng, Venue venue) {
		double venueLat = venue.getLatitude();
		double venueLng = venue.getLongitude();

		double latDistance = Math.toRadians(userLat - venueLat);
		double lngDistance = Math.toRadians(userLng - venueLng);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat)) * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
	}

}
