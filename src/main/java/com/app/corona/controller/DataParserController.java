package com.app.corona.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.corona.service.DataParserService;
import com.opencsv.exceptions.CsvValidationException;

@RestController
@RequestMapping("/dataparser")
public class DataParserController {

	@Autowired
	private DataParserService dataParserService;

	@GetMapping("/data")
	public String setData() throws CsvValidationException, IOException {
		dataParserService.setData();
		return "Done!";
	}

}
