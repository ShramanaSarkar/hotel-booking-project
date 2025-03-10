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

import com.hbp.Hotel_Booking.dto.UserDto;
import com.hbp.Hotel_Booking.entity.User;
import com.hbp.Hotel_Booking.service.UserService;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody UserDto userDto,@PathVariable int addressId){
		return userService.saveUser(userDto, addressId);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<ResponseStructure<User>> findByUserId(@PathVariable int userId){
		return userService.findByUserId(userId);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody UserDto userDto,@PathVariable int userId){
		return userService.updateUser(userDto, userId);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable int userId){
		return userService.deleteUser(userId);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<User>>> findAll(){
		return userService.findAll();
	}

}
