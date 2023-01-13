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
@Table(name="Transaction_table")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	int tickets;
	double amount;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="booking_id",referencedColumnName = "id")
	Booking booking_id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Booking getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Booking booking_id) {
		this.booking_id = booking_id;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", tickets=" + tickets + ", amount=" + amount + ", booking_id=" + booking_id
				+ "]";
	}
	
	

}
