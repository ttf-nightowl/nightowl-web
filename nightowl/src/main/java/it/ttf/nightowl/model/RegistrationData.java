package it.ttf.nightowl.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
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

}
