package it.ttf.nightowl.dao;

import org.springframework.data.repository.CrudRepository;

import it.ttf.nightowl.model.Venue;

public interface VenueRepository extends CrudRepository<Venue, Integer> {

}