package com.hotelManagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hotelManagement.model.enums.Department;
import com.hotelManagement.model.enums.JobTitle;
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
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Employees.class,property="employeeId")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @Pattern(regexp = "\\+91\\d{10}")
    private String contactInformation;
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
    @Enumerated(EnumType.STRING)
    private Department department;

    /*
    The @ManyToOne annotation establishes a many-to-one relationship from this entity to the 'Hotel' entity.
    The 'hotel' field represents the associated hotel for this entity, and the relationship is based on the 'fk_hotel_id' column.
     */

    //TODO: - Before using this class for employees please ensure that other dependent class(Hotel) data has been added into database.
    @ManyToOne
    @JoinColumn(name = "fk_hotel_id")
    private Hotel hotel;

}
