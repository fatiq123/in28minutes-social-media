package com.fatiq.restful_api.social_media.entity;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class International {

	MessageSource messageSource;

	public International(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping("/hello-international")
	public String hello_internationalize() {

		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

}
