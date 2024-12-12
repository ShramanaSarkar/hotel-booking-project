package com.hbp.Hotel_Booking.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hbp.Hotel_Booking.dao.AddressDao;
import com.hbp.Hotel_Booking.dao.HotelDao;
import com.hbp.Hotel_Booking.dto.HotelDto;
import com.hbp.Hotel_Booking.entity.Address;
import com.hbp.Hotel_Booking.entity.Hotel;
import com.hbp.Hotel_Booking.exception.HotelIdNotFoundException;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@Service
public class HotelService {
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(HotelDto hotelDto, int addressId){
		
		Address dbaddress=addressDao.findByAddressId(addressId);
		
		Hotel hotel=modelMapper.map(hotelDto, Hotel.class);
		
		hotel.setAddress(dbaddress);
		hotelDao.saveHotel(hotel);
		
		ResponseStructure<Hotel> responseStructure=new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Hotel Saved");
		responseStructure.setData(hotel);
		return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> findByHotelId(int hotelId){
		Hotel dbHotel=hotelDao.findByHotelId(hotelId);
		ResponseStructure<Hotel> responseStructure=new ResponseStructure<>();
		if(dbHotel!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Hotel Found");
			responseStructure.setData(dbHotel);
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
		}else {
			throw new HotelIdNotFoundException("Hotel id not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(HotelDto hotelDto, int hotelId){
		Hotel hotel=modelMapper.map(hotelDto, Hotel.class);
		hotelDao.updateHotel(hotelId, hotel);
		ResponseStructure<Hotel> responseStructure=new ResponseStructure<Hotel>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Hotel Updated");
		responseStructure.setData(hotel);
		return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(int hotelId){
		Hotel dbHotel=hotelDao.deleteHotel(hotelId);
		ResponseStructure<Hotel> responseStructure=new ResponseStructure<>();
		if(dbHotel!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Address Deleted");
			responseStructure.setData(dbHotel);
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
		}else {
			throw new HotelIdNotFoundException("Hotel not found");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Hotel>>> findAll(){
		List<Hotel> hotelList=hotelDao.findAll();
		ResponseStructure<List<Hotel>> responseStructure=new ResponseStructure<>();
		if(hotelList!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Hotel Found");
			responseStructure.setData(hotelList);
			return new ResponseEntity<ResponseStructure<List<Hotel>>>(responseStructure,HttpStatus.OK);
		}else {
			throw new HotelIdNotFoundException("Hotel not found");
		}
	}

}
