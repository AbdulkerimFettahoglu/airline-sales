package com.kerimfettahoglu.airlinesales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ticketSeqGen")
	@SequenceGenerator(name="ticketSeqGen",sequenceName="ticket_sequence")
	private Integer id;
	@Column
	private String creditCard;
	@Column
	private Double price;
	@Column
	private Boolean status;
	@ManyToOne
	@JoinColumn(name="flight_id")
	private Flight flight;

}
