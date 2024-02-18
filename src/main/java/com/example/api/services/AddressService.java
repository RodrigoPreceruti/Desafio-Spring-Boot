package com.example.api.services;

import com.example.api.address.Address;
import com.example.api.address.AddressResponseDTO;
import com.example.api.repositories.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressResponseDTO findAddressByDoctorId(Long id) {
        Address address = this.addressRepository.findAddressByDoctorId(id).orElseThrow(EntityNotFoundException::new);

        return new AddressResponseDTO(address);
    }
}
