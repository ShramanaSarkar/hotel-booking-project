package com.hbp.Hotel_Booking.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hbp.Hotel_Booking.dao.HotelDao;
import com.hbp.Hotel_Booking.dao.RoomDao;
import com.hbp.Hotel_Booking.dto.RoomDto;
import com.hbp.Hotel_Booking.entity.Hotel;
import com.hbp.Hotel_Booking.entity.Room;
import com.hbp.Hotel_Booking.enumdata.RoomType;
import com.hbp.Hotel_Booking.exception.RoomIdNotFoundException;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructure<Room>> saveRoom(RoomDto roomDto, int hotelId){
		
		Hotel dbhotel=hotelDao.findByHotelId(hotelId);
		Room room=modelMapper.map(roomDto, Room.class);
		
		room.setHotel(dbhotel);
		room.setType(RoomType.AC);
		roomDao.saveRoom(room);
		
		ResponseStructure<Room> responseStructure=new ResponseStructure<Room>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Room Saved");
		responseStructure.setData(room);
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<Room>> findByRoomId(int roomId){
		Room dbRoom=roomDao.findbyRoomId(roomId);
		ResponseStructure<Room> responseStructure=new ResponseStructure<>();
		if(dbRoom!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Room found");
			responseStructure.setData(dbRoom);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
		}else {
			throw new RoomIdNotFoundException("Room id not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> updateRoom(RoomDto roomDto, int roomId){
		Room room=modelMapper.map(roomDto, Room.class);
		roomDao.updateRoom(roomId, room);
		ResponseStructure<Room> responseStructure=new ResponseStructure<Room>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Room Updated");
		responseStructure.setData(room);
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Room>> deleteRoom(int roomId){
		Room dbRoom=roomDao.deleteRoom(roomId);
		ResponseStructure<Room> responseStructure=new ResponseStructure<>();
		if(dbRoom!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Room Deleted");
			responseStructure.setData(dbRoom);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
		}else {
			throw new RoomIdNotFoundException("Room not found");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Room>>> findAll(){
		List<Room> roomList=roomDao.findAll();
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
		if(roomList!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Room Found");
			responseStructure.setData(roomList);
			return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.OK);
		}else {
			throw new RoomIdNotFoundException("Room  not found");
		}
	}
}
