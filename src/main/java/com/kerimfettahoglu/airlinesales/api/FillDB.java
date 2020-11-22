package com.kerimfettahoglu.airlinesales.api;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kerimfettahoglu.airlinesales.entity.Airline;
import com.kerimfettahoglu.airlinesales.entity.Airport;
import com.kerimfettahoglu.airlinesales.entity.Flight;
import com.kerimfettahoglu.airlinesales.entity.Route;
import com.kerimfettahoglu.airlinesales.entity.Ticket;
import com.kerimfettahoglu.airlinesales.service.impl.AirlineServiceImpl;
import com.kerimfettahoglu.airlinesales.service.impl.AirportServiceImpl;
import com.kerimfettahoglu.airlinesales.service.impl.FlightServiceImpl;
import com.kerimfettahoglu.airlinesales.service.impl.RouteServiceImpl;
import com.kerimfettahoglu.airlinesales.service.impl.TicketServiceImpl;

@RestController
@RequestMapping(value = "/fill")
public class FillDB {
	private final AirlineServiceImpl airlineServiceImpl;
	private final AirportServiceImpl airportServiceImpl;
	private final FlightServiceImpl flightServiceImpl;
	private final RouteServiceImpl routeServcieImpl;
	private final TicketServiceImpl ticketServiceImpl;

	public FillDB(AirlineServiceImpl airlineServiceImpl, AirportServiceImpl airportServiceImpl,
			FlightServiceImpl flightServiceImpl, RouteServiceImpl routeServcieImpl, TicketServiceImpl ticketServiceImpl) {
		super();
		this.airlineServiceImpl = airlineServiceImpl;
		this.airportServiceImpl = airportServiceImpl;
		this.flightServiceImpl = flightServiceImpl;
		this.routeServcieImpl = routeServcieImpl;
		this.ticketServiceImpl = ticketServiceImpl;
	}

	@GetMapping
	@RequestMapping("/withData")
	@Transactional
	public boolean fillDb() {
		Airline airline1 = new Airline();
		airline1.setName("THY");
		Airline airline2 = new Airline();
		airline2.setName("Emirates");
		Airline airline3 = new Airline();
		airline3.setName("Etihad");
		Airline airline4 = new Airline();
		airline4.setName("Pegasus");
		Airport port1 = new Airport();
		port1.setName("SAW");
		Airport port2 = new Airport();
		port2.setName("IST");
		Airport port3 = new Airport();
		port3.setName("BER");
		Airport port4 = new Airport();
		port4.setName("HAM");
		Set<Airline> p1Airlines = new HashSet<Airline>();
		p1Airlines.add(airline1);
		p1Airlines.add(airline2);
		Set<Airline> p2Airlines = new HashSet<Airline>();
		p2Airlines.add(airline1);
		port1.setAirlines(p1Airlines);
		port2.setAirlines(p2Airlines);
		airlineServiceImpl.save(airline1);
		airlineServiceImpl.save(airline2);
		airlineServiceImpl.save(airline3);
		airlineServiceImpl.save(airline4);
		airportServiceImpl.save(port1);
		airportServiceImpl.save(port2);
		airportServiceImpl.save(port3);
		airportServiceImpl.save(port4);
		return true;
	}
	
	@GetMapping
	@RequestMapping("/withRoute")
	@Transactional
	public boolean fillRoute() {
		Airline airline1 = airlineServiceImpl.get(1);
		Airline airline2 = airlineServiceImpl.get(2);
		Airport port1 = airportServiceImpl.get(1);
		Airport port2 = airportServiceImpl.get(2);
		Airport port3 = airportServiceImpl.get(3);
		Airport port4 = airportServiceImpl.get(4);
		Route r1 = new Route();
		Route r2 = new Route();
		r1.setName(airline1.getName() + " from :" + port1.getName() + " to :" + port2.getName());
		r1.setFrom(port1);
		r1.setTo(port2);
		r2.setName(airline2.getName() + " from :" + port3.getName() + " to :" + port4.getName());
		r2.setFrom(port3);
		r2.setTo(port4);
		routeServcieImpl.save(r1);
		routeServcieImpl.save(r2);
		return true;
	}
	
	@GetMapping
	@RequestMapping("/withFlights")
	@Transactional
	public boolean fillFlights() {
		Airline thy = airlineServiceImpl.get(1);
		Airline emirates = airlineServiceImpl.get(2);
		Airline etihad = airlineServiceImpl.get(3);
		Airline pegasus = airlineServiceImpl.get(4);
		Route saw_ist = routeServcieImpl.get(1);
		Route ber_ham = routeServcieImpl.get(2);
		Flight f1 = new Flight();
		f1.setCapacity(10);
		f1.setDeparture(new Date());
		f1.setName(saw_ist.getName() + " flight");
		f1.setRoute(saw_ist);
		f1.setAirline(thy);
		f1.setStatus(true);
		f1.setSoldTicket(0);
		f1.setBasePrice(100D);
		Flight f2 = new Flight();
		f2.setCapacity(10);
		f2.setDeparture(new Date());
		f2.setName(ber_ham.getName() + " flight");
		f2.setRoute(ber_ham);
		f2.setAirline(etihad);
		f2.setStatus(true);
		f2.setSoldTicket(0);
		f2.setBasePrice(200D);
		flightServiceImpl.save(f1);
		flightServiceImpl.save(f2);
		return true;
	}
	
	@GetMapping
	@RequestMapping("/withTickets")
	@Transactional	
	public boolean fillTickets() {
		Flight saw_ist = flightServiceImpl.get(1);
		Flight ber_ham = flightServiceImpl.get(2);
		Ticket saw_ist_t1 = new Ticket();
		Ticket ber_ham_t1 = new Ticket();
		saw_ist_t1.setCreditCard("credit1");
		saw_ist_t1.setFlight(saw_ist);
		saw_ist_t1.setStatus(true);
		
		return true;
	}
}
