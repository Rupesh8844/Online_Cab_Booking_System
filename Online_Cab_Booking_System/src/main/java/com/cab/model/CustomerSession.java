package com.cab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerSession {

	@Id
	@SequenceGenerator(name="userSession_generator", sequenceName = "userSession_seq", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSession_generator")
	private Integer sessionId;
	
	@NotNull
	private Integer customerId;
	
	private String uuid;
	
	@NotNull
	private String userType;
	
	private LocalDateTime sessionStartTime;
	
	private LocalDateTime sessionEndTime;
	
}