package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class Details {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	double wallet;
	String name;	
	String email;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="movie_id",referencedColumnName = "id")
	List<Movie> movie_id;
	
	public int getId() {
		return id;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public List<Movie> getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(List<Movie> movie_id) {
		this.movie_id = movie_id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Details [id=" + id + ", wallet=" + wallet + ", name=" + name + ", email=" + email + ", movie_id="
				+ movie_id + "]";
	}
	

	

}
