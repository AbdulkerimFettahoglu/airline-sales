package com.kerimfettahoglu.airlinesales.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kerimfettahoglu.airlinesales.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
}
