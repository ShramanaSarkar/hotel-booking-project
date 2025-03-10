# HotelBookingProject
HotelBookingProject

## Address:
saveAddress
findByAddressId
updateAddress
deleteAddress
fetchAllAddress()

## Address Object:
```
AddressDto {

	private int addressId;
	private int number;
	private String area;
	private String city;
	private String state;
	private long pincode;
}
```

## Booking:
bookRoom
findByBookingId
vacateRoom
findAll()
```
BookingDto {
	private int bookingId;
	private int numberOfGuest;
	private int totalPrice;
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;
}
```

## Hotel:
saveHotel
findByHotelId
updateHotel
deleteHotel
findAll()
```
HotelDto {
	private int hotelId;
	private String hotelName;
	private int rating;
}
```

## Room:
saveRoom
findByRoomId
updateRoom
deleteRoom
findAll()
```
RoomDto {
	private int roomId;
	private int roomNumber;
	private int price;
	private boolean available;
	private RoomType type;
}
```

## UserController:
saveUser
findByUserId
updateUser
deleteUser
findAll()
```
UserDto {
	private int userId;
	private String name;
	private String email;
	private String phoneNumber;
}
```
