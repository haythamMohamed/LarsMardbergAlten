package com.vehicle.tracking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter @Getter
@NoArgsConstructor
public class StatusLog extends BaseEntity<Long>{

	private static final long serialVersionUID = 4015880170706126896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@ManyToOne
	@JoinColumn
	private Vechile vechile ;
	
	@Enumerated( EnumType.STRING )
	private Status status ;
	
	private Date logDate ;
}
