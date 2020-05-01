package com.app.corona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.corona.domain.StateData;
import com.app.corona.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepo;
	
	public List<StateData> getCoordinates() {
		return stateRepo.findAll();
	}

	public List<StateData> getStateData(String name) {
		return stateRepo.findAllByCountryName(name);
	}

}
