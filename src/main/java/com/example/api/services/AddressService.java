package com.example.api.services;

import com.example.api.entities.address.Address;
import com.example.api.entities.address.AddressRequestDTO;
import com.example.api.entities.address.AddressResponseDTO;
import com.example.api.entities.doctor.Doctor;
import com.example.api.repositories.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<AddressResponseDTO> findAllAddresses() {
        return this.addressRepository
                .findAll()
                .stream()
                .map(AddressResponseDTO::new)
                .toList();
    }

    public AddressResponseDTO createAddress(AddressRequestDTO addressRequestDTO) {
        Address address = new Address(addressRequestDTO);
        this.addressRepository.save(address);

        return new AddressResponseDTO(address);
    }

    public List<Address> findAddressByDoctorId(Long id) {
        return this.addressRepository
                .findAddressesByDoctorId(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
