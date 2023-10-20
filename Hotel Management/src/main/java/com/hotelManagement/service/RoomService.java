package com.hotelManagement.service;

import com.hotelManagement.model.Room;
import com.hotelManagement.model.enums.RoomType;
import com.hotelManagement.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    public String createRoom(Room room) {
        roomRepository.save(room);
        return "Room with ID " + room.getRoomId() + " added into the repository";
    }
    public List<Room> getrooms() {
        return roomRepository.findAll();
    }

    public Object searchRooms(Double hprice, Double lprice, RoomType roomType) {
        List<Room> rooms = roomRepository.findByPriceLessThanEqualAndPriceGreaterThanEqualAndRoomType(hprice,lprice,roomType);
        if(!rooms.isEmpty()){
            return rooms;
        }
        return "No Such type Of Rooms Available";
    }
}
