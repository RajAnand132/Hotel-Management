package com.hotelManagement.service;


import com.hotelManagement.model.Room;
import com.hotelManagement.model.RoomBooked;
import com.hotelManagement.repo.RoomBookedRepository;
import com.hotelManagement.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomBookedService {

    @Autowired
    RoomBookedRepository roomBookedRepository;
    @Autowired
    RoomRepository roomRepository;
    public Boolean isRoomAvailable(String checkInDate, String checkOutDate,Long roomId) {
        Long checkIn = new Date(checkInDate).getTime();
        Long checkOut = new Date(checkOutDate).getTime();
        List<RoomBooked> roomsAvailable =  roomBookedRepository.findByRoomIdAndCheckInBetweenAndCheckOut(roomId,checkIn,checkOut);
        return roomsAvailable.isEmpty(); // if not rooms booked then return true.
    }

    public void addRoomBooked(String checkInDate, String checkOutDate, Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow();
        RoomBooked roomBooked = new RoomBooked(checkInDate,checkOutDate,room);
        roomBookedRepository.save(roomBooked);
    }
}
