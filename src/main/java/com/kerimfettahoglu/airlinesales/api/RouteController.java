package com.kerimfettahoglu.airlinesales.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kerimfettahoglu.airlinesales.dto.AddRouteInput;
import com.kerimfettahoglu.airlinesales.entity.Route;
import com.kerimfettahoglu.airlinesales.service.impl.RouteServiceImpl;

@RestController
@RequestMapping(value = "/route")
public class RouteController {
	
	private final RouteServiceImpl routeService;
	
	public RouteController(RouteServiceImpl rotaService) {
		this.routeService = rotaService;
	}
	
    @GetMapping()
    @RequestMapping("/get/{id}")
    public ResponseEntity<Route> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(routeService.get(id));
    }
    
    @PostMapping()
    @RequestMapping("/save")
    public ResponseEntity<Route> save(@RequestBody AddRouteInput route) {
        return ResponseEntity.ok(routeService.save(route));
    }
    
    @PostMapping()
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        boolean result = routeService.delete(id);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<List<Route>> getAll() {
        return ResponseEntity.ok(routeService.getAll());
    }

    @GetMapping
    @RequestMapping("/getContains/{keyword}")
    public ResponseEntity<List<Route>> getContains(@PathVariable("keyword") String keyword) {
        return ResponseEntity.ok(routeService.getContains(keyword));
    }
}
