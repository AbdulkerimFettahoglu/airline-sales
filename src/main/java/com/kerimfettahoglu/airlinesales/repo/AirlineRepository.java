package com.kerimfettahoglu.airlinesales.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kerimfettahoglu.airlinesales.entity.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer>{
	List<Airline> findByNameContainsIgnoreCase(String name);
}
