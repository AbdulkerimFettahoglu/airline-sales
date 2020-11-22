package com.kerimfettahoglu.airlinesales.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kerimfettahoglu.airlinesales.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Integer>{
	List<Route> findByNameContainsIgnoreCase(String name);
}
