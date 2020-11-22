package com.kerimfettahoglu.airlinesales.dto;

import lombok.Data;

@Data
public class AddRouteInput {
	private String name;
	private Integer fromAirportId;
	private Integer toAirportId;
}
