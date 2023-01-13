package com.example.demo.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Details;
import com.example.demo.repository.UserRepository;

@Transactional
@Service
public class UserService 
{
	@Autowired
	UserRepository ur;
	@Autowired
	BookingService bs;
 	
	public String saveUser(Details details)
	{
	     try 
	   	 {   
	    	     Details dtl =ur.getDetailsByEmail(details.getEmail());
	    	     details.setWallet(0);
			     if(dtl==null)    // compareing with null because dtl stores one email here, but if this exist in databese it will return user exist.  
			     {	
				        ur.save(details);
				        return ("New User added: "+details.getName());
			     }
			    	 
	   	 }
	   	 catch(Exception e)
	   	 {
	   		  e.printStackTrace();
	   	 }
		return ("User already Exist: "+details.getName());
	}
	
	public void add_Money(Details details)
	{			
			Details dtl2=ur.getDetailsById(details.getId()); // to fetch one users all details via id, where id need to put by user
			double d1=dtl2.getWallet(); // to get value from own model class variable
			double d2=details.getWallet();// to put new value from user for same variable
			double rs=d1+d2;
			dtl2.setWallet(rs);  // to set updated value in same variable
/*			dtl2.setWallet(details.getWallet());   */   // only for adding new value
			ur.save(dtl2);       // mandatory step for saving
			
	}
	
	public List<Details> allUser()  // for all user details show
	{
		List<Details> details=new ArrayList<>();
		ur.findAll().forEach(Details->details.add(Details));
        return details; 
	}
	
	public Object getDetailsById(int id)    
	{
		Details dtl2=ur.findById(id);
		if(dtl2!= null)
			return dtl2;
		else
			return "Wrong Id";             
	}
	
	public void updateUser(Details details)
	{
		
		Details dtl1 =ur.getDetailsById(details.getId()); // to fetch one users all details via id, where id need to get from user
		dtl1.setName(details.getName());   // for replacing old value by new value in same model class (specially used for update) 
		dtl1.setEmail(details.getEmail()); // for replacing old value by new value in same model class (specially used for update)
		ur.save(dtl1); // mandatory step for saving
		
	}
	
	public String deleteUser(String email)
	{
		Long lg=ur.removeByEmail(email);
		if(lg==1)
		{
			return ("User Has been deleted.");
		}
		return "User no Exist";
	}
}
