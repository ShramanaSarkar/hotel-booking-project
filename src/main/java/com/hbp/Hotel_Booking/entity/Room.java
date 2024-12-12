package com.hbp.Hotel_Booking.entity;

import com.hbp.Hotel_Booking.enumdata.RoomType;

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
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	private int roomNumber;
	private int price;
	private boolean available;
	private RoomType type;
	@ManyToOne
	private Hotel hotel;
	
}
