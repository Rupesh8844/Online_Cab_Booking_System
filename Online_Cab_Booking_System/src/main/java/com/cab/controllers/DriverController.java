package com.cab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.DTO.LoginDTO;
import com.cab.model.Driver;
import com.cab.model.DriverSession;
import com.cab.services.DriverServices;
import com.cab.services.LoginService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverServices driverService;
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/register")
	public Driver driverRegisterHandler(@RequestBody Driver driver) {
		
		return driverService.registerDriver(driver);
		
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<DriverSession> driverLoginHandler(@RequestBody LoginDTO dto) {
	
		DriverSession driver = loginService.loginDriver(dto);
		
		return new ResponseEntity<DriverSession>(driver, HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@GetMapping("/getAllDrivers")
	public List<Driver> getAllDriversHanlder(@RequestParam String key){
		
		return driverService.getAllDriver(key);
		
	}
	
	
	
	
	@DeleteMapping("/delete/{username}")
	public  String deleteDriverHandler(@PathVariable("username") String username,@RequestParam String key) {
		
		return driverService.deleteDriver(username, key);
		
	}
	
	
	
	
	@PutMapping("/update")
	public Driver updateDriverHandler(@RequestBody Driver driver,@RequestParam String key) {
		
		return driverService.updateDriver(driver, key);
				
	}
	
	
	
	
	@PatchMapping("/updateStatus/{status}")
	public String updateStatusHandler(@RequestParam String key, @PathVariable("status") String newStatus) {
		
		return driverService.updateStatus(newStatus, key);
		
	}
	
	
	
	
	@GetMapping("/logout")
	public String logoutDriverHandler(@RequestParam String key) {

		return driverService.logoutDriver(key);

	}
	
	
	
	@GetMapping("/driverByRating")
	public List<Driver> driverByRatingHandler(@RequestParam String key,@RequestParam  float rating){
		
		return driverService.viewBestDriver(key, rating);
	}
	
	
	
	
}
