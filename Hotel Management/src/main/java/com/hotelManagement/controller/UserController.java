package com.hotelManagement.controller;

import com.hotelManagement.model.Guest;
import com.hotelManagement.model.Payment;
import com.hotelManagement.model.Reservation;
import com.hotelManagement.model.enums.RoomType;
import com.hotelManagement.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    RoomService roomService;

    @Autowired
    RoomBookedService roomBookedService;


    @PostMapping("/guest")
    public String createGuest(@RequestBody @Valid Guest guest){
        return userService.createUser(guest);
    }

    @PostMapping("/reservation/payment")
    public String reservationPayment(@RequestBody @Valid Payment payment){
        return paymentService.reservationPayment(payment);
    }


//   Room

    @PostMapping("/reservation/room")
    public String bookRoom(@RequestBody @Valid Reservation reservation){
        //check if room is available in RoomBooked
        Boolean isRoomAvailable = roomBookedService.isRoomAvailable(reservation.getCheckInDate(),reservation.getCheckOutDate(),reservation.getRoom().getRoomId());
        //if not throw a message to user
        if(!isRoomAvailable){
            return "Room Not Available";
        }
        //add the same in RoomBooked table
        roomBookedService.addRoomBooked(reservation.getCheckInDate(),reservation.getCheckOutDate(),reservation.getRoom().getRoomId());
        // return reservation id for payment.
        Long id = reservationService.bookRoom(reservation);
        return "Please make Payment for " + id.toString();
    }
    @GetMapping("/search/room/{hprice}/{lprice}/roomType")
    public Object searchRooms(@PathVariable Double hprice, @PathVariable Double lprice, @RequestParam RoomType roomType){
        return roomService.searchRooms(hprice,lprice,roomType);
    }
}





