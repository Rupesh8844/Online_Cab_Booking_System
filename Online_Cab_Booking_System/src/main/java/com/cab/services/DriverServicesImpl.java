package com.cab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.exceptions.DriverException;
import com.cab.exceptions.LoginException;
import com.cab.model.Driver;
import com.cab.model.DriverSession;
import com.cab.repository.DriverDao;
import com.cab.repository.DriverSessionDao;

@Service
public class DriverServicesImpl implements DriverServices{

	@Autowired
	private DriverDao driverDao;
	
	@Autowired
	private DriverSessionDao driverSessionDao;

	@Override
	public Driver registerDriver(Driver driver) {
    
		Optional<Driver> res = driverDao.findByUserMobile(driver.getUser().getMobile());
       
		if(res.isEmpty()) {
			System.out.println("Driver already exist with this mobile Number");

			throw new DriverException("Driver already exist with this mobile Number");
		}
		
		driver.getCab().setPerKmRate(driver.getCab().getCabType().getPrice());
		
		Driver newDriver = driverDao.save(driver);
		
		return newDriver;
		
	}
	
	
	
	

	@Override
	public List<Driver> getAllDriver(String key) {
		
		Optional<DriverSession> res = driverSessionDao.findByUuid(key);
		
		if(res.isEmpty()) {
			System.out.println("driver is not loged  in");

			throw new LoginException("Driver is not loged in ,Please log in first");
		}
		
		List<Driver> list= driverDao.findAll();
		
		if(list.isEmpty()) {
			System.out.println("Ther  is No driver in the list");
			
			throw new DriverException("List is empty...");
		}
		
		
		return list;
	}
	
	
	
	@Override
	public Driver updateDriver(Driver driver, String key) {
		
		Optional<DriverSession> res = driverSessionDao.findByUuid(key);
		
		if(res.isEmpty()) {
			throw new LoginException("Driver is not loged in ,Please log in first");
		}
		
		return driverDao.save(driver);
	}
	
	
	
	

	@Override
	public String updateStatus(String newStatus, String key) {


		String status = null;
		String msg = null;
		Optional<DriverSession> res = driverSessionDao.findByUuid(key);

		if (res.isEmpty()) {
			throw new LoginException("Driver is not loged in ,Please log in first");
		}

		if (newStatus.equalsIgnoreCase("Y")) {
			status = "YES";
			msg = "Your Status is Changed to Online.";
		} else if (newStatus.equalsIgnoreCase("N")) {
			status = "NO";
			msg = "Your Status is Changed to Offline.";

		} else {
			throw new DriverException("Please select 'Y' or 'N' only.");
		}

		DriverSession driverSession = res.get();
		Integer driverId = driverSession.getDriverId();
		Optional<Driver> existingDriverOpt = driverDao.findById(driverId);
		Driver existingDriver = existingDriverOpt.get();
		existingDriver.getCab().setAvailable(status);
		driverDao.save(existingDriver);

		return msg;
		
	}
	
	
	
	

	@Override
	public List<Driver> viewBestDriver(String key, float rating) {
		
		Optional<DriverSession> res = driverSessionDao.findByUuid(key);
		
		if(res.isEmpty()) {
			System.out.println("driver is not loged  in");

			throw new LoginException("Driver is not loged in ,Please log in first");
		}
		
		return driverDao.findByRatingGreaterThan(rating);
		
	}

	
	
	@Override
	public String deleteDriver(String name, String key) {
		
		Optional<DriverSession> res = driverSessionDao.findByUuid(key);
		
		if (res.isEmpty()) {
			
			System.out.println("No driver is present...");
			
			throw new LoginException("Driver is not loged in ,Please log in first");
		}
		
		Optional<Driver> opt = driverDao.findByUserUsername(name);
		
		if(opt== null) {
			
				System.out.println("No driver present with the name: "+ name);
				
				throw new DriverException("No driver present with the name: "+ name);	
		}
		
		driverDao.delete(opt.get());
		
		return "Driver name :" + name + "deleted from the database...";
	}

	
	
	
	@Override
	public String logoutDriver(String key) {

		Optional<DriverSession> res =driverSessionDao.findByUuid(key);
		
		if (res.isEmpty()) {
			throw new LoginException("Driver is not loged in ,Please log in first");
		}else {
			driverSessionDao.delete(res.get());
		}

		return "Driver has succefully logged out.";
	}
	
	
}
