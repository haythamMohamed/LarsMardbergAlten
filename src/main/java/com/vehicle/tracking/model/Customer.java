package com.vehicle.tracking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Setter @Getter
@NoArgsConstructor
public class Customer extends BaseEntity<Integer>{

	private static final long serialVersionUID = -8031558308672395358L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String name ;
	private String address ;
	
	public Customer(Integer id) {
		this.id = id ;
	}
}
