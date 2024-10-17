package com.fatiq.restful_api.social_media.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatiq.restful_api.social_media.app.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

//@Entity(name = "user_details")
@Entity
@Table(name = "users")
public class User {
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;  // a user can have multiple posts


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 2, message = "Name should be atleast 2 characters")	// Validation
//	@JsonProperty("user_name")	// Jackson
	private String name;
	
	//@Past(message = "BithDate should be in Past")
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
	

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", localDate=" + birthDate + "]";
	}

}
