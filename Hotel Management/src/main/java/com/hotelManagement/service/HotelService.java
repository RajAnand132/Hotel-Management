package com.hotelManagement.service;

import com.hotelManagement.model.Employees;
import com.hotelManagement.model.Hotel;
import com.hotelManagement.model.Room;
import com.hotelManagement.repo.EmployeesRepository;
import com.hotelManagement.repo.HotelRepository;
import com.hotelManagement.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private EmployeesRepository employeesRepository;


    public String createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return hotel.getName() + " with room maximum capacity " + hotel.getNumberOfRooms() + " added into the repository";
    }

    public List<Hotel> getHotels() {
       return hotelRepository.findAll();
    }

    public String updateHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return "Hotel Updated";
    }

    public Object getHotelById(Long hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if(optionalHotel.isPresent()){
            return optionalHotel;
        }
        else{
            return "No Hotel Found";
        }
    }
}
