package com.kerimfettahoglu.airlinesales.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kerimfettahoglu.airlinesales.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer>{
	List<Airport> findByNameContainsIgnoreCase(String name);
}
