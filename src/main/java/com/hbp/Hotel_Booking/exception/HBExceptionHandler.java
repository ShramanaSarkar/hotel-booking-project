package com.hbp.Hotel_Booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hbp.Hotel_Booking.util.ResponseStructure;

@ControllerAdvice
public class HBExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AddressIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleAddressIdNotFoundException(AddressIdNotFoundException e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HotelIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleHotelIdNotFoundException(HotelIdNotFoundException e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RoomIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleRoomIdNotFoundException(RoomIdNotFoundException e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleUserIdNotFoundException(UserIdNotFoundException e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookingIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleBookingIdNotFoundException(BookingIdNotFoundException e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

}
