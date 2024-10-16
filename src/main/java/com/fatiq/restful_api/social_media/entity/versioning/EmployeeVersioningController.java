package com.fatiq.restful_api.social_media.entity.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeVersioningController {

	@GetMapping("/v1/employee")
	public EmployeeV1 getFirstVersionOfEmployee() {
		return new EmployeeV1("Fatiq Hussnain");
	}

	@GetMapping("/v2/employee")
	public EmployeeV2 getSecondVersionOfEmployee() {
		return new EmployeeV2(new Name("Fatiq", "Hussnain"));
	}

	
	@GetMapping(path = "/employee", params = "version=1")
	public EmployeeV1 getFirstVersionOfEmployeeRequestParameter() {
		return new EmployeeV1("Fatiq Hussnain");
	}
	
	@GetMapping(path = "/employee", params = "version=2")
	public EmployeeV2 getSecondVersionOfEmployeeRequestParameter() {
		return new EmployeeV2(new Name("Fatiq", "Hussnain"));
	}
	
	
	@GetMapping(path = "/employee/header", headers = "X-API-VERSION=1")
	public EmployeeV1 getFirstVersionOfEmployeeRequestHeader() {
		return new EmployeeV1("Fatiq Hussnain");
	}
	
	@GetMapping(path = "/employee/header", headers = "X-API-VERSION=2")
	public EmployeeV2 getSecondVersionOfEmployeeRequestHeader() {
		return new EmployeeV2(new Name("Fatiq", "Hussnain"));
	}

}
