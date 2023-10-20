package com.hotelManagement.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=RoomBooked.class,property="roomBookId")
public class RoomBooked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomBookId;
    private Long checkIn;
    private Long checkOut;
    @ManyToOne
    @JoinColumn(name = "fk_room_id")
    private Room room;

    public RoomBooked(String checkInDate, String checkOutDate, Room room) {
        this.checkIn = new Date(checkInDate).getTime();
        this.checkOut = new Date(checkOutDate).getTime();
        this.room = room;
    }
}













