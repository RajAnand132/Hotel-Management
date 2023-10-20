package com.hotelManagement.repo;

import com.hotelManagement.model.Room;
import com.hotelManagement.model.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    List<Room> findByPriceLessThanEqualAndPriceGreaterThanEqualAndRoomType(Double hprice, Double lprice, RoomType roomType);
}
