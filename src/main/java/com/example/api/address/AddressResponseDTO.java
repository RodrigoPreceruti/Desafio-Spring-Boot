package com.example.api.address;

public record AddressResponseDTO(
        Long id,
        String logradouro,
        String neighborhood,
        String zipCode,
        String city,
        String state,
        String number) {
    public AddressResponseDTO(Address address) {
        this(address.getId(), address.getLogradouro(), address.getNeighborhood(), address.getZipCode(), address.getCity(), address.getState(), address.getNumber());
    }
}
