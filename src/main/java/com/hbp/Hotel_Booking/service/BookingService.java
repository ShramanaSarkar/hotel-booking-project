package com.hbp.Hotel_Booking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hbp.Hotel_Booking.dao.BookingDao;
import com.hbp.Hotel_Booking.dao.RoomDao;
import com.hbp.Hotel_Booking.dao.UserDao;
import com.hbp.Hotel_Booking.dto.BookingDto;
import com.hbp.Hotel_Booking.entity.Booking;
import com.hbp.Hotel_Booking.entity.Room;
import com.hbp.Hotel_Booking.entity.User;
import com.hbp.Hotel_Booking.enumdata.RoomType;
import com.hbp.Hotel_Booking.exception.BookingIdNotFoundException;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@Service
public class BookingService {
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructure<Booking>> bookRoom(BookingDto bookingDto, int roomId, int userId){
		Room room=roomDao.findbyRoomId(roomId);
		User user=userDao.findByUserId(userId);
		if(user!=null && room!=null && room.isAvailable()) {
			Booking booking=modelMapper.map(bookingDto, Booking.class);
			booking.setUser(user);
			booking.setRoom(room);
			booking.setCheckinTime(LocalDateTime.now());
			
			if(room.getType()==RoomType.AC) {
				booking.setTotalPrice(booking.getNumberOfGuest()*room.getPrice());
			}else {
				booking.setTotalPrice(booking.getNumberOfGuest()*room.getPrice());
			}
			room.setAvailable(false);
			roomDao.saveRoom(room);
			Booking savebooking=bookingDao.saveBooking(booking);
			
			ResponseStructure<Booking> responseStructure=new ResponseStructure<Booking>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Booking done");
			responseStructure.setData(savebooking);
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}else {
			throw new BookingIdNotFoundException("User or room not found or room is not available");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Booking>> vacateRoom(int bookingId) {
	    
	    Booking booking = bookingDao.findbyBookingId(bookingId);
	    if (booking != null) {
	        Room room = booking.getRoom();
	        if (room != null) {
	            room.setAvailable(true); 
	            roomDao.saveRoom(room); 
	        }
	        booking.setRoom(null);
	        booking.setUser(null);
	        booking.setCheckoutTime(LocalDateTime.now());
	    
	        Booking removedBooking = bookingDao.deleteBooking(bookingId);
	        
	        ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
	        responseStructure.setStatusCode(HttpStatus.OK.value());
	        responseStructure.setMessage("Booking removed successfully");
	        responseStructure.setData(removedBooking);
	        
	        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	    } else {
	        throw new BookingIdNotFoundException("Booking ID not found");
	    }
	}
	
	public ResponseEntity<ResponseStructure<Booking>> findByBookingId(int bookingId){
		Booking dbBooking=bookingDao.findbyBookingId(bookingId);
		ResponseStructure<Booking> responseStructure=new ResponseStructure<>();
		if(dbBooking!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Booking found");
			responseStructure.setData(dbBooking);
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
		}else {
			throw new BookingIdNotFoundException("Booking ID not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> findAll(){
		List<Booking> bookingList=bookingDao.findAll();
		ResponseStructure<List<Booking>> responseStructure=new ResponseStructure<>();
		if(bookingList!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Bookings Found");
			responseStructure.setData(bookingList);
			return new ResponseEntity<ResponseStructure<List<Booking>>>(responseStructure,HttpStatus.OK);
		}else {
			throw new BookingIdNotFoundException("Bookings not found");
		}
	}
}
