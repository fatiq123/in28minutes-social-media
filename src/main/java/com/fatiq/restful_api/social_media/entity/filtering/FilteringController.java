package com.fatiq.restful_api.social_media.entity.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@RequestMapping("/filtering")
	public MappingJacksonValue getBean() {
		SomeBean someBean = new SomeBean("field1", "field2", "field3");

		// for dynamic filtering
		MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		jacksonValue.setFilters(filters);

		return jacksonValue;
	}

	@RequestMapping("/filtering-list") // implement field2, field2
	public MappingJacksonValue getBeanList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("field1", "field2", "field3"),
				new SomeBean("field4", "field5", "field6"));

		// for dynamic filtering
		MappingJacksonValue jacksonValue = new MappingJacksonValue(list);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilterList", filter);
		jacksonValue.setFilters(filters);

		return jacksonValue;
	}

}
