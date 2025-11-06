package com.example.prescriptionApp.controller;

import com.example.prescriptionApp.dto.PrescriptionDto;
import com.example.prescriptionApp.dto.PrescriptionRequest;
import com.example.prescriptionApp.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {
    private final PrescriptionService service;

    public PrescriptionController(PrescriptionService service){
        this.service = service;
    }

    @GetMapping
    public List<PrescriptionDto> list(
        @RequestParam(required = false) String from,
        @RequestParam(required = false) String to){

        LocalDate fromDate = (from != null) ? LocalDate.parse(from) : LocalDate.now().withDayOfMonth(1);
        LocalDate toDate = (to != null) ? LocalDate.parse(to) : LocalDate.now();
        return service.getbyDateRange(fromDate, toDate);
    }

    @PostMapping
    public PrescriptionDto create(@Valid @RequestBody PrescriptionRequest req){
        return service.create(req);
    }

    @PutMapping("/{id}")
    public PrescriptionDto update(@PathVariable Long id, @Valid @RequestBody PrescriptionRequest req){
        return service.update(id, req);
        }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
