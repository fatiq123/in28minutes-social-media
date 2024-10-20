package com.fatiq.restful_api.social_media.entity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserService {

	private UserDaoService service;

	UserService(UserDaoService service) {
		this.service = service;
	}

	// GET /users
	@GetMapping("/users")
	public List<User> getUsers() {
		return service.findAll();
	}

	// http://localhost:8080/users/1
	
	// when working with hateoas we need following
	// EntityModel
	// WebMvcLinkBuilder
	// GET /user /id
	@GetMapping("/users/{id}")
	public EntityModel<User> getUserById(@PathVariable int id) {
		User user = service.userById(id);

		if (user == null)
			throw new UserNotFoundException("id: " + id);

		EntityModel<User> entityModel = EntityModel.of(user); 
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}

	// DELETE /user /id
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		service.deleteUserById(id);
	}

	// POST
	@PostMapping("/users")
	ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	
}
