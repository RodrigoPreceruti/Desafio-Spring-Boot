package com.example.api.entities.address;

import com.example.api.entities.doctor.Doctor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressRequestDTO(
        @NotBlank
        String logradouro,
        @NotBlank
        String neighborhood,
        @NotBlank
        String zipcode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String complement,
        String number,
        @NotNull
        Doctor doctor) {
}
