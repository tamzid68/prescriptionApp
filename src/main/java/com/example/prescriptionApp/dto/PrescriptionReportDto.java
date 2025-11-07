package com.example.prescriptionApp.dto;

import java.time.LocalDate;

public class PrescriptionReportDto {
    private LocalDate date;
    private long count;

    public PrescriptionReportDto(LocalDate date, long count) {
        this.date = date;
        this.count = count;
    }
    public LocalDate getDate() {
        return date;
    }

    public long getCount() {
        return count;
    }
}
