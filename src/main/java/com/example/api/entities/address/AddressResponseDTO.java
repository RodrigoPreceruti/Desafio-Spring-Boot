package com.example.api.entities.address;

import com.example.api.entities.doctor.Doctor;

public record AddressResponseDTO(
        Long id,
        String logradouro,
        String neighborhood,
        String zipCode,
        String city,
        String state,
        String number,
        Doctor doctor) {
    public AddressResponseDTO(Address address) {
        this(address.getId(), address.getLogradouro(), address.getNeighborhood(), address.getZipCode(), address.getCity(), address.getState(), address.getNumber(), address.getDoctor());
    }
}
