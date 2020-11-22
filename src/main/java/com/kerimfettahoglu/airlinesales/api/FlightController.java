package com.kerimfettahoglu.airlinesales.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kerimfettahoglu.airlinesales.dto.AddFlightInput;
import com.kerimfettahoglu.airlinesales.entity.Flight;
import com.kerimfettahoglu.airlinesales.service.impl.FlightServiceImpl;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {
	
	private final FlightServiceImpl flightService;
	
	public FlightController(FlightServiceImpl flightService) {
		this.flightService = flightService;
	}
	
    @GetMapping()
    @RequestMapping("/get/{id}")
    public ResponseEntity<Flight> getProject(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(flightService.get(id));
    }
    
    @PostMapping()
    @RequestMapping("/save")
    public ResponseEntity<Flight> saveProject(@RequestBody AddFlightInput flight) {
        return ResponseEntity.ok(flightService.save(flight));
    }
    
    @PostMapping()
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Integer id) {
        boolean result = flightService.delete(id);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<List<Flight>> getAll() {
        return ResponseEntity.ok(flightService.getAll());
    }
    
    @GetMapping
    @RequestMapping("/getContains/{keyword}")
    public ResponseEntity<List<Flight>> getContains(@PathVariable("keyword") String keyword) {
        return ResponseEntity.ok(flightService.getContains(keyword));
    }
}
