package com.flairstech.app.controllers;

import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flairstech.app.config.CustomException;
import com.flairstech.app.domain.Country;
import com.flairstech.app.services.CountryService;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;

@RestController
public class CountryController {

	private final static Logger LOG = LoggerFactory.getLogger(CountryController.class);
	
	private final static String FILTER_JSON = ""
			+ "name,"
			+ "continent,"
			+ "population,"
			+ "life_expectancy,"
			+ "countryLanguages[**,-country]";

	@Autowired
	private DataSource dataSource;

	@Autowired
	private CountryService countryService;

	@GetMapping("/{country_code}")
	@ResponseBody
	@Transactional
	public String getCountryByCode(@PathVariable(value = "country_code") String country_code) throws CustomException, SQLException {
		
		Optional.ofNullable(dataSource.getConnection().getCatalog())
				.orElseThrow(() -> new CustomException("INTERNAL_ERROR - CHECK YOUR CONNECTION"));
		
		Optional.ofNullable(country_code)
				.orElseThrow(() -> new CustomException("INVALID_COUNTRY_CODE"));
		
		Country country = countryService.findByCode(country_code)
				.orElseThrow(() -> new CustomException("NOT_FOUND"));
		
		return SquigglyUtils.stringify(Squiggly.init(new ObjectMapper(), FILTER_JSON), country);
	}

}
