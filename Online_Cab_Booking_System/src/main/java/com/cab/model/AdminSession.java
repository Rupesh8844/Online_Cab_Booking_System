package com.cab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdminSession {

	@Id
	@SequenceGenerator(name="adminSession_generator", sequenceName = "adminSession_seq", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminSession_generator")
	private Integer sessionId;
	
	private Integer adminId;
	
	private String uuid;
	
	private String userType;
	
	private LocalDateTime sessionStartTime;
	
	private LocalDateTime sessionEndTime;
	
	
	
	
}
