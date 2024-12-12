package com.hbp.Hotel_Booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbp.Hotel_Booking.dto.BookingDto;
import com.hbp.Hotel_Booking.entity.Booking;
import com.hbp.Hotel_Booking.service.BookingService;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@PostMapping("/{roomId}/{userId}")
	public ResponseEntity<ResponseStructure<Booking>> bookRoom(@RequestBody BookingDto bookingDto,@PathVariable int roomId,@PathVariable int userId){
		return bookingService.bookRoom(bookingDto, roomId, userId);
	}
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<ResponseStructure<Booking>> vacateRoom(@PathVariable int bookingId){
		return bookingService.vacateRoom(bookingId);
	}

}
