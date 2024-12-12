package com.hbp.Hotel_Booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbp.Hotel_Booking.dto.HotelDto;
import com.hbp.Hotel_Booking.entity.Hotel;
import com.hbp.Hotel_Booking.service.HotelService;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	@PostMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(@RequestBody HotelDto hotelDto,@PathVariable int addressId){
		return hotelService.saveHotel(hotelDto, addressId);
	}
	@GetMapping("/{hotelId}")
	public ResponseEntity<ResponseStructure<Hotel>> findByHotelId(@PathVariable int hotelId){
		return hotelService.findByHotelId(hotelId);
	}
	@PutMapping("/{hotelId}")
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(@RequestBody HotelDto hotelDto,@PathVariable int hoteId){
		return hotelService.updateHotel(hotelDto, hoteId);
	}
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(int hotelId){
		return hotelService.deleteHotel(hotelId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Hotel>>> findAll(){
		return hotelService.findAll();
	}

}
