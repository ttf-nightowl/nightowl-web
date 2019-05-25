package it.ttf.nightowl.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Must not be blank")
	private String name;
	private String description;
	@Min(value = -90, message = "Must be between -90 and 90")
	@Max(value = 90, message = "Must be between -90 and 90")
	private double latitude;
	@Min(value = -180, message = "Must be between -180 and 180")
	@Max(value = 180, message = "Must be between -180 and 180")
	private double longitude;
	@Enumerated(EnumType.STRING)
	private VenueType type;

}
