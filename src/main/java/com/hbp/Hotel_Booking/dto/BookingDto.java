package com.hbp.Hotel_Booking.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {

	private int bookingId;
	private int numberOfGuest;
	private int totalPrice;
	private LocalDateTime checkinTime;
	private LocalDateTime checkoutTime;
}
