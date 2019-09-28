package com.vehicle.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.tracking.dto.SearchVechileDTO;
import com.vehicle.tracking.model.Customer;
import com.vehicle.tracking.model.Vechile;
import com.vehicle.tracking.service.CustomerService;
import com.vehicle.tracking.service.VechileService;

@CrossOrigin
@RestController
public class WebController {

	@Autowired CustomerService customerService;
	@Autowired VechileService vechileService;
	
	@GetMapping("/customer")
	public List<Customer> getCustomers (){
		return customerService.getCustomers();
	}
	
	@PostMapping("/search-vechiles")
	public List<Vechile> searchForVechiles (@RequestBody SearchVechileDTO searchVechileDTO){
		return vechileService.searchForVechiles(searchVechileDTO);
	}
}
