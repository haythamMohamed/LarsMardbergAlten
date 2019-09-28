package com.vehicle.tracking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vehicle.tracking.dto.SearchVechileDTO;
import com.vehicle.tracking.model.Customer;
import com.vehicle.tracking.model.Status;
import com.vehicle.tracking.model.Vechile;
import com.vehicle.tracking.service.VechileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VechileUnitTest {

	@Autowired VechileService vechileService;
	
	@Test
	public void testSearchAllVechilesWithNoFilters () {
		List<Vechile> vechiles = vechileService.searchForVechiles(null);
		assertNotNull(vechiles);
		assertTrue(vechiles.size() > 0);
	}
	
	@Test
	public void testSearchAllVechilesWithCustomerFilter () {
		SearchVechileDTO searchVechileDTO = new SearchVechileDTO();
		searchVechileDTO.setCustomer(new Customer(1));
		
		List<Vechile> vechiles = vechileService.searchForVechiles(searchVechileDTO);
		assertNotNull(vechiles);
		assertTrue(vechiles.size() > 0);
	}
	
	@Test
	public void testSearchAllVechilesWithStatusFilter () {
		SearchVechileDTO searchVechileDTO = new SearchVechileDTO();
		searchVechileDTO.setStatus(Status.CONNECTED);
		
		List<Vechile> vechiles = vechileService.searchForVechiles(searchVechileDTO);
		assertNotNull(vechiles);
	}
}
