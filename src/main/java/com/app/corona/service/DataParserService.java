package com.app.corona.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.corona.domain.CountryData;
import com.app.corona.domain.StateData;
import com.app.corona.repository.CountryRepository;
import com.app.corona.repository.StateRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class DataParserService {

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private StateRepository stateRepository;

	public void setData() throws CsvValidationException, IOException {
		String file = "C:\\Users\\diksh\\Desktop\\corona_03-12-2020.csv";
		FileReader fileReader = new FileReader(file);
		CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
		String[] nextRecord;

		Long stateId = 100L, countryId = 100L;
		Map<String, List<Long>> caseMap = new HashMap<>();
		List<StateData> stateDataList = new ArrayList<>();
		Long totalCases = 0L, totalDeaths = 0L, totalRecovered = 0L;

		while ((nextRecord = csvReader.readNext()) != null) {
			if (caseMap.containsKey(nextRecord[1])) {
				List<Long> getList = caseMap.get(nextRecord[1]);
				getList.set(0, getList.get(0) + Long.parseLong(nextRecord[3]));
				getList.set(1, getList.get(1) + Long.parseLong(nextRecord[4]));
				getList.set(2, getList.get(2) + Long.parseLong(nextRecord[5]));
				caseMap.put(nextRecord[1], getList);
			} else {
				List<Long> caseList = new ArrayList<>();
				caseList.add(Long.parseLong(nextRecord[3]));
				caseList.add(Long.parseLong(nextRecord[4]));
				caseList.add(Long.parseLong(nextRecord[5]));
				caseMap.put(nextRecord[1], caseList);
			}
			//if (nextRecord[0].length() != 0 || !nextRecord[0].equals("")) {
				StateData stateData = new StateData();
				stateData.setId(stateId);
				stateData.setState(nextRecord[0]);
				stateData.setCountryName(nextRecord[1]);
				stateData.setLastUpdated(nextRecord[2]);
				stateData.setCases(Long.parseLong(nextRecord[3]));
				stateData.setDeaths(Long.parseLong(nextRecord[4]));
				stateData.setRecovered(Long.parseLong(nextRecord[5]));
				stateData.setLatitude(Double.parseDouble(nextRecord[6]));
				stateData.setLongitude(Double.parseDouble(nextRecord[7]));
				stateDataList.add(stateData);
				stateId++;
		//	}
		}

		for (Map.Entry<String, List<Long>> entrySet : caseMap.entrySet()) {
			CountryData countryData = new CountryData();
			countryData.setId(countryId);
			countryData.setCountryName(entrySet.getKey());
			countryData.setCases(entrySet.getValue().get(0));
			countryData.setDeaths(entrySet.getValue().get(1));
			countryData.setRecovered(entrySet.getValue().get(2));
			countryRepository.save(countryData);
			countryId++;
			totalCases += entrySet.getValue().get(0);
			totalDeaths += entrySet.getValue().get(1);
			totalRecovered += entrySet.getValue().get(2);
		}
		CountryData countryData = new CountryData();
		countryData.setId(9999L);
		countryData.setCountryName("AllCountries");
		countryData.setCases(totalCases);
		countryData.setDeaths(totalDeaths);
		countryData.setRecovered(totalRecovered);
		countryRepository.save(countryData);
		
		for (StateData state : stateDataList) {
			CountryData cd = countryRepository.findByCountryName(state.getCountryName());
			state.setCountryId(cd.getId());
			stateRepository.save(state);
		}
		csvReader.close();
	}
}
