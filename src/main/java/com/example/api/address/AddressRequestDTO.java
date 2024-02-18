package com.example.api.address;

import jakarta.validation.constraints.NotBlank;

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
        String number) {
}
