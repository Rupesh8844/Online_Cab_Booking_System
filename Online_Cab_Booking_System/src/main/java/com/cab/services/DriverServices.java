package com.cab.services;

import java.util.List;

import com.cab.model.Driver;

public interface DriverServices {

	public Driver registerDriver(Driver driver);
	
	public List<Driver> getAllDriver(String key);
	
	public Driver updateDriver(Driver driver,String key);
	
	public String updateStatus(String newStatus, String key);
	
	public List<Driver> viewBestDriver(String key,float rating);
	
	public String deleteDriver(String name,String key);
	
	public String logoutDriver(String key);
	
}
