package com.example.api.controllers;

import com.example.api.address.AddressResponseDTO;
import com.example.api.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> findAddressByDoctorId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.addressService.findAddressByDoctorId(id));
    }
}
