package com.hotelManagement.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hotelManagement.model.RoomBooked;

import java.util.List;

@Repository
public interface RoomBookedRepository extends JpaRepository<RoomBooked,Long> {
    List<RoomBooked> findByRoomIdAndCheckInBetweenAndCheckOut(Long roomId, Long checkIn, Long checkOut);
}
