package com.hbp.Hotel_Booking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

	private int addressId;
	private int number;
	private String area;
	private String city;
	private String state;
	private long pincode;
}
