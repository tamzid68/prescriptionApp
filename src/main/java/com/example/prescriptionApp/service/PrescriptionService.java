package com.example.prescriptionApp.service;

import com.example.prescriptionApp.dto.PrescriptionDto;
import com.example.prescriptionApp.dto.PrescriptionReportDto;
import com.example.prescriptionApp.dto.PrescriptionRequest;
import com.example.prescriptionApp.entity.Prescription;
import com.example.prescriptionApp.exception.ResourceNotFoundException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.prescriptionApp.repository.PrescriptionRepository;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class PrescriptionService {
    private final PrescriptionRepository repo;

    public PrescriptionService(PrescriptionRepository repo){
        this.repo = repo;
    }

    public List<PrescriptionDto> getbyDateRange(LocalDate start, LocalDate end){
        return repo.findbyDataRange(start, end).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PrescriptionDto create(PrescriptionRequest req){
        Prescription p = new Prescription();
        copy(req,p);
        repo.save(p);
        return toDto(p);
    }

    public PrescriptionDto update(Long id, PrescriptionRequest req) {
        Prescription p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with id"+id));


        if (req.getPrescriptionDate() != null)
            p.setPrescriptionDate(req.getPrescriptionDate());
        if (req.getPatientName() != null && !req.getPatientName().isBlank())
            p.setPatientName(req.getPatientName());
        if (req.getPatientAge() != null)
            p.setPatientAge(req.getPatientAge());
        if (req.getPatientGender() != null && !req.getPatientGender().isBlank())
            p.setPatientGender(req.getPatientGender());
        if (req.getDiagnosis() != null)
            p.setDiagnosis(req.getDiagnosis());
        if (req.getMedicines() != null)
            p.setMedicines(req.getMedicines());
        if (req.getNextVisitDate() != null)
            p.setNextVisitDate(req.getNextVisitDate());

        repo.save(p);
        return toDto(p);
    }

    public List<PrescriptionReportDto> getReport(LocalDate from, LocalDate to){
        List<Object[]> results = repo.countByDateRange(from, to);
        return results.stream()
                .map(r -> new PrescriptionReportDto((LocalDate) r[0], (Long) r[1]))
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        repo.deleteById(id);
    }


    private void copy(PrescriptionRequest src, Prescription dest){
        dest.setPrescriptionDate(src.getPrescriptionDate());
        dest.setPatientName(src.getPatientName());
        dest.setPatientAge(src.getPatientAge());
        dest.setPatientGender(src.getPatientGender());
        dest.setDiagnosis(src.getDiagnosis());
        dest.setMedicines(src.getMedicines());
        dest.setNextVisitDate(src.getNextVisitDate());
    }

    private PrescriptionDto toDto(Prescription p){
        PrescriptionDto dto = new PrescriptionDto();
        dto.setId(p.getId());
        dto.setPrescriptionDate(p.getPrescriptionDate());
        dto.setPatientName(p.getPatientName());
        dto.setPatientAge(p.getPatientAge());
        dto.setPatientGender(p.getPatientGender());
        dto.setDiagnosis(p.getDiagnosis());
        dto.setMedicines(p.getMedicines());
        dto.setNextVisitDate(p.getNextVisitDate());
        return dto;
    }

}
