package com.kerimfettahoglu.airlinesales.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kerimfettahoglu.airlinesales.entity.Airline;
import com.kerimfettahoglu.airlinesales.service.impl.AirlineServiceImpl;

@RestController
@RequestMapping(value = "/airline")
public class AirlineController {
	
	private final AirlineServiceImpl airlineService;
	
	public AirlineController(AirlineServiceImpl airlineService) {
		this.airlineService = airlineService;
	}
	
    @GetMapping()
    @RequestMapping("/get/{id}")
    public ResponseEntity<Airline> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(airlineService.get(id));
    }
    
    @PostMapping()
    @RequestMapping("/save")
    public ResponseEntity<Airline> save(@RequestBody Airline airline) {
        return ResponseEntity.ok(airlineService.save(airline));
    }
    
    @PostMapping()
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        boolean result = airlineService.delete(id);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<List<Airline>> getAll() {
        return ResponseEntity.ok(airlineService.getAll());
    }
    
    @GetMapping
    @RequestMapping("/getContains/{keyword}")
    public ResponseEntity<List<Airline>> getContains(@PathVariable("keyword") String keyword) {
        return ResponseEntity.ok(airlineService.getContains(keyword));
    }
    
}
