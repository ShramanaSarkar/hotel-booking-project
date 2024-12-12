package com.hbp.Hotel_Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hbp.Hotel_Booking.entity.Room;
import com.hbp.Hotel_Booking.repository.RoomRepository;

@Repository
public class RoomDao {

	@Autowired
	private RoomRepository roomRepository;
	
	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}
	public Room findbyRoomId(int roomId) {
		Optional<Room> optional=roomRepository.findById(roomId);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	
	public Room updateRoom(int roomId, Room room) {
		Optional<Room> optional=roomRepository.findById(roomId);
		if(optional.isPresent()) {
			room.setRoomId(roomId);
			return roomRepository.save(room);
		}
		return null;
	}
	public Room deleteRoom(int roomId) {
	    Optional<Room> optional = roomRepository.findById(roomId);
	    if(optional.isPresent()) {
	    	roomRepository.delete(optional.get());
	    	return optional.get();
	    }
	    return null;
	}
	
	public List<Room> findAll() {
        return roomRepository.findAll();
    }
	
	
}
