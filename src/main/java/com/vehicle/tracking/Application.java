package com.vehicle.tracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.vehicle.tracking.dao.CustomerDAO;
import com.vehicle.tracking.dao.VechileDAO;
import com.vehicle.tracking.model.Customer;
import com.vehicle.tracking.model.Vechile;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {
		
		@Autowired CustomerDAO customerDAO ;
		@Autowired VechileDAO vechileDAO ;
		
		@Override
		public void run(String... args) throws Exception {
		
			Customer customer = new Customer();
			customer.setName("Kalles Grustransporter AB");
			customer.setAddress("Cementvägen 8, 111 11 Södertälje");
			customerDAO.save(customer);

			Vechile vechile = new Vechile();
			vechile.setCustomer(customer);
			vechile.setRegisterationNumber("ABC123");
			vechile.setVechileId("YS2R4X20005399401");
			vechileDAO.save(vechile);
			
			vechile = new Vechile();
			vechile.setCustomer(customer);
			vechile.setRegisterationNumber("DEF456");
			vechile.setVechileId("VLUR4X20009093588");
			vechileDAO.save(vechile);
			
			vechile = new Vechile();
			vechile.setCustomer(customer);
			vechile.setRegisterationNumber("GHI789");
			vechile.setVechileId("VLUR4X20009048066");
			vechileDAO.save(vechile);
			
			customer = new Customer();
			customer.setName("Johans Bulk AB");
			customer.setAddress("Balkvägen 12, 222 22 Stockholm");
			customerDAO.save(customer);
			
			vechile = new Vechile();
			vechile.setCustomer(customer);
			vechile.setRegisterationNumber("JKL012");
			vechile.setVechileId("YS2R4X20005388011");
			vechileDAO.save(vechile);
			
			vechile = new Vechile();
			vechile.setCustomer(customer);
			vechile.setRegisterationNumber("MNO345");
			vechile.setVechileId("YS2R4X20005387949");
			vechileDAO.save(vechile);
			
			customer = new Customer();
			customer.setName("Haralds Värdetransporter AB");
			customer.setAddress("Budgetvägen 1, 333 33 Uppsala");
			customerDAO.save(customer);
			
			vechile = new Vechile();
			vechile.setCustomer(customer);
			vechile.setRegisterationNumber("PQR678");
			vechile.setVechileId("YS2R4X20005387765");
			vechileDAO.save(vechile);
			
			vechile = new Vechile();
			vechile.setCustomer(customer);
			vechile.setRegisterationNumber("STU901");
			vechile.setVechileId("YS2R4X20005387055");
			vechileDAO.save(vechile);
			
		}
	}
}
