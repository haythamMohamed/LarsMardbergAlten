package com.vehicle.tracking.model;

import javax.persistence.Column;
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
@Table(name = "vechile")
@Setter @Getter
@NoArgsConstructor
public class Vechile extends BaseEntity<Integer> {

	private static final long serialVersionUID = 572957499805596723L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@ManyToOne
	@JoinColumn
	private Customer customer ;
	
	@Column(name = "VIN")
	private String vechileId ;
	
	@Column(name = "regNo")
	private String registerationNumber ;
	
	@Enumerated(EnumType.STRING)
	private Status lastStatus ;
}
