package com.example.prescriptionApp.controller;

import com.example.prescriptionApp.dto.PrescriptionDto;
import com.example.prescriptionApp.dto.PrescriptionReportDto;
import com.example.prescriptionApp.dto.PrescriptionRequest;
import com.example.prescriptionApp.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {
    private final PrescriptionService service;

    public PrescriptionController(PrescriptionService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrescriptionDto> list(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        LocalDate fromDate = (from != null) ? LocalDate.parse(from) : LocalDate.now().withDayOfMonth(1);
        LocalDate toDate = (to != null) ? LocalDate.parse(to) : LocalDate.now();
        return service.getbyDateRange(fromDate, toDate);
    }

    @GetMapping("/report")
    public List<PrescriptionReportDto> report(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        LocalDate fromDate = (from != null) ? LocalDate.parse(from) : LocalDate.now().withDayOfMonth(1);
        LocalDate toDate = (to != null) ? LocalDate.parse(to) : LocalDate.now();
        return service.getReport(fromDate, toDate);
    }

    @PostMapping
    public PrescriptionDto create(@Valid @RequestBody PrescriptionRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public PrescriptionDto update(@PathVariable Long id, @RequestBody PrescriptionRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(Collections.singletonMap("message", "Prescription deleted successfully"));
    }


}
