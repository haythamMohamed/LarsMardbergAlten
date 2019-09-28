package com.vehicle.tracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.tracking.dao.CustomerDAO;
import com.vehicle.tracking.model.Customer;

@Service
@Transactional
public class CustomerService {

	@Autowired CustomerDAO customerDAO;
	
	public List<Customer> getCustomers (){
		return customerDAO.findAll();
	}
}
