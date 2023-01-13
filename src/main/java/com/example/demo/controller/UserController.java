package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Details;
import com.example.demo.service.UserService;


@RestController
public class UserController 
{
	 @Autowired
     UserService us;
	 

     @PostMapping("/add-user")
     private ResponseEntity<Object> createUser(@RequestBody Details details)
     {
	     try 
	   	 {   
			    String val=	us.saveUser(details);
			    return new ResponseEntity<Object>(val, HttpStatus.CREATED);
			     
	   	 }
	   	 catch(Exception e)
	   	 {
	   		 return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	     }
     }
     
     @GetMapping("/all-users")
     private List<Details> getAllUsers() 
     {
			  return us.allUser();   
     }
     
     @GetMapping("/find-user-by/{id}")
     private ResponseEntity<Object> find_User(@PathVariable("id")int id)
     {
    	 try
    	 {
    		 return new ResponseEntity<Object>(us.getDetailsById(id),HttpStatus.OK);
    	 }
    	 catch(Exception e)
    	 {
    		 return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
     } 
     
     @PutMapping("/update-user")
     private ResponseEntity<?> updateUserCon(@RequestBody Details details)
     {
	     try 
	   	 {   
			    us.updateUser(details);			     
	   	 }
	   	 catch(Exception e)
	   	 {
	   		 return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	     return new ResponseEntity<Object>(details.getName()+" is updated", HttpStatus.OK);
     }
     
         @DeleteMapping("/delete-user/{email}")
	     private ResponseEntity<Object> delete_User(@PathVariable("email")String email)
	     {
        	 String status;
	    	 try 
	    	 {
	    		 status=us.deleteUser(email);
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	    	 }
	    	 return new ResponseEntity<Object>(status,HttpStatus.OK);
	     }
       /*@DeleteMapping("/delete-user/{email}")
	     private void delete_User(@PathVariable("email")String email)
	     {
	    	 us.deleteUser(email);
	     }*/
         @PutMapping("/add-money")
         private ResponseEntity<?> addMoney(@RequestBody Details details)
         {
        	 try
        	 {
        		 us.add_Money(details);
        		 return new ResponseEntity<Object>("Balance Updated",HttpStatus.OK);
        	 }
        	 catch(Exception e)
        	 {
        		 return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        	 }
        	 
         }
}
