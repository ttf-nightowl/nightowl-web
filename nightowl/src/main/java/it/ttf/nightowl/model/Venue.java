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

@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String name;
	private String description;
	@Min(-90)
	@Max(90)
	private double latitude;
	@Min(-180)
	@Max(180)
	private double longitude;
	@Enumerated(EnumType.STRING)
	private VenueType type;

	public Venue() {
	}

	public Venue(String name, String description, double latitude, double longitude, VenueType type) {
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public VenueType getType() {
		return type;
	}

	public void setType(VenueType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", description=" + description + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", type=" + type + "]";
	}

}
