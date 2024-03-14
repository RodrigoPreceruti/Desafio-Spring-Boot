package com.example.api.controllers;

import com.example.api.entities.doctor.DoctorRequestDTO;
import com.example.api.entities.doctor.DoctorResponseDTO;
import com.example.api.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> createDoctor(@RequestBody @Valid DoctorRequestDTO doctorRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.doctorService.createDoctor(doctorRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> findAllDoctors() {
        return ResponseEntity.status(HttpStatus.OK).body(this.doctorService.findAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> findDoctorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.doctorService.findDoctorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        this.doctorService.deleteDoctor(id);

        return ResponseEntity.noContent().build();
    }
}
