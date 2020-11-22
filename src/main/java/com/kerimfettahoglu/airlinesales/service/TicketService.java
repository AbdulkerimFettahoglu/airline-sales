package com.kerimfettahoglu.airlinesales.service;

import java.util.List;

import com.kerimfettahoglu.airlinesales.dto.AddTicketInput;
import com.kerimfettahoglu.airlinesales.entity.Airline;
import com.kerimfettahoglu.airlinesales.entity.Ticket;

public interface TicketService {
	Ticket save(Ticket airline);
	Ticket get(Integer id);
	Boolean delete(Integer id);
	List<Ticket> getAll();
	Ticket sellTicket(AddTicketInput input);
}
