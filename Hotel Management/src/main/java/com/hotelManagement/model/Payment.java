package com.hotelManagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hotelManagement.model.enums.PaymentMethod;
import com.hotelManagement.model.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Validated
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Payment.class,property="paymentId")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Double paymentAmount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must match yyyy-MM-dd format")
    private String paymentDate;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    /*
    The @ManyToOne annotation establishes many-to-one relationships from this entity to other entities.
    - 'Reservation': Represents the reservation associated with this entry, and the relationship is based on the 'fk_reservation_id' column.
    - 'Guest': Represents the guest associated with this entry, and the relationship is based on the 'fk_guest_id' column.
     */

    //TODO: - Before using this class for payment please ensure that all other dependent classes(Reservation,Guest) data has been added into database.
    @ManyToOne
    @JoinColumn(name = "fk_reservation_id")
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "fk_guest_id")
    private Guest guest;

}
