package com.kerimfettahoglu.airlinesales.dto;

import lombok.Data;

@Data
public class AddAirlineToAirportInput {
	private Integer airlineId;
	private Integer airportId;
}
