package com.example.demo.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Details;
import com.example.demo.model.Movie;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.UserRepository;

@Transactional
@Service
public class BookingService
{
	@Autowired
	BookingRepository br;
	@Autowired
	UserRepository ur;
	@Autowired
	MovieRepository mr;
	
	public String saveBooking(Booking booking)
    {
		Details dtl=ur.getDetailsById(booking.getDetails_id().getId());
		Movie mve=mr.getMovieById(booking.getMovie_id().getId());
		try
		{
			if(dtl!=null && mve!= null)
			{
				booking.setDetails_id(dtl);
			    booking.setMovie_id(mve);
			    booking.setCount(booking.getCount());
			    br.save(booking);
			    return (booking.getId()+". "+mve.getMovie_nm()+" movie booked by "+dtl.getName());
			}
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	    return "Wrong User ID or Movie ID, Please select proper ID";
    }
	
	public List<Booking> allBooking()
	{
		List<Booking> all_Bk=new ArrayList<>();
		br.findAll().forEach(Booking->all_Bk.add(Booking));
		return all_Bk;
	}
	
	public Object getBookingById(int id)
	{
		Booking bk1=br.findById(id);
		if(bk1!=null)
			return bk1;
		else
			return "Wrong ID"; 
	}
	public String cancelBooking(int id)  // need to correct
	{
		int val=br.removeById(id);
		if(val>0)
			return (" Booking canceled");
		
		return (" Wrong Booking Id"); 
			
	}
	
	public void updateWallet(Booking booking)
	{
		Details dtl=booking.getDetails_id();
		double currentBalance=dtl.getWallet();
		double spendMoney=(booking.getMovie_id().getPrice())*booking.getCount();
		double balance=currentBalance-spendMoney;
		dtl.setWallet(balance);
		ur.save(dtl);
	}
}







