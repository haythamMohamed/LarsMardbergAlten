package com.vehicle.tracking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vehicle.tracking.model.Customer;
import com.vehicle.tracking.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerUnitTest {

	@Autowired CustomerService customerService;
	
	@Test
	public void testGetAllCustomers () {
		List<Customer> customers = customerService.getCustomers();
		assertNotNull(customers);
		assertTrue(customers.size()> 0);
	}
	

}
