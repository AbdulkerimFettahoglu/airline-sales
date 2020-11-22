package com.kerimfettahoglu.airlinesales.service;

import java.util.List;

import com.kerimfettahoglu.airlinesales.dto.AddRouteInput;
import com.kerimfettahoglu.airlinesales.entity.Airline;
import com.kerimfettahoglu.airlinesales.entity.Route;

public interface RouteService {
	Route save(Route airline);
	Route save(AddRouteInput input);
	Route get(Integer id);
	Boolean delete(Integer id);
	List<Route> getAll();
	List<Route> getContains(String name);
}
