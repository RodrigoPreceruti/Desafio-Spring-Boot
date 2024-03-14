package com.example.api.controllers;

import com.example.api.entities.address.Address;
import com.example.api.entities.address.AddressRequestDTO;
import com.example.api.entities.address.AddressResponseDTO;
import com.example.api.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> findAllAddresses() {
        return ResponseEntity.status(HttpStatus.OK).body(this.addressService.findAllAddresses());
    }

    @PostMapping
    public ResponseEntity<AddressResponseDTO> createAddress(@RequestBody @Valid AddressRequestDTO addressRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.addressService.createAddress(addressRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Address>> findAddressesByDoctorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.addressService.findAddressByDoctorId(id));
    }
}
