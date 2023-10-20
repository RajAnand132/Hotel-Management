package com.hotelManagement.controller;


import com.hotelManagement.model.Employees;
import com.hotelManagement.model.Hotel;
import com.hotelManagement.model.Room;
import com.hotelManagement.service.EmployeesService;
import com.hotelManagement.service.HotelService;
import com.hotelManagement.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    EmployeesService employeesService;
    @Autowired
    RoomService roomService;
//    Hotel
    @PostMapping("/hotel")
    public String createHotel(@RequestBody @Valid Hotel hotel){
    return hotelService.createHotel(hotel);
}

    @PutMapping("/hotel")
    public String updateHotel(@RequestBody @Valid Hotel hotel){
        return hotelService.updateHotel(hotel);
    }

    @GetMapping("/hotel/{hotelId}")
    public Object getHotelById(@PathVariable Long hotelId){
        return hotelService.getHotelById(hotelId);
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

//    Employees
    @PostMapping("/employees")
    public String addEmployees(@RequestBody @Valid Employees employees){
        return employeesService.createEmployees(employees);
    }
    @PutMapping("/employees")
    public String updateEmployees(@RequestBody @Valid Employees employees){
        return employeesService.updateEmployees(employees);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployees(@PathVariable Long employeeId){
        return employeesService.deleteEmployees(employeeId);
    }
    @GetMapping("/employees/{employeeId}")
    public Object getEmployeeById(@PathVariable Long employeeId){
        return employeesService.getEmployeeIdById(employeeId);
    }
    @GetMapping("/employees")
    public List<Employees> getEmployees(){
        return employeesService.getEmployees();
    }
    //    Room
    @GetMapping("/rooms")
    public List<Room> getRooms(){
    return roomService.getrooms();
}
    @PostMapping("/room")
    public String createRoom(@RequestBody @Valid Room room){
        return roomService.createRoom(room);
    }

}
