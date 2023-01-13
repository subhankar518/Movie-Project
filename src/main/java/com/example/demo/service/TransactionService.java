package com.example.demo.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	
	@Autowired
	TransactionRepository tr;
	
	public void createTransaction(Booking booking)
	{
		Transaction ts=new Transaction();
		ts.setBooking_id(booking);
		ts.setAmount((booking.getMovie_id().getPrice())*booking.getCount());
		ts.setTickets(booking.getCount());
		tr.save(ts);		
	}
	
	public List<Transaction> allTransaction()
	{
		List<Transaction> transaction=new ArrayList<>();
		tr.findAll().forEach(Transaction->transaction.add(Transaction));
		return transaction;
	}

}
