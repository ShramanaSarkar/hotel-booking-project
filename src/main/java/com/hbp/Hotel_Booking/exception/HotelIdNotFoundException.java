package com.hbp.Hotel_Booking.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HotelIdNotFoundException extends RuntimeException{

	private String message;
}
