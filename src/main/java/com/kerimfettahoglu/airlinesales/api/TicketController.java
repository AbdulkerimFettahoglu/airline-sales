package com.kerimfettahoglu.airlinesales.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kerimfettahoglu.airlinesales.dto.AddTicketInput;
import com.kerimfettahoglu.airlinesales.entity.Ticket;
import com.kerimfettahoglu.airlinesales.service.impl.TicketServiceImpl;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {
	
	private final TicketServiceImpl ticketService;
	
	public TicketController(TicketServiceImpl ticketService) {
		this.ticketService = ticketService;
	}
	
    @GetMapping()
    @RequestMapping("/get/{id}")
    public ResponseEntity<Ticket> getProject(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(ticketService.get(id));
    }
    
    @PostMapping()
    @RequestMapping("/save")
    public ResponseEntity<Ticket> saveProject(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.save(ticket));
    }
    
    @PostMapping()
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Integer id) {
        boolean result = ticketService.delete(id);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<List<Ticket>> getAll() {
        return ResponseEntity.ok(ticketService.getAll());
    }
    
    @PostMapping()
    @RequestMapping("/sell")
    public ResponseEntity<Ticket> saveProject(@RequestBody AddTicketInput input) {
        return ResponseEntity.ok(ticketService.sellTicket(input));
    }    
}
