package com.app.corona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.corona.domain.StateData;
import com.app.corona.service.StateService;

@RestController
@RequestMapping("locations")
public class StateController {

	@Autowired
	private StateService stateService;
	
	@GetMapping("/coordinates")
	public List<StateData> getCoordinates() {
		return stateService.getCoordinates();		
	}
	
	@GetMapping("data/{name}")
	public List<StateData> getStateData(@PathVariable String name){
		return stateService.getStateData(name);
	}
}
