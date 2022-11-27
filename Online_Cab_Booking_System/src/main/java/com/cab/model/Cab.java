package com.cab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Cab {

	@Id
	@SequenceGenerator(name="cab_generator", sequenceName = "cab_seq", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cab_generator")
	private Integer Id;
	
	private Double perKmRate;
	
	@NotNull
	private CabType cabType;
	
	private String available;
	
}
