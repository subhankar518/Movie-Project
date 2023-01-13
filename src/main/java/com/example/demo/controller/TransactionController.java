package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService ts;
	
	@GetMapping("/all-transaction")
    private ResponseEntity<?> transaction_list()
    {
    	try
    	{
    		List<Transaction> transaction=ts.allTransaction();
    		return new ResponseEntity<Object>(transaction,HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	

}
