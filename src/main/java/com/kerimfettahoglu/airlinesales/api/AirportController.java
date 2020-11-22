package com.kerimfettahoglu.airlinesales.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kerimfettahoglu.airlinesales.dto.AddAirlineToAirportInput;
import com.kerimfettahoglu.airlinesales.entity.Airport;
import com.kerimfettahoglu.airlinesales.service.impl.AirportServiceImpl;

@RestController
@RequestMapping(value = "/airport")
public class AirportController {
	
	private final AirportServiceImpl airportService;
	
	public AirportController(AirportServiceImpl airportService) {
		this.airportService = airportService;
	}
	
    @GetMapping()
    @RequestMapping("/get/{id}")
    public ResponseEntity<Airport> getProject(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(airportService.get(id));
    }
    
    @PostMapping()
    @RequestMapping("/save")
    public ResponseEntity<Airport> saveProject(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.save(airport));
    }
    
    @PostMapping()
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Integer id) {
        boolean result = airportService.delete(id);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<List<Airport>> getAll() {
        return ResponseEntity.ok(airportService.getAll());
    }
    
    @GetMapping
    @RequestMapping("/getContains/{keyword}")
    public ResponseEntity<List<Airport>> getContains(@PathVariable("keyword") String keyword) {
        return ResponseEntity.ok(airportService.getContains(keyword));
    }
    
    @PostMapping()
    @RequestMapping("/addAirline")
    public ResponseEntity<Boolean> addAirlineToAirport(@RequestBody AddAirlineToAirportInput input) {
    	airportService.addAirlineToAirport(input);
    	return ResponseEntity.ok(true);
    }
}
