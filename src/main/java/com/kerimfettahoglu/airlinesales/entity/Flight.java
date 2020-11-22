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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightSeqGen")
	@SequenceGenerator(name = "flightSeqGen", sequenceName = "flight_sequence")
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer capacity;
	@Column
	private Integer soldTicket = 0;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm")
	private Date departure;
	@Column
	private Boolean status;
	@Column
	private Double basePrice;
	@ManyToOne
	@JoinColumn(name = "rota_id")
	private Route route;
	@ManyToOne
	@JoinColumn(name = "airline_id")
	private Airline airline;
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "flight")
	private Set<Ticket> tickets = new HashSet<Ticket>();

	private boolean isAvailable() {
		return (this.soldTicket + 1 > this.capacity) ? false : true;
	}

	public boolean sellSeat() {
		if (this.status == true && this.isAvailable()) {
			this.soldTicket++;
			return true;
		}
		return false;
	}
	
	public boolean cancelSeat() {
		this.soldTicket--;
		this.status = true;
		return true;
	}
}
