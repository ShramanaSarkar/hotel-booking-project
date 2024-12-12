package com.hbp.Hotel_Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbp.Hotel_Booking.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
