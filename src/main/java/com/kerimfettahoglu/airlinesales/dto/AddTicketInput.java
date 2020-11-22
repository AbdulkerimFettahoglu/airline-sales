package com.kerimfettahoglu.airlinesales.dto;

import lombok.Data;

@Data
public class AddTicketInput {
	private Integer flightId;
	private String creditCard;
}
