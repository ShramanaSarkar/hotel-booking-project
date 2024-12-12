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

import com.hbp.Hotel_Booking.dto.RoomDto;
import com.hbp.Hotel_Booking.entity.Room;
import com.hbp.Hotel_Booking.service.RoomService;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	@PostMapping("/{hotelId}")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody RoomDto roomDto,@PathVariable int hotelId){
		return roomService.saveRoom(roomDto, hotelId);
	}
	@GetMapping("/{roomId}")
	public ResponseEntity<ResponseStructure<Room>> findByRoomId(@PathVariable int roomId){
		return roomService.findByRoomId(roomId);
	}
	@PutMapping("/{roomId}")
	public ResponseEntity<ResponseStructure<Room>> updateRoom(@RequestBody RoomDto roomDto,@PathVariable int roomId){
		return roomService.updateRoom(roomDto, roomId);
	}
	@DeleteMapping("/{roomId}")
	public ResponseEntity<ResponseStructure<Room>> deleteRoom(@PathVariable int roomId){
		return roomService.deleteRoom(roomId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Room>>> findAll(){
		return roomService.findAll();
	}

}
