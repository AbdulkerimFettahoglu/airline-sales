package com.kerimfettahoglu.airlinesales.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Route {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="rotaSeqGen")
	@SequenceGenerator(name="rotaSeqGen",sequenceName="rota_sequence")
	private Integer id;
	@Column
	private String name;
	@ManyToOne
	@JoinColumn(name="from_port_id")
	Airport from;
	@ManyToOne
	@JoinColumn(name="to_port_id")
	Airport to;
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "rota")
	Set<Flight> flights = new HashSet<Flight>();

}
