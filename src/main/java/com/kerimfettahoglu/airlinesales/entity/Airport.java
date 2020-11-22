package com.kerimfettahoglu.airlinesales.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Airport {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="airportSeqGen")
	@SequenceGenerator(name="airportSeqGen",sequenceName="airport_sequence")
	private Integer id;
	@Column
	private String name;
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "to")
	Set<Route> incomingFlights = new HashSet<Route>();
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "from")
	Set<Route> outgoingFlights = new HashSet<Route>();
	@ManyToMany
	@JoinTable(name = "airport_airline", joinColumns = @JoinColumn(name = "airport_id"), inverseJoinColumns = @JoinColumn(name = "airline_id"))
	Set<Airline> airlines = new HashSet<Airline>();
}
