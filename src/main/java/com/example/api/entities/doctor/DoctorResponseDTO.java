package com.example.api.entities.doctor;

public record DoctorResponseDTO(Long id, String name, String email, String telephone, String crm, Specialty specialty) {
    public DoctorResponseDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getTelephone(), doctor.getCrm(), doctor.getSpecialty());
    }
}
