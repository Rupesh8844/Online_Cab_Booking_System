package com.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.model.Cab;

@Repository
public interface CabDao extends JpaRepository<Cab, Integer> {

}
