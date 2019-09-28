package com.vehicle.tracking;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.tracking.dto.SearchVechileDTO;
import com.vehicle.tracking.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegerationTest {

	private static final ObjectMapper OBJECT_MAPPER  = new ObjectMapper();
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void successGetAllCustomers () throws JsonProcessingException, Exception {
		mockMvc.perform(get("/customer")).andExpect(status().isOk());
	}
	
	@Test
	public void successGetAllVechiles () throws JsonProcessingException, Exception {
		mockMvc.perform(post("/search-vechiles").content("{}").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void successGetAllVechilesByCustomer () throws JsonProcessingException, Exception {
		SearchVechileDTO searchVechileDTO = new SearchVechileDTO();
		searchVechileDTO.setCustomer(new Customer(1));
		
		mockMvc.perform(post("/search-vechiles").content(OBJECT_MAPPER.writeValueAsString(searchVechileDTO)).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
