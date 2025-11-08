package com.example.prescriptionApp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/api/v1/health")
    public String privateHealth(){
        return "ok (secured)";
    }

}
