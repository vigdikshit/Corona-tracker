package com.app.corona.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.corona.domain.CountryData;

@Repository
public interface CountryRepository extends MongoRepository<CountryData, Long>{

	public CountryData findByCountryName(String name);
	public List<CountryData> findAllByOrderByCasesDesc();
}
