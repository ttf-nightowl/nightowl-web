package it.ttf.nightowl.repositories;

import org.springframework.data.repository.CrudRepository;

import it.ttf.nightowl.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
	
}
