package com.hbp.Hotel_Booking.dto;

import com.hbp.Hotel_Booking.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private int userId;

	private String name;

	private String email;

	private String phoneNumber;

	private Address address;
}
