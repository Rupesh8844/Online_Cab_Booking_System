package com.cab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.model.Driver;

@Repository
public interface DriverDao extends JpaRepository<Driver, Integer>{

		public Optional<Driver> findByUserUsername(String name);
		
		public Optional<Driver>findByUserMobile(String mobile);
		
		public List<Driver> findByCabAvailable(String bool);
		
//		@Query("select * from Driver b  where b.rating>4.5")
		public List<Driver> findByRatingGreaterThan(float r);
		
		
}