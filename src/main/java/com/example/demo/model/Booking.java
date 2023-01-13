package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking_table")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="movie_id",referencedColumnName = "id")
	Movie movie_id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="details_id",referencedColumnName = "id")
	Details details_id;
	int count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie getMovie_id() {
		return movie_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setMovie_id(Movie movie_id) {
		this.movie_id = movie_id;
	}
	public Details getDetails_id() {
		return details_id;
	}
	public void setDetails_id(Details details_id) {
		this.details_id = details_id;
	}
	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", movie_id=" + movie_id + ", details_id=" + details_id + ", count=" + count + "]";
	}
		
}
