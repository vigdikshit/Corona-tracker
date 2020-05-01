package com.app.corona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.corona.domain.CountryData;
import com.app.corona.service.CountryService;

@RestController
@RequestMapping("/data")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/countryData")
	public List<CountryData> getCountryData() {
		return countryService.getCountryData();		
	}
	
	@GetMapping("/getAllStats")
	public Optional<CountryData> getAllStats() {
		return countryService.getAllStats();
	}
	
}
