package com.kerimfettahoglu.airlinesales.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kerimfettahoglu.airlinesales.dto.AddFlightInput;
import com.kerimfettahoglu.airlinesales.entity.Airline;
import com.kerimfettahoglu.airlinesales.entity.Flight;
import com.kerimfettahoglu.airlinesales.entity.Route;
import com.kerimfettahoglu.airlinesales.repo.AirlineRepository;
import com.kerimfettahoglu.airlinesales.repo.FlightRepository;
import com.kerimfettahoglu.airlinesales.repo.RouteRepository;
import com.kerimfettahoglu.airlinesales.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	private final FlightRepository flightRepo;
	private final AirlineRepository airlineRepo;
	private final RouteRepository routeRepo;

	public FlightServiceImpl(FlightRepository flightRepository, AirlineRepository airlineRepo, RouteRepository routeRepo) {
		this.flightRepo = flightRepository;
		this.airlineRepo = airlineRepo;
		this.routeRepo = routeRepo;
	}

	@Override
	public Flight save(Flight airline) {
		return flightRepo.save(airline);
	}
	
	@Override
	public Flight save(AddFlightInput input) {
		Date now = new Date();
		if (now.compareTo(input.getDeparture())>0) {
			throw new IllegalArgumentException("Departure date should be bigger than now.");
		}
		Optional<Airline> airline = airlineRepo.findById(input.getAirlineId());
		Optional<Route> route = routeRepo.findById(input.getRouteId());
		if (route.isEmpty() || airline.isEmpty()) {
			throw new IllegalArgumentException("Airline or route not found.");
		}
		Flight flight = new Flight();
		flight.setAirline(airline.get());
		flight.setRoute(route.get());
		flight.setName(input.getName());
		flight.setBasePrice(input.getBasePrice());
		flight.setCapacity(input.getCapacity());
		flight.setDeparture(input.getDeparture());
		flight.setName(input.getName());
		flight.setStatus(true);
		return flightRepo.save(flight);
	}

	@Override
	public Flight get(Integer id) {
		Optional<Flight> airline = flightRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Flight not found.");
		}
		return airline.get();
	}

	@Override
	public Boolean delete(Integer id) {
		Optional<Flight> airline = flightRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Flight not found.");
		}
		flightRepo.delete(airline.get());
		return true;
	}

	@Override
	public List<Flight> getAll() {
		return flightRepo.findAll();
	}
	
	@Override
	public List<Flight> getContains(String name) {
		return flightRepo.findByNameContainsIgnoreCase(name);
	}
}
