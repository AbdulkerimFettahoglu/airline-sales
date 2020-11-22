package com.kerimfettahoglu.airlinesales.service;

import java.util.List;

import com.kerimfettahoglu.airlinesales.dto.AddAirlineToAirportInput;
import com.kerimfettahoglu.airlinesales.entity.Airport;

public interface AirportService {
	Airport save(Airport airline);
	Airport get(Integer id);
	Boolean delete(Integer id);
	List<Airport> getAll();
	List<Airport> getContains(String name);
	Boolean addAirlineToAirport(AddAirlineToAirportInput input);
}
