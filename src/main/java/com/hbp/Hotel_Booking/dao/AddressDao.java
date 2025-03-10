package com.hbp.Hotel_Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hbp.Hotel_Booking.entity.Address;
import com.hbp.Hotel_Booking.repository.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public Address updateAddress(int addressId,Address address) {
		Optional<Address> optional=addressRepository.findById(addressId);
		if(optional.isPresent()) {
			address.setAddressId(addressId);
			addressRepository.save(address);
			return optional.get();
		}
		return null;
	}
	
	public Address findByAddressId(int addressId) {
		Optional<Address> optional=addressRepository.findById(addressId);
        return optional.orElse(null);
    }
	
	public Address deleteAddress(int addressId) {
		Optional<Address> optional=addressRepository.findById(addressId);
		if(optional.isPresent()) { 
			addressRepository.delete(optional.get());
			return optional.get();
		}
		return null;
	}
	
	public List<Address> findAll(){
		return addressRepository.findAll();
	}

}
