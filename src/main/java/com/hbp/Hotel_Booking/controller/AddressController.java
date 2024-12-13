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

import com.hbp.Hotel_Booking.dto.AddressDto;
import com.hbp.Hotel_Booking.entity.Address;
import com.hbp.Hotel_Booking.service.AddressService;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody AddressDto addressDto){
		return addressService.saveAddress(addressDto);
	}
	@GetMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> findByAddressId(@PathVariable int addressId){
		return addressService.findByAddressId(addressId);
	}
	
	@PutMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int addressId,@RequestBody AddressDto addressDto){
		return addressService.updateAddress(addressId, addressDto);
	}
	
	@DeleteMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@PathVariable int addressId){
		return addressService.deleteAddress(addressId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Address>>> fetchAllAddress(){
		return addressService.fetchAllAddress();
	}

}
