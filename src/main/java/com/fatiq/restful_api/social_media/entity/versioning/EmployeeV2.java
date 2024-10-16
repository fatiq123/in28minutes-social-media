package com.fatiq.restful_api.social_media.entity.versioning;

public class EmployeeV2 {

	private Name name;

	public EmployeeV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "EmployeeV2 [name=" + name + "]";
	}

}
