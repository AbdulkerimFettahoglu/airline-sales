package com.kerimfettahoglu.airlinesales.service;

import java.util.List;

import com.kerimfettahoglu.airlinesales.entity.Airline;

public interface AirlineService {
	Airline save(Airline airline);
	Airline get(Integer id);
	Boolean delete(Integer id);
	List<Airline> getAll();
	List<Airline> getContains(String name);
}
