package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_list")

public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String movie_nm;
	char catagory;
	String run_tm;
	double price;
	String tm;
	
	public String getTm() {
		return tm;
	}
	public void setTm(String tm) {
		this.tm = tm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovie_nm() {
		return movie_nm;
	}
	public void setMovie_nm(String movie_nm) {
		this.movie_nm = movie_nm;
	}
	public char getCatagory() {
		return catagory;
	}
	public void setCatagory(char catagory) {
		this.catagory = catagory;
	}
	public String getRun_tm() {
		return run_tm;
	}
	public void setRun_tm(String run_tm) {
		this.run_tm = run_tm;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movie_nm=" + movie_nm + ", catagory=" + catagory + ", run_tm=" + run_tm
				+ ", price=" + price + ", tm=" + tm + "]";
	}
	
	
	
	
	

}
