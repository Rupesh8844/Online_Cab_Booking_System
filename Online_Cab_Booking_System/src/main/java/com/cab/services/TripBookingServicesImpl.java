package com.cab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.model.TripBooking;
import com.cab.repository.TripBookingDao;


@Service
public class TripBookingServicesImpl implements TripBookingServices{

	@Autowired
	private TripBookingDao tripDao;

	@Override
	public TripBooking newTrip(TripBooking trip) {
		return tripDao.save(trip);
		
	}
	
}
