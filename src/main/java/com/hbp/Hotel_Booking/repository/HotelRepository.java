package com.hbp.Hotel_Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbp.Hotel_Booking.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
