package com.cab.services;

import java.util.List;

import com.cab.DTO.AdminDTO;
import com.cab.exceptions.AdminException;
import com.cab.exceptions.LoginException;
import com.cab.model.Admin;
import com.cab.model.CompletedTrips;
import com.cab.model.Customer;
import com.cab.model.Driver;

public interface AdminService {

	public Admin adminRegister(Admin admin) ;

	public Admin updatePassword(AdminDTO dto, String username, String key);

	public Admin update(Admin admin, String Username, String key);

	public String deleteByUsername(AdminDTO dto, String key);

	public String logoutAdmin(String key) ;
	
	public List<CompletedTrips> getTripsByCustomerId(Integer customerId, String key);
	
	public List<CompletedTrips> getAllTrips(String key);
	
	public List<Driver> getListOfDrivers(String key);
	
	public List<Customer> getListOfCustomers(String key);
	
}
