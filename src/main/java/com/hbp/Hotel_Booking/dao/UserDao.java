package com.hbp.Hotel_Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hbp.Hotel_Booking.entity.User;
import com.hbp.Hotel_Booking.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User findByUserId(int userId) {
		Optional<User> optional=userRepository.findById(userId);
        return optional.orElse(null);
    }

	public User updateUser(int userId, User user) {
		Optional<User> optional=userRepository.findById(userId);
		if(optional.isPresent()) {
			user.setUserId(userId);
			return userRepository.save(user);
		}
		return null;
	}

	public User deleteUser(int userId) {
	    Optional<User> optional = userRepository.findById(userId);
	    if(optional.isPresent()) {
	    	userRepository.delete(optional.get());
	    	return optional.get();
	    }
	    return null;
	}
	
	public List<User> findAll() {
        return userRepository.findAll();
    }
}
