package com.example.api.services;

import com.example.api.entities.doctor.Doctor;
import com.example.api.entities.doctor.DoctorRequestDTO;
import com.example.api.entities.doctor.DoctorResponseDTO;
import com.example.api.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = new Doctor(doctorRequestDTO);
        this.doctorRepository.save(doctor);

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
        Doctor doctor = this.doctorRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return new DoctorResponseDTO(doctor);
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = this.doctorRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        this.doctorRepository.delete(doctor);
    }
}
