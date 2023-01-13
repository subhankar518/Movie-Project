package com.example.demo.repository;            

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	Movie getMovieById(int id);
    int removeById(int id);
	

}
