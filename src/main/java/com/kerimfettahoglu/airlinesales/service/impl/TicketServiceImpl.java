package com.kerimfettahoglu.airlinesales.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kerimfettahoglu.airlinesales.dto.AddTicketInput;
import com.kerimfettahoglu.airlinesales.entity.Flight;
import com.kerimfettahoglu.airlinesales.entity.Ticket;
import com.kerimfettahoglu.airlinesales.repo.FlightRepository;
import com.kerimfettahoglu.airlinesales.repo.TicketRepository;
import com.kerimfettahoglu.airlinesales.service.TicketService;
import com.kerimfettahoglu.airlinesales.util.Helper;

@Service
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepo;
	private final FlightRepository flightRepo;

	public TicketServiceImpl(TicketRepository airlineRepository, FlightRepository flightRepo) {
		this.ticketRepo = airlineRepository;
		this.flightRepo = flightRepo;
	}

	@Override
	public Ticket save(Ticket airline) {
		return ticketRepo.save(airline);
	}

	@Override
	public Ticket get(Integer id) {
		Optional<Ticket> airline = ticketRepo.findById(id);
		if (airline.isEmpty()) {
			throw new IllegalArgumentException("Ticket not found.");
		}
		return airline.get();
	}

	@Override
	public Boolean delete(Integer id) {
		Optional<Ticket> ticket = ticketRepo.findById(id);
		if (ticket.isEmpty()) {
			throw new IllegalArgumentException("Ticket not found.");
		}
		Flight f = ticket.get().getFlight();
		f.cancelSeat();
		flightRepo.save(f);
		ticketRepo.delete(ticket.get());
		return true;
	}

	@Override
	public List<Ticket> getAll() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket sellTicket(AddTicketInput input) {
		Optional<Flight> f = flightRepo.findById(input.getFlightId());
		if (f.isEmpty()) {
			throw new IllegalArgumentException("Flight not found.");
		}
		;
		if (f.get().sellSeat() == false) {
			throw new IllegalArgumentException("Flight is not available.");
		}
		String creditCard = Helper.getMaskedCreditCardNumber(input.getCreditCard());
		Ticket t = new Ticket();
		t.setCreditCard(creditCard);
		t.setFlight(f.get());
		t.setStatus(true);
		t.setPrice(Helper.calculateSeatPrice(f.get()));
		return ticketRepo.save(t);
	}	
}
