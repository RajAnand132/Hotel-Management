package com.hotelManagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hotelManagement.model.enums.Amenities;
import com.hotelManagement.model.enums.Packages;
import com.hotelManagement.model.enums.Star;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope=Hotel.class, property = "hotelId")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;
    @NotBlank
    private String name;
    @NotNull
    private String address;
    @Pattern(regexp = "\\+91\\d{10}")
    private String contactInformation;
    @NotNull
    private String website;
    private List<String> socialMediaLinks;
    private Integer numberOfRooms;
    @Enumerated(EnumType.STRING)
    private Star starRating;
    @Enumerated(EnumType.STRING)
    private List<Amenities> amenities;
    @Enumerated(EnumType.STRING)
    private List<Packages> packages;

    /*
    These @OneToMany annotations establish relationships between the 'Hotel' entity and other related entities.
    The 'mappedBy' attribute specifies the inverse side of the relationships and stopping infinity loops of mapping.
    This allows you to easily retrieve associated 'Room', 'Reservation', 'Guest', and 'Employee' entities for a 'Hotel' instance.
    */
    //TODO: No need to pass the IDs of any other classes since the relationships are already defined here.

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
    @OneToMany(mappedBy = "hotel")
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "hotel")
    private List<Guest> guests;
    @OneToMany(mappedBy = "hotel")
    private List<Employees> employees;
}
