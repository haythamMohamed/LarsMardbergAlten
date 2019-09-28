package com.vehicle.tracking.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity<T extends Serializable> implements Serializable{

	private static final long serialVersionUID = 4257598639819636140L;

}