package com.vehicle.tracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.tracking.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
