package com.vehicle.tracking.dto;

import com.vehicle.tracking.model.Customer;
import com.vehicle.tracking.model.Status;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SearchVechileDTO {

	private Customer customer ;
	private Status status ;
}
