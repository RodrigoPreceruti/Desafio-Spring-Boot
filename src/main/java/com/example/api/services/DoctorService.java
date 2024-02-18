package com.example.api.services;

import com.example.api.address.Address;
import com.example.api.doctor.Doctor;
import com.example.api.doctor.DoctorRequestDTO;
import com.example.api.doctor.DoctorResponseDTO;
import com.example.api.repositories.AddressRepository;
import com.example.api.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AddressRepository addressRepository;

    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = new Doctor(doctorRequestDTO);
        Address address = new Address(doctorRequestDTO.address());
        address.setDoctor(doctor);

        this.doctorRepository.save(doctor);
        this.addressRepository.save(address);

        return new DoctorResponseDTO(doctor);
    }

    public List<DoctorResponseDTO> findAllDoctors() {
        return this.doctorRepository
                .findAll()
                .stream()
                .map(DoctorResponseDTO::new)
                .toList();
    }

    public DoctorResponseDTO findDoctorById(Long id) {
        Doctor doctor = this.doctorRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return new DoctorResponseDTO(doctor);
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = this.doctorRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        this.doctorRepository.delete(doctor);
    }
}
