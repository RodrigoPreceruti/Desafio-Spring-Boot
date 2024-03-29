package com.example.api.repositories;

import com.example.api.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<List<Address>> findAddressesByDoctorId(Long doctorId);
}
