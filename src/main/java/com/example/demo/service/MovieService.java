package com.example.demo.service;

import java.util.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Transactional
@Service
public class MovieService 
{
    @Autowired	
	MovieRepository mr;
    
    public String saveMovie(Movie movie)
    {
	    try 
	    {
	    	Movie mve=mr.getMovieById(movie.getId());
	    	if(mve==null)
	    	{
	    		mr.save(movie);
	    		return (movie.getMovie_nm()+" is uploded for booking");
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    } 
	    return(movie.getMovie_nm()+" movie is already uploded for booking");
    }
    
    public List<Movie> allMovie()
    {
    	List<Movie> allmve = new ArrayList<>();
    	mr.findAll().forEach(Movie->allmve.add(Movie));
    	return allmve;
    }
    
    public Movie getMovieById(int id)
    {
    	return mr.findById(id).get();
    }
    public void updateMovie(Movie movie)
    {
    	Movie mve1=mr.getMovieById(movie.getId());
    	mve1.setCatagory(movie.getCatagory());
    	mve1.setMovie_nm(movie.getMovie_nm());
    	mve1.setRun_tm(movie.getRun_tm());
    	mve1.setPrice(movie.getPrice());
        mve1.setTm(movie.getTm());
        
    	mr.save(mve1);
    }
 /*   public int deleteMovie(Movie movie)
    {
    	int res=mr.deleteById(movie.getId());;
        return res;    	
    }*/
    public int deleteMovie(int id)// need to correct
    {
    	return mr.removeById(id);
    }
    
}
