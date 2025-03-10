package com.hbp.Hotel_Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hbp.Hotel_Booking.entity.Hotel;
import com.hbp.Hotel_Booking.repository.HotelRepository;

@Repository
public class HotelDao {
	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public Hotel findByHotelId(int hotelId) {
		Optional<Hotel> optional=hotelRepository.findById(hotelId);
        return optional.orElse(null);
    }

	public Hotel updateHotel(int hotelId, Hotel hotel) {
		Optional<Hotel> optional=hotelRepository.findById(hotelId);
		if(optional.isPresent()) {
			hotel.setHotelId(hotelId);
			return hotelRepository.save(hotel);
		}
		return null;
	}

	public Hotel deleteHotel(int hotelId) {
	    Optional<Hotel> optional = hotelRepository.findById(hotelId);
	    if(optional.isPresent()) {
	    	hotelRepository.delete(optional.get());
	    	return optional.get();
	    }
	    return null;
	}
	
	public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

}
