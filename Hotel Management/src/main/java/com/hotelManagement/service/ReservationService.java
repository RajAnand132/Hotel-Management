package com.hotelManagement.service;

import com.hotelManagement.model.Reservation;
import com.hotelManagement.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    public Long bookRoom(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation.getReservationId();
    }
}
