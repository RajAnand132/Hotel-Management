package com.hotelManagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hotelManagement.model.enums.Amenities;
import com.hotelManagement.model.enums.BedType;
import com.hotelManagement.model.enums.RoomType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Validated
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope=Room.class, property = "roomId")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    private BedType bedType;
    @Size(min = 1,max = 100)
    private String capacity;
    @Enumerated(EnumType.STRING)
    private List<Amenities> amenities;
    private Double price;

    /*
    The @ManyToOne annotation establishes a many-to-one relationship from this entity to 'Hotel'.
    The @JoinColumn specifies the column used for joining on the 'Hotel' entity, represented by 'fk_hotel_id'.
     */
    @ManyToOne
    @JoinColumn(name = "fk_hotel_id")
    private Hotel hotel;

    /*
    The @OneToMany annotation establishes a one-to-many relationship from this 'Room' entity to the 'Reservation' entity.
    The 'mappedBy' attribute specifies 'room' as the inverse side of the relationship in the 'Reservation' entity.
    This allows you to retrieve all reservations associated with a specific room.
    */
    //TODO: - No need to pass the IDs of class Reservation since the relationships are already defined here.
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

}
