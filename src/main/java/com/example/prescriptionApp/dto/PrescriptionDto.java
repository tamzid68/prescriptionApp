package com.example.prescriptionApp.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
public class PrescriptionDto {
    private Long id;
    private LocalDate prescriptionDate;
    private String patientName;
    private Integer patientAge;
    private String patientGender;
    private String diagnosis;
    private String medicines;
    private LocalDate nextVisitDate;
}
