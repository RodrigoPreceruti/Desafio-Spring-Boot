package com.example.api.doctor;

import com.example.api.address.AddressRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoctorRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telephone,
        @NotBlank
        String crm,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        AddressRequestDTO address) {
}
