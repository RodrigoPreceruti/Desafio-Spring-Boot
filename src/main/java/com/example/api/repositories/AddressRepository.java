package com.example.api.repositories;

import com.example.api.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findAddressByDoctorId(Long id);
}
