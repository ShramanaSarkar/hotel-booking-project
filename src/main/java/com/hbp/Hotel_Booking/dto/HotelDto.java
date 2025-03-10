package com.hbp.Hotel_Booking.dto;

import com.hbp.Hotel_Booking.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDto {

	private int hotelId;

	private String hotelName;

	private int rating;

	private Address address;
}
