package com.kerimfettahoglu.airlinesales.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kerimfettahoglu.airlinesales.dto.AddRouteInput;
import com.kerimfettahoglu.airlinesales.entity.Airport;
import com.kerimfettahoglu.airlinesales.entity.Route;
import com.kerimfettahoglu.airlinesales.repo.AirportRepository;
import com.kerimfettahoglu.airlinesales.repo.RouteRepository;
import com.kerimfettahoglu.airlinesales.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {
	private final RouteRepository routeRepo;
	private final AirportRepository airportRepo;
	
	public RouteServiceImpl(RouteRepository airlineRepository, AirportRepository airportRepo) {
		this.routeRepo = airlineRepository;
		this.airportRepo = airportRepo;
	}

	@Override
	public Route save(AddRouteInput input) {
		Optional<Airport> fromPort = airportRepo.findById(input.getFromAirportId());
		Optional<Airport> toPort = airportRepo.findById(input.getToAirportId());
		if (fromPort.isEmpty() || toPort.isEmpty()) {
			throw new IllegalArgumentException("From port or destination port not found.");
		}
		Route route = new Route();
		route.setFrom(fromPort.get());
		route.setTo(toPort.get());
		route.setName(input.getName());
		return routeRepo.save(route);
	}
	
	@Override
	public Route save(Route airline) {
		return routeRepo.save(airline);
	}

	@Override
	public Route get(Integer id) {
		Optional<Route> airline = routeRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Flight not found.");
		}
		return airline.get();
	}

	@Override
	public Boolean delete(Integer id) {
		Optional<Route> airline = routeRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Flight not found.");
		}
		routeRepo.delete(airline.get());
		return true;
	}

	@Override
	public List<Route> getAll() {
		return routeRepo.findAll();
	}
	
	@Override
	public List<Route> getContains(String name) {
		return routeRepo.findByNameContainsIgnoreCase(name);
	}
}
