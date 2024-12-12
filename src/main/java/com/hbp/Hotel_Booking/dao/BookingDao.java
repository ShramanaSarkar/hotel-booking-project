package com.hbp.Hotel_Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hbp.Hotel_Booking.entity.Booking;
import com.hbp.Hotel_Booking.repository.BookingRepository;

@Repository
public class BookingDao {
	@Autowired
	private BookingRepository bookingRepository;
	
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	public Booking findbyBookingId(int bookingId) {
		Optional<Booking> optional=bookingRepository.findById(bookingId);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	public Booking updateBooking(int bookingId, Booking booking) {
		Optional<Booking> optional=bookingRepository.findById(bookingId);
		if(optional.isPresent()) {
			booking.setBookingId(bookingId);
			return bookingRepository.save(booking);
		}
		return null;
	}
	public Booking deleteBooking(int bookingId) {
	    Optional<Booking> optional = bookingRepository.findById(bookingId);
	    if(optional.isPresent()) {
	    	bookingRepository.delete(optional.get());
	    	return optional.get();
	    }
	    return null;
	}
	
	public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

}
