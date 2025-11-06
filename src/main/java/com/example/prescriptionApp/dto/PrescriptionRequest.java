package com.example.prescriptionApp.dto;

import jakarta.validation.constraints.*;
import lombok.*;
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
