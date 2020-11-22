package com.kerimfettahoglu.airlinesales.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Airline {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="airlineSeqGen")
	@SequenceGenerator(name="airlineSeqGen",sequenceName="airline_sequence")
	private Integer id;
	@Column
	private String name;
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "airline")
	Set<Flight> flights = new HashSet<Flight>();
	@JsonIgnore
	@Transient
	@ManyToMany(mappedBy = "airlines")
	Set<Airport> airports = new HashSet<Airport>();
}
