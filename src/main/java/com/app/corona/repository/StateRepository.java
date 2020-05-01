package com.app.corona.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.corona.domain.StateData;

@Repository
public interface StateRepository extends MongoRepository<StateData, Long>{

	@Query(fields = "{'latitude' : 0, 'longitude' : 0, 'id': 0, 'countryId': 0, 'countryName':0, 'lastUpdated':0}")
	public List<StateData> findAllByCountryName(String name);
}
