package com.cab.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.DTO.LoginDTO;
import com.cab.exceptions.CustomerException;
import com.cab.exceptions.DriverException;
import com.cab.exceptions.LoginException;
import com.cab.model.Admin;
import com.cab.model.AdminSession;
import com.cab.model.Customer;
import com.cab.model.CustomerSession;
import com.cab.model.Driver;
import com.cab.model.DriverSession;
import com.cab.repository.AdminDao;
import com.cab.repository.AdminSessionDao;
import com.cab.repository.CustomerDao;
import com.cab.repository.CustomerSessionDao;
import com.cab.repository.DriverDao;
import com.cab.repository.DriverSessionDao;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AdminSessionDao adminSessionDao;

	@Autowired
	private CustomerSessionDao customerSessionDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AdminDao adminDao;

	@Autowired
	DriverSessionDao driverSessionDao;

	@Autowired
	DriverDao driverDao;

	@Override
	public AdminSession loginAdmin(LoginDTO dto) {
		
		Optional<Admin> res = adminDao.findByAdminMobile(dto.getMobile());
		
		if (res.isEmpty()) {
			System.out.println("No Admin exist");
			throw new CustomerException("Admin was not found with mobile number:- "+dto.getMobile());
		}
		
		
		Admin existingAdmin= res.get();
		Optional<AdminSession> opt = adminSessionDao.findByAdminId(existingAdmin.getAdminId());
		
		
		if(opt.isPresent()) {
			throw new LoginException("Admin already logged in...");
		}
		
		if(existingAdmin.getAdmin().getPassword().equals(dto.getPassword())) {
			
			AdminSession newAdminSession=new AdminSession();
			
			
			newAdminSession.setAdminId(existingAdmin.getAdminId());
			newAdminSession.setUserType("Admin");
			newAdminSession.setSessionStartTime(LocalDateTime.now());
			newAdminSession.setSessionEndTime(LocalDateTime.now().plusHours(1));
			
			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];
			
			newAdminSession.setUuid(token);
			
			return adminSessionDao.save(newAdminSession);			
			
		}else {
			throw new LoginException("Password Incorrect. Try again.");
		}
		
	}
	
	
	
	

	@Override
	public CustomerSession loginCustomer(LoginDTO dto) {
		
		Optional<Customer> res= customerDao.findByUserMobile(dto.getMobile());
		
		if(res.isEmpty()) {
			System.out.println("Customer data is empty");
			throw new CustomerException("Customer was not found with mobile number:- "+dto.getMobile());
		}
		
		Customer existingCustomer = res.get();
		Optional<CustomerSession> opt = customerSessionDao.findBycustomerId(existingCustomer.getCustomerId());
		
		
		if(opt.isPresent()) {
			throw new LoginException("Customer already logged in");
		}
		
		
		if(existingCustomer.getUser().getPassword().equals(dto.getPassword())) {
			CustomerSession newCustomerSession = new CustomerSession();
			
			newCustomerSession.setCustomerId(existingCustomer.getCustomerId());
			newCustomerSession.setUserType("Customer");
			newCustomerSession.setSessionStartTime(LocalDateTime.now());
			newCustomerSession.setSessionEndTime(LocalDateTime.now().plusHours(1));
			
			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];
			
			newCustomerSession.setUuid(token);
			
			return customerSessionDao.save(newCustomerSession);
			
		}else {
			throw new LoginException("Password Incorrect. Try again.");
		}
		
		
	}
	
	
	
	
	

	@Override
	public DriverSession loginDriver(LoginDTO dto) {
		
		Optional<Driver> res = driverDao.findByUserMobile(dto.getMobile());
		
		if(res.isEmpty()) {
			System.out.println("Driver data is empty");
			throw new DriverException("Driver was not found with mobile number:-"+dto.getMobile());
		}
		
		
		Driver existingDriver = res.get();
		Optional<DriverSession> opt = driverSessionDao.findByDriverId(existingDriver.getDriverId());
		
		if(opt.isPresent()) {
			throw new LoginException("Driver already logged in");
		}
		
		if(existingDriver.getUser().getPassword().equals(dto.getPassword())) {
			DriverSession newDriverSession = new DriverSession();
			
			newDriverSession.setDriverId(existingDriver.getDriverId());
			newDriverSession.setUserType("Driver");
			newDriverSession.setSessionStartTime(LocalDateTime.now());
			newDriverSession.setSessionEndTime(LocalDateTime.now().plusHours(1));
			
			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];
			
			newDriverSession.setUuid(token);
			
			return driverSessionDao.save(newDriverSession);
			
		}else {
			throw new LoginException("Password Incorrect. Try again.");
		}
		
	}
	
	
}
