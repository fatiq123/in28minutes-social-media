package com.fatiq.restful_api.social_media.entity.versioning;

public class EmployeeV1 {

	private String name;

	public EmployeeV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}
