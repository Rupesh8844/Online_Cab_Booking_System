package com.cab.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cab.DTO.LoginDTO;
import com.cab.model.AdminSession;
import com.cab.model.CustomerSession;
import com.cab.model.DriverSession;
import com.cab.repository.AdminDao;
import com.cab.repository.AdminSessionDao;
import com.cab.repository.CustomerDao;
import com.cab.repository.CustomerSessionDao;
import com.cab.repository.DriverDao;
import com.cab.repository.DriverSessionDao;

public class LoginServiceImpl implements LoginService{

	@Autowired
	private AdminSessionDao adminSession;

	@Autowired
	private CustomerSessionDao sessionDao;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerSession loginCustomer(LoginDTO customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverSession loginDriver(LoginDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
