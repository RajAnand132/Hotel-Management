package com.hotelManagement.controller;

import com.hotelManagement.model.Guest;
import com.hotelManagement.model.Payment;
import com.hotelManagement.model.Reservation;
import com.hotelManagement.model.enums.RoomType;
import com.hotelManagement.service.PaymentService;
import com.hotelManagement.service.ReservationService;
import com.hotelManagement.service.RoomService;
import com.hotelManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        return reservationService.bookRoom(reservation);
    }
    @GetMapping("/search/room/{hprice}/{lprice}/roomType")
    public Object searchRooms(@PathVariable Double hprice, @PathVariable Double lprice, @RequestParam RoomType roomType){
        return roomService.searchRooms(hprice,lprice,roomType);
    }
}





