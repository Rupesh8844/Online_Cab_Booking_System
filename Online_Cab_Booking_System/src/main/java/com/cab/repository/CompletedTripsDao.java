package com.cab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.model.CompletedTrips;

@Repository
public interface CompletedTripsDao extends JpaRepository<CompletedTrips, Integer>{
	
	 public List<CompletedTrips> findByCustomerId(Integer customerId); 
	
}