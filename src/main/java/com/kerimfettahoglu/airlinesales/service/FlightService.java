package com.kerimfettahoglu.airlinesales.service;

import java.util.List;

import com.kerimfettahoglu.airlinesales.dto.AddFlightInput;
import com.kerimfettahoglu.airlinesales.entity.Airline;
import com.kerimfettahoglu.airlinesales.entity.Flight;

public interface FlightService {
	Flight save(Flight airline);
	public Flight save(AddFlightInput airline);
	Flight get(Integer id);
	Boolean delete(Integer id);
	List<Flight> getAll();
	List<Flight> getContains(String name);
}
