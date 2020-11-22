package com.kerimfettahoglu.airlinesales.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AddFlightInput {
	private String name;
	private Integer capacity;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm")
	private Date departure;
	private Double basePrice;
	private Integer routeId;
	private Integer airlineId;

}
