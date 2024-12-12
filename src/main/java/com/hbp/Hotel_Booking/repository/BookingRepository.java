package com.hbp.Hotel_Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbp.Hotel_Booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
