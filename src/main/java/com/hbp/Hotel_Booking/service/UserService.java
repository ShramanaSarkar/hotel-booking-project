package com.hbp.Hotel_Booking.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hbp.Hotel_Booking.dao.AddressDao;
import com.hbp.Hotel_Booking.dao.UserDao;
import com.hbp.Hotel_Booking.dto.UserDto;
import com.hbp.Hotel_Booking.entity.Address;
import com.hbp.Hotel_Booking.entity.User;
import com.hbp.Hotel_Booking.exception.UserIdNotFoundException;
import com.hbp.Hotel_Booking.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(UserDto userDto, int addressId){
		Address dbAddress= addressDao.findByAddressId(addressId);
		User user=modelMapper.map(userDto, User.class);
		
		user.setAddress(dbAddress);
		userDao.saveUser(user);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("User saved");
		responseStructure.setData(user);
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> findByUserId(int userId){
		User dbUser=userDao.findByUserId(userId);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if(dbUser!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("User Found");
			responseStructure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}else {
			throw new UserIdNotFoundException("User id not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(UserDto userDto, int userId){
		User user=modelMapper.map(userDto, User.class);
		userDao.updateUser(userId, user);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("User Updated");
		responseStructure.setData(user);
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int userId){
		User dbUser=userDao.deleteUser(userId);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if(dbUser!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("User Deleted");
			responseStructure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}else {
			throw new UserIdNotFoundException("User not found");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<User>>> findAll(){
		List<User> userList=userDao.findAll();
		ResponseStructure<List<User>> responseStructure=new ResponseStructure<>();
		if(userList!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("User Found");
			responseStructure.setData(userList);
			return new ResponseEntity<ResponseStructure<List<User>>>(responseStructure,HttpStatus.OK);
		}else {
			throw new UserIdNotFoundException("User not found");
		}
	}


}
