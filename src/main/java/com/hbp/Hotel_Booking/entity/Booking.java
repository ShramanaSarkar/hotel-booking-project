package com.hbp.Hotel_Booking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private int numberOfGuest;
	private int totalPrice;
	private LocalDateTime checkinTime;
	private LocalDateTime checkoutTime;
	@ManyToOne
	private Room room;
	@ManyToOne
	private User user;

}
