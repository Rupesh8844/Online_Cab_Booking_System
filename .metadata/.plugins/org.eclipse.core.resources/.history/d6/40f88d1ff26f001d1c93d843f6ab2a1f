package com.cab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.model.Admin;
import com.cab.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Optional<Admin> findByUsername(String username) ;
	
	Optional<Customer> findByUserMobile(String mobile);
}
