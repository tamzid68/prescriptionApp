package com.example.prescriptionApp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PrescriptionRequest {
    @NotNull
    private LocalDate prescriptionDate;

    @NotBlank
    private String patientName;

    @NotNull
    @Min(0)
    @Max(120)
    private Integer patientAge;

    @NotBlank
    private String patientGender;

    private String diagnosis;
    private String medicines;
    private LocalDate nextVisitDate;
}
