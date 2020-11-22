package com.kerimfettahoglu.airlinesales.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kerimfettahoglu.airlinesales.entity.Airline;
import com.kerimfettahoglu.airlinesales.repo.AirlineRepository;
import com.kerimfettahoglu.airlinesales.service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {

	private final AirlineRepository airlineRepo;

	public AirlineServiceImpl(AirlineRepository airlineRepository) {
		this.airlineRepo = airlineRepository;
	}

	@Override
	public Airline save(Airline airline) {
		return airlineRepo.save(airline);
	}

	@Override
	public Airline get(Integer id) {
		Optional<Airline> airline = airlineRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Airline not found.");
		}
		return airline.get();
	}

	@Override
	public Boolean delete(Integer id) {
		Optional<Airline> airline = airlineRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Airline not found.");
		}
		airlineRepo.delete(airline.get());
		return true;
	}

	@Override
	public List<Airline> getAll() {
		return airlineRepo.findAll();
	}

	@Override
	public List<Airline> getContains(String name) {
		return airlineRepo.findByNameContainsIgnoreCase(name);
	}

}
