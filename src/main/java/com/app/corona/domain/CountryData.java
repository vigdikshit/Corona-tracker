package com.app.corona.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document("country_data")
public class CountryData {

	@Id
	@JsonIgnore
	private Long id;
	private String countryName;
	private Long cases;
	private Long deaths;
	private Long recovered;
	
	public CountryData(Long id, String countryName, Long cases, Long deaths, Long recovered) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.cases = cases;
		this.deaths = deaths;
		this.recovered = recovered;
	}

	public CountryData() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getCases() {
		return cases;
	}

	public void setCases(Long cases) {
		this.cases = cases;
	}

	public Long getDeaths() {
		return deaths;
	}

	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}

	public Long getRecovered() {
		return recovered;
	}

	public void setRecovered(Long recovered) {
		this.recovered = recovered;
	}

	@Override
	public String toString() {
		return "CountryData [id=" + id + ", countryName=" + countryName + ", cases=" + cases + ", deaths=" + deaths
				+ ", recovered=" + recovered + "]";
	}
	
}
