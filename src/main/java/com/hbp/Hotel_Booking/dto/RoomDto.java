package com.hbp.Hotel_Booking.dto;

import com.hbp.Hotel_Booking.entity.Hotel;
import com.hbp.Hotel_Booking.enumdata.RoomType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {

	private int roomId;

	private int roomNumber;

	private int price;

	private boolean available;

	private RoomType type;

	private Hotel hotel;
}
