package com.example.api.entities.address;

import com.example.api.entities.doctor.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private String neighborhood;

    private String zipCode;

    private String city;

    private String state;

    private String number;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Address(AddressRequestDTO addressDTO) {
        this.logradouro = addressDTO.logradouro();
        this.neighborhood = addressDTO.neighborhood();
        this.zipCode = addressDTO.zipcode();
        this.city = addressDTO.city();
        this.state = addressDTO.state();
        this.number = addressDTO.number();
        this.doctor = addressDTO.doctor();
    }
}
