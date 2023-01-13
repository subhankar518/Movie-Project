package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import com.example.demo.service.TransactionService;

@RestController
public class BookingController
{
        @Autowired
        BookingService bs;
        @Autowired
        TransactionService ts;
          
        @PostMapping("/add-booking")
  		private ResponseEntity<Object> booking_mve(@RequestBody Booking booking)
  		{
  			try 
  			{
  				String str=bs.saveBooking(booking);
  				bs.updateWallet(booking);
  				ts.createTransaction(booking);
  				return new ResponseEntity<Object>(str,HttpStatus.CREATED);
  			}
  			catch(Exception e)
  			{
  				return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
  			}			
  		}
          
        @GetMapping("/all-Booking")
        private ResponseEntity<Object> booking_list()
        {
        	try
        	{
        		List<Booking> bkl=bs.allBooking();
        		return new ResponseEntity<Object>(bkl,HttpStatus.OK);
        	}
        	catch(Exception e)
        	{
        		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        }
        
        @GetMapping("/booking-search-by/{id}")
        private ResponseEntity<Object> searchBooking(@PathVariable("id")int id)// need to correct
        {
        	try
        	{
        		return new ResponseEntity<Object>(bs.getBookingById(id),HttpStatus.OK);
        	}
        	catch(Exception e)
        	{
        		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        }
        
        @DeleteMapping("/cancel-Booking/{id}")
        private ResponseEntity<Object> cncl_Booking(@PathVariable("id")int id) // need to correct
        {
        	String val;
        	try
        	{
        		val=bs.cancelBooking(id);
        	}
        	catch(Exception e)
        	{
        		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        	return new ResponseEntity<Object>(val,HttpStatus.OK);
        }
               
}
