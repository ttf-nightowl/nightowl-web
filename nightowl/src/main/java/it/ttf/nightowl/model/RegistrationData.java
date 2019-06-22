package it.ttf.nightowl.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationData {

	@NotBlank(message = "Must not be blank")
	private String name;
	@NotBlank(message = "Must not be blank")
	private String surname;
	@NotBlank(message = "Must not be blank")
	private String username;
	@Size(min = 8, message = "Must be at least 8 characters long")
	private String password;
	private String passwordConfirmation;

	public User toUser(PasswordEncoder passwordEncoder) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setName(name);
		user.setSurname(surname);
		return user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

}
