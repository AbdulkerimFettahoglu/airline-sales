package com.kerimfettahoglu.airlinesales.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.kerimfettahoglu.airlinesales.dto.AddAirlineToAirportInput;
import com.kerimfettahoglu.airlinesales.entity.Airline;
import com.kerimfettahoglu.airlinesales.entity.Airport;
import com.kerimfettahoglu.airlinesales.repo.AirlineRepository;
import com.kerimfettahoglu.airlinesales.repo.AirportRepository;
import com.kerimfettahoglu.airlinesales.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {
	private final AirportRepository airportRepo;
	private final AirlineRepository airlineRepo;

	public AirportServiceImpl(AirportRepository airportRepository, AirlineRepository airlineRepository) {
		this.airportRepo = airportRepository;
		this.airlineRepo = airlineRepository;
	}

	@Override
	public Airport save(Airport airline) {
		return airportRepo.save(airline);
	}

	@Override
	public Airport get(Integer id) {
		Optional<Airport > airline = airportRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Airport not found.");
		}
		return airline.get();
	}

	@Override
	public Boolean delete(Integer id) {
		Optional<Airport> airline = airportRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Airport not found.");
		}
		airportRepo.delete(airline.get());
		return true;
	}

	@Override
	public List<Airport> getAll() {
		return airportRepo.findAll();
	}
	
	@Override
	public List<Airport> getContains(String name) {
		return airportRepo.findByNameContainsIgnoreCase(name);
	}

	@Override
	public Boolean addAirlineToAirport(AddAirlineToAirportInput input) {
		Optional<Airline> line = airlineRepo.findById(input.getAirlineId());
		Optional<Airport> port = airportRepo.findById(input.getAirportId());
		if (line.isEmpty() || port.isEmpty()) {
			throw new IllegalArgumentException("Airport or airline not found.");
		}
		Airport portObject = port.get();
		Set<Airline> set = portObject.getAirlines();
		set.add(line.get());
		airportRepo.save(portObject);
		return true;
	}
}
