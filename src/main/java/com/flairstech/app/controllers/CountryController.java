package com.flairstech.app.controllers;

import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flairstech.app.config.CustomException;
import com.flairstech.app.domain.Country;
import com.flairstech.app.services.CountryService;

@RestController
public class CountryController {
	
	private final static Logger LOG = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private CountryService countryService;

	@GetMapping("/{country_code}")
	@ResponseBody
	public Country getCountryByCode(@PathVariable(value = "country_code") String country_code) throws CustomException, SQLException {
		Optional.ofNullable(dataSource.getConnection().getCatalog()).orElseThrow(() -> new CustomException("INTERNAL_ERROR - CHECK YOUR CONNECTION"));
		Optional.ofNullable(country_code).orElseThrow(() -> new CustomException("INVALID_COUNTRY_CODE"));
		return countryService.findByCode(country_code).orElseThrow(() -> new CustomException("NOT_FOUND"));
	}

}
