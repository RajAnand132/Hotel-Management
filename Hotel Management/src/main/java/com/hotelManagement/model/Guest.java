package com.hotelManagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Guest.class,property="guestId")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;
    @NotBlank
    private String name;
    @Pattern(regexp = "\\+91\\d{10}")
    private String contactInformation;
    @NotNull
    private String address;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must match yyyy-MM-dd format")
    private String dateOfBirth;

    /*
     The @OneToMany annotations establish one-to-many relationships from this 'Guest' entity to other entities.
    - 'Reservation': Represents reservations associated with this guest, and the relationship is based on the 'guest' field in the 'Reservation' entity.
    - 'Payment': Represents payments associated with this guest, and the relationship is based on the 'guest' field in the 'Payment' entity.
    The @ManyToOne annotation establishes a many-to-one relationship from this 'Guest' entity to the 'Hotel' entity.
    The 'hotel' field represents the associated hotel for this guest, and the relationship is based on the 'fk_hotel_id' column.
     */

    //TODO: No need to pass the ID of class Guest class since the relationships are already defined here.
    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations;

    //TODO: No need to pass the ID of class Guest since the relationships are already defined here.
    @OneToMany(mappedBy = "guest")
    private List<Payment> payments;

    //TODO: - Before using this class please ensure that all other dependent classes(Hotel) data has been added into database.
    @ManyToOne
    @JoinColumn(name = "fk_hotel_id")
    private Hotel hotel;
}
