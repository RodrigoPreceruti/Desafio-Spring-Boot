package com.example.api.doctor;

import com.example.api.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @OneToOne(mappedBy = "doctor")
    private Address address;

    public Doctor(DoctorRequestDTO doctorRequestDTO) {
        this.name = doctorRequestDTO.name();
        this.email = doctorRequestDTO.email();
        this.telephone = doctorRequestDTO.telephone();
        this.crm = doctorRequestDTO.crm();
        this.specialty = doctorRequestDTO.specialty();
    }
}
