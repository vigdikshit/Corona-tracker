package com.app.corona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.corona.domain.CountryData;
import com.app.corona.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	private CountryRepository countryRepo;

	public List<CountryData> getCountryData() {
		return countryRepo.findAllByOrderByCasesDesc();
	}

	public Optional<CountryData> getAllStats() {
		return countryRepo.findById(9999L);
	}
}
