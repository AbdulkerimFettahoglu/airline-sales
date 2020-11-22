package com.kerimfettahoglu.airlinesales.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kerimfettahoglu.airlinesales.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	List<Flight> findByNameContainsIgnoreCase(String name);
}
