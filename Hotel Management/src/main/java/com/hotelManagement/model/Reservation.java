package com.hotelManagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hotelManagement.model.enums.RoomType;
import com.hotelManagement.model.enums.ReservationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Validated
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Reservation.class,property="reservationId")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @NotBlank
    private String guestName;
    @Pattern(regexp = "\\+91\\d{10}")
    private String guestContactInformation;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must match yyyy-MM-dd format")
    private String checkInDate;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must match yyyy-MM-dd format")
    private String checkOutDate;
    @Size(min = 1,max = 100)
    private String numberOfGuests;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Size(min = 1,max = 100)
    private String roomNumber;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    /*
    The @ManyToOne annotation establishes many-to-one relationships from this entity to other entities.
    - 'Guest': Represents the guest associated with this entry, and the relationship is based on the 'fk_guest_id' column.
    - 'Room': Represents the room associated with this entry, and the relationship is based on the 'fk_room_id' column.
    - 'Hotel': Represents the hotel associated with this entry, and the relationship is based on the 'fk_hotel_id' column.
     */
    //TODO: - Before using this class for reservation please ensure that all other dependent classes(Guest,Room,Hotel) data has been added into database.

    @ManyToOne
    @JoinColumn(name = "fk_guest_id")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "fk_room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "fk_hotel_id")
    private Hotel hotel;
}
