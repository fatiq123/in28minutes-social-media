package com.fatiq.restful_api.social_media.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id;

	@Size(min = 2, message = "Name should be atleast 2 characters")	// Validation
	@JsonProperty("user_name")	// Jackson
	private String name;
	
	@Past(message = "BithDate should be in Past")
	@JsonProperty("birth_date")	// Jackson
	private LocalDate birthDate;

	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getLocalDate() {
		return birthDate;
	}

	public void setLocalDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", localDate=" + birthDate + "]";
	}

}
