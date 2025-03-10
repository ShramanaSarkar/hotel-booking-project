package com.hbp.Hotel_Booking.dto;

//import java.time.LocalDateTime;

import com.hbp.Hotel_Booking.entity.Room;
import com.hbp.Hotel_Booking.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {

	private int bookingId;

	private int numberOfGuest;

	//private int totalPrice;

	//private LocalDateTime checkInTime;

	//private LocalDateTime checkOutTime;
	private Room room;
	private User user;
}
