package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
		int removeById(int id);
		Booking getBookingById(int id);
		Booking findById(int id);
}
