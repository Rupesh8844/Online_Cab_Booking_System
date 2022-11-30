package com.cab.services;

import java.util.List;

import com.cab.DTO.CustomerDTO;
import com.cab.exceptions.CustomerException;
import com.cab.exceptions.TripException;
import com.cab.model.CompletedTrips;
import com.cab.model.Customer;
import com.cab.model.Driver;
import com.cab.model.TripBooking;

public interface CustomerService {

public Customer register(Customer user) ;
	
	public List<Customer> getCustomer();
    
	public Customer updatePassword(CustomerDTO dto, String key) ; 
	
	public String deleteCustomer(CustomerDTO dto, String key) ;
	
	public Customer updateCustomer(Customer customer,String mobile, String key) ;
	
	public List<Driver> getAvailableDrivers();
	
	public List<Driver> generalListOfDrivers();
	
	public TripBooking bookTrip(TripBooking trip, String key  );  
	
	public String cancelTrip(String key, Integer tripId) ;
	
	public String logoutCustomer(String key);
	
	public String completeTrip(String key, Integer tripId);
	
	public List<CompletedTrips> alltripHistory(String key);
	
	public TripBooking updateTrip(TripBooking trip, String key);
	
}
