package com.fatiq.restful_api.social_media.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {


	public UserNotFoundException(String message) {
		super(message);
	}
}
