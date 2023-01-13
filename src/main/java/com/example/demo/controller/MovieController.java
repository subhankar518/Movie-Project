package com.example.demo.controller;

import java.util.*;

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

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController 
{
	
		@Autowired
		MovieService ms;
		
		@PostMapping("/add-movie")
		private ResponseEntity<Object> add_movie(@RequestBody Movie movie)
		{
			try 
			{
				ms.saveMovie(movie);
				return new ResponseEntity<Object>(movie.getMovie_nm()+" movie added",HttpStatus.CREATED);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}			
		}
		
		@GetMapping("/all-movie")
		private ResponseEntity<Object> all_movie()
		{
			try
			{
				List<Movie> val=ms.allMovie();
				return new ResponseEntity<Object>(val,HttpStatus.OK);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}			
		}
		
		@GetMapping("/search-movie-by/{id}")
		private ResponseEntity<Object> search_movie(@PathVariable("id")int id)
		{
			try
			{
				return new ResponseEntity<Object>(ms.getMovieById(id),HttpStatus.OK);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/update-movie")
		private ResponseEntity<Object> update_Movie(@RequestBody Movie movie)
		{
			try
			{
				ms.updateMovie(movie);
				return new ResponseEntity<Object>(movie.getMovie_nm()+" status is updated",HttpStatus.OK);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/delete-movie/{id}")
		private ResponseEntity<?> delete_Movie(@PathVariable("id")int id)
		{
			return new ResponseEntity<Object>(ms.deleteMovie(id),HttpStatus.OK);
		}
		
}
